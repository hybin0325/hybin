package net.medcrm.yjb.workflow.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import net.medcrm.yjb.workflow.domain.Consultation;
import net.medcrm.yjb.workflow.domain.User;
import net.medcrm.yjb.workflow.mapper.ConsultationMapper;
import net.medcrm.yjb.workflow.service.IConsultationService;

@Service(value = "consultationService")
public class ConsultationServiceImpl implements IConsultationService {
	private static Logger logger = LoggerFactory.getLogger(ConsultationServiceImpl.class);

	@Autowired
	private ConsultationMapper dao;

	@Resource(name = "identityService")
	private IdentityService identityService;

	@Resource(name = "runtimeService")
	private RuntimeService runtimeService;

	@Resource(name = "historyService")
	private HistoryService historyService;

	@Resource(name = "taskService")
	private TaskService taskService;

	@Resource(name = "managementService")
	private ManagementService managementService;

	@Resource // (name="formService")需要在xml配置
	private FormService formService;

	@Resource(name = "repositoryService")
	private RepositoryService repositoryService;
	
	@Autowired
    private RestTemplate restTemplate;

	
	@Override
	public int addConsultation(Consultation consultation) {
		consultation.setId(UUID.randomUUID().toString());
		return dao.insert(consultation);
	}

	@Override
	public List<Consultation> findAllConsultation(int pageNum, int pageSize) {
		return dao.selectAllUser();
	}

	@Override
	public Consultation findById(String id) {

		return dao.selectByPrimaryKey(id);
	}
	
	/**
	 * 启动工作流
	 */
	public ProcessInstance startWorkflow(String key,String businessKey,Map<String, Object> variables) {
		//根据流程定义的key启动工作流
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("consultation", businessKey, variables);
		return processInstance;
	}
	
	/**
     * 启动流程
     *
     * @param entity
     */
    public ProcessInstance startWorkflow(Consultation entity, Map<String, Object> variables) {
        dao.insert(entity);
        logger.debug("save entity: {}", entity);
        String businessKey = entity.getId().toString();

        ProcessInstance processInstance = null;
        try {
            // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
            identityService.setAuthenticatedUserId(entity.getApplyUserId());

            processInstance = runtimeService.startProcessInstanceByKey("leave", businessKey, variables);
            String processInstanceId = processInstance.getId();
            entity.setProcessInstanceId(processInstanceId);
            logger.debug("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[]{"leave", businessKey, processInstanceId, variables});
        } finally {
            identityService.setAuthenticatedUserId(null);
        }
        return processInstance;
    }

	@Override
	public List<Consultation> findFinishedProcessInstaces(String processDefinitionKey) {
		List<Consultation> consultations = new ArrayList<Consultation>();
		// 根据流程定义的key查询已经结束的流程实例(HistoricProcessInstance)
		List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery().finished()
				.processDefinitionKey(processDefinitionKey).list();
		// 关联业务实体
		for (HistoricProcessInstance historicProcessInstance : list) {
			String businessKey = historicProcessInstance.getBusinessKey();
			Consultation consultation = dao.selectByPrimaryKey(businessKey);
			consultation.setHistoricProcessInstance(historicProcessInstance);
			consultation.setProcessDefinition(getProcessDefinition(historicProcessInstance.getProcessDefinitionId()));
			consultations.add(consultation);
		}
		return consultations;
	}

	@Override
	public List<Consultation> findRunningProcessInstaces(String processDefinitionKey) {
		List<Consultation> consultations = new ArrayList<Consultation>();
		// runtimeService.createProcessInstanceQuery().processDefinitionKey(USERTASK_PROCESS)可知USERTASK_PROCESS为
		// runtimeService.startProcessInstanceByKey(USERTASK_PROCESS,
		// BUSINESS_KEY,variables);
		List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery()
				.processDefinitionKey(processDefinitionKey).list();
		// 关联业务实体
		for (ProcessInstance processInstance : processInstances) {
			String businessKey = processInstance.getBusinessKey();
			Consultation consultation = dao.selectByPrimaryKey(businessKey);
			consultation.setProcessInstance(processInstance);
			consultation.setProcessInstanceId(processInstance.getId());
			consultation.setProcessDefinition(getProcessDefinition(processInstance.getProcessDefinitionId()));
			// 设置当前任务信息
			// 根据流程实例id,按照任务创建时间降序排列,查询一条任务信息
			List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId())
					.orderByTaskCreateTime().desc().listPage(0, 1);
			consultation.setTask(tasks.get(0));
			consultations.add(consultation);
		}
		return consultations;
	}

