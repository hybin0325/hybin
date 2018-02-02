package net.medcrm.yjb.workflow.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.his.mybatis.dynamicDataSource.page.PageInfo;

import net.medcrm.yjb.his.tool.BeanUtilEx;
import net.medcrm.yjb.workflow.domain.Shenpi;
import net.medcrm.yjb.workflow.mapper.ShenpiMapper;
import net.medcrm.yjb.workflow.service.IShenpiService;
import net.medcrm.yjb.workflow.util.ActivitiUtils;
import net.medcrm.yjb.workflow.util.WorkFlowType;
import net.medcrm.yjb.workflow.vo.ShenpiVO;
import net.medcrm.yjb.workflow.vo.TaskVO;

@Transactional
@Service
public class ShenpiServiceImpl implements IShenpiService {
	private static Logger logger = LoggerFactory.getLogger(ShenpiServiceImpl.class);
	@Autowired
	private ShenpiMapper shenpiManager;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	protected TaskService taskService;

	@Autowired
	protected HistoryService historyService;

	@Autowired
	protected RepositoryService repositoryService;

	@Autowired
	private IdentityService identityService;

	@Override
	@Transactional
	public ProcessInstance startWorkflow(Shenpi entity, Map<String, Object> variables) {
		shenpiManager.insert(entity);
		logger.debug("save entity: {}", entity);
		String businessKey = entity.getId().toString();

		ProcessInstance processInstance = null;
		try {
			// 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
			identityService.setAuthenticatedUserId(entity.getUserId());

			processInstance = runtimeService.startProcessInstanceByKey(WorkFlowType.SHENPI.getIndex(), businessKey,
					variables);
			String processInstanceId = processInstance.getId();
			entity.setProcessInstanceId(processInstanceId);
			logger.debug("start process of {key={}, bkey={}, pid={}, variables={}}",
					new Object[] { WorkFlowType.SHENPI.getIndex(), businessKey, processInstanceId, variables });
		} finally {
			identityService.setAuthenticatedUserId(null);
		}
		return processInstance;
	}

	@Override
	public PageInfo<ShenpiVO> findTodoTasks(String userId, PageInfo<ShenpiVO> page, int[] pageParams) {
		List<ShenpiVO> results = new ArrayList<ShenpiVO>();

		// 根据当前人的ID查询
		TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned(userId);
		List<Task> tasks = taskQuery.listPage(pageParams[0], pageParams[1]);

		// 根据流程的业务ID查询实体并关联
		try {
			for (Task task : tasks) {
				String processInstanceId = task.getProcessInstanceId();
				ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
						.processInstanceId(processInstanceId).active().singleResult();
				if (processInstance == null) {
					continue;
				}
				String businessKey = processInstance.getBusinessKey();
				if (businessKey == null) {
					continue;
				}
				Shenpi shenpi = shenpiManager.selectByPrimaryKey(businessKey);
				ShenpiVO shenpiVO = new ShenpiVO();
				BeanUtilEx.copyProperties(shenpiVO, shenpi);

				shenpiVO.setTask(ActivitiUtils.toConverterTaskVO(task));
				shenpiVO.setProcessInstance(ActivitiUtils.toConverterProcessInstanceVO(processInstance,null));
				shenpiVO.setProcessDefinition(ActivitiUtils.toConverterProcessDefinitionVO(
						getProcessDefinition(processInstance.getProcessDefinitionId())));
				results.add(shenpiVO);
			}

		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		page.setTotal(taskQuery.count());
		page.setList(results);
		return page;
	}

	@Override
	public List<Shenpi> findRunningProcessInstaces(PageInfo<Shenpi> page, int[] pageParams) {
		List<Shenpi> results = new ArrayList<Shenpi>();
		ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery()
				.processDefinitionKey(WorkFlowType.SHENPI.getIndex()).active().orderByProcessInstanceId().desc();
		List<ProcessInstance> list = query.listPage(pageParams[0], pageParams[1]);

		// 关联业务实体
		for (ProcessInstance processInstance : list) {
			String businessKey = processInstance.getBusinessKey();
			if (businessKey == null) {
				continue;
			}
			Shenpi shenpi = shenpiManager.selectByPrimaryKey(businessKey);
			shenpi.setProcessInstance(processInstance);
			shenpi.setProcessDefinition(getProcessDefinition(processInstance.getProcessDefinitionId()));
			results.add(shenpi);

			// 设置当前任务信息
			List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).active()
					.orderByTaskCreateTime().desc().listPage(0, 1);
			shenpi.setTask(tasks.get(0));
		}

		page.setTotal(query.count());
		page.setList(results);
		return results;
	}

	protected ProcessDefinition getProcessDefinition(String processDefinitionId) {
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		return processDefinition;
	}

}