	/**
	 * 根据用户Id查询待办任务列表
	 * 
	 * @param userid
	 *            用户id
	 * @param processDefinitionKey
	 *            流程定义的key
	 * @return
	 */
	// 问题时这里仅仅是当前用户的id来查询，如果流程定义下一任任务为组的话是无查询结果的
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Consultation> findUserTask(String userid, String processDefinitionKey) {
		// 存放当前用户的所有任务
		List<Task> tasks = new ArrayList<Task>();
		// 会诊
		List<Consultation> consultations = new ArrayList<Consultation>();

		// 根据当前用户的id查询代办任务列表(已经签收),可以查询taskService.claim(task.getId(),
		// "fozzie"); 认领后的任务
		List<Task> taskAssignees = taskService.createTaskQuery().processDefinitionKey(processDefinitionKey)
				.taskAssignee(userid).orderByTaskPriority().desc().orderByTaskCreateTime().desc().list();
		// 根据当前用户id查询未签收的任务列表，未被认领的任务
		List<Task> taskCandidates = taskService.createTaskQuery().processDefinitionKey(processDefinitionKey)
				.taskCandidateUser(userid).orderByTaskPriority().desc().orderByTaskCreateTime().desc().list();
		tasks.addAll(taskAssignees);// 添加已签收准备执行的任务(已经分配到任务的人)
		tasks.addAll(taskCandidates);// 添加还未签收的任务(任务的候选者)

		/*
		 * // 重新编写，某角色下的所有任务展示而非之前限定会诊流程 List<com.lin.domain.Group> gs =
		 * mapper.getGroupList(Long.valueOf(userid)); tasks =
		 * taskService.createTaskQuery().taskCandidateGroup("deptLeader").list()
		 * ;
		 */

		// 遍历所有的任务列表,关联实体
		for (Task task : tasks) {
			String processInstanceId = task.getProcessInstanceId();
			// 根据流程实例id查询流程实例
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
					.processInstanceId(processInstanceId).singleResult();
			// 获取业务id
			String businessKey = processInstance.getBusinessKey();
			// 查询请假实体
			Consultation consultation = dao.selectByPrimaryKey(businessKey);
			// 设置属性
			consultation.setTask(task);
			consultation.setProcessInstance(processInstance);
			consultation.setProcessInstanceId(processInstance.getId());
			consultation.setProcessDefinition(getProcessDefinition(processInstance.getProcessDefinitionId()));
			consultations.add(consultation);
		}
		return consultations;
	}

	@Override
	public List<Consultation> findGroupTask(String userid, List<Group> datas, String processDefinitionKey) {
		// 存放当前用户的所有任务
		List<Task> tasks = new ArrayList<Task>();
		// 存放所有請假單
		List<Consultation> consultations = new ArrayList<Consultation>();
		List<Task> gtasks = null;
		for (Group group : datas) {
			gtasks = taskService.createTaskQuery().taskCandidateGroup(group.getId()).list();// 获取用户组“T_MAN”所有的任务
			tasks.addAll(gtasks);
		}
		// 遍历所有的任务列表,关联实体
		for (Task task : tasks) {
			String processInstanceId = task.getProcessInstanceId();
			// 根据流程实例id查询流程实例
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
					.processInstanceId(processInstanceId).singleResult();
			// 获取业务id
			String businessKey = processInstance.getBusinessKey();
			// 查询请假实体
			Consultation consultation = dao.selectByPrimaryKey(businessKey);
			// 设置属性
			consultation.setTask(task);
			consultation.setProcessInstance(processInstance);
			consultation.setProcessInstanceId(processInstance.getId());
			consultation.setProcessDefinition(getProcessDefinition(processInstance.getProcessDefinitionId()));
			consultations.add(consultation);
		}
		return consultations;
	}

	/**
	 * 根据流程定义Id查询流程定义
	 */
	public ProcessDefinition getProcessDefinition(String processDefinitionId) {
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		return processDefinition;
	}
	
	/**
	 * 根据任务Id查询任务
	 * 
	 */
	public TaskEntity findTaskById(String taskId) throws Exception {
		TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId(taskId).singleResult();  
        if (task == null) {  
            throw new Exception("任务实例未找到!");  
        }  
        return task; 
	}
	
	/*@SuppressWarnings("unchecked")
	public List<User> findByAccount(String accountId) {
        return (List<User>) restTemplate.getForObject("http://MICROSERVICE-PROVIDER-USER/findUser", User.class);
    }*/

}
