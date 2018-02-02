package net.medcrm.yjb.workflow.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.TaskServiceImpl;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.javax.el.ExpressionFactory;
import org.activiti.engine.impl.javax.el.ValueExpression;
import org.activiti.engine.impl.juel.ExpressionFactoryImpl;
import org.activiti.engine.impl.juel.SimpleContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.log.LoggerUtils;
import net.medcrm.yjb.workflow.mapper.ActReProcdefMapper;
import net.medcrm.yjb.workflow.service.IHflowHandleService;
import net.medcrm.yjb.workflow.service.IHflowSignatureService;
import net.medcrm.yjb.workflow.vo.IdentitylinkVO;

@Service
public class HflowHandleServiceImpl implements IHflowHandleService {
	
	
	@Autowired
	private ActReProcdefMapper actReProcdefMapper;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private IHflowSignatureService flowSignatureService;


	/**
	 * 获取下一个用户任务用户组信息
	 * 
	 * @param String
	 *            taskId 任务Id信息
	 * @return 下一个用户任务用户组信息
	 * @throws Exception
	 */
	public Set<Expression> getNextTaskGroup(String taskId) throws Exception {

		ProcessDefinitionEntity processDefinitionEntity = null;

		String id = null;

		TaskDefinition task = null;

		// 获取流程实例Id信息
		String processInstanceId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();

		// 获取流程发布Id信息
		String definitionId = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId)
				.singleResult().getProcessDefinitionId();

		processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
				.getDeployedProcessDefinition(definitionId);

		ExecutionEntity execution = (ExecutionEntity) runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();

		// 当前流程节点Id信息
		String activitiId = execution.getActivityId();

		// 获取流程所有节点信息
		List<ActivityImpl> activitiList = processDefinitionEntity.getActivities();

		// 遍历所有节点信息
		for (ActivityImpl activityImpl : activitiList) {
			id = activityImpl.getId();

			// 找到当前节点信息
			if (activitiId.equals(id)) {

				// 获取下一个节点信息
				task = nextTaskDefinition(activityImpl, activityImpl.getId(), null, processInstanceId);

				break;
			}
		}
		if (task == null)
			return null;
		return task.getCandidateGroupIdExpressions();
	}

	/**
	 * 下一个任务节点信息,
	 * 
	 * 如果下一个节点为用户任务则直接返回,
	 * 
	 * 如果下一个节点为排他网关, 获取排他网关Id信息, 根据排他网关Id信息和execution获取流程实例排他网关Id为key的变量值,
	 * 根据变量值分别执行排他网关后线路中的el表达式, 并找到el表达式通过的线路后的用户任务信息
	 * 
	 * @param ActivityImpl
	 *            activityImpl 流程节点信息
	 * @param String
	 *            activityId 当前流程节点Id信息
	 * @param String
	 *            elString 排他网关顺序流线段判断条件, 例如排他网关顺序留线段判断条件为${money>1000},
	 *            若满足流程启动时设置variables中的money>1000, 则流程流向该顺序流信息
	 * @param String
	 *            processInstanceId 流程实例Id信息
	 * @return
	 */
	private TaskDefinition nextTaskDefinition(ActivityImpl activityImpl, String activityId, String elString,
			String processInstanceId) {

		PvmActivity ac = null;

		Object s = null;

		// 如果遍历节点为用户任务并且节点不是当前节点信息
		if ("userTask".equals(activityImpl.getProperty("type")) && !activityId.equals(activityImpl.getId())) {
			// 获取该节点下一个节点信息
			TaskDefinition taskDefinition = ((UserTaskActivityBehavior) activityImpl.getActivityBehavior())
					.getTaskDefinition();
			return taskDefinition;
		} else {
			// 获取节点所有流向线路信息
			List<PvmTransition> outTransitions = activityImpl.getOutgoingTransitions();
			List<PvmTransition> outTransitionsTemp = null;
			for (PvmTransition tr : outTransitions) {
				ac = tr.getDestination(); // 获取线路的终点节点
				// 如果流向线路为排他网关
				if ("exclusiveGateway".equals(ac.getProperty("type"))) {
					outTransitionsTemp = ac.getOutgoingTransitions();

					// 如果网关路线判断条件为空信息
					if (StringUtils.isEmpty(elString)) {
						// 获取流程启动时设置的网关判断条件信息
						elString = getGatewayCondition(ac.getId(), processInstanceId);
					}

					// 如果排他网关只有一条线路信息
					if (outTransitionsTemp.size() == 1) {
						return nextTaskDefinition((ActivityImpl) outTransitionsTemp.get(0).getDestination(), activityId,
								elString, processInstanceId);
					} else if (outTransitionsTemp.size() > 1) { // 如果排他网关有多条线路信息
						for (PvmTransition tr1 : outTransitionsTemp) {
							s = tr1.getProperty("conditionText"); // 获取排他网关线路判断条件信息
							// 判断el表达式是否成立
							if (isCondition(ac.getId(), StringUtils.trim(s.toString()), elString)) {
								return nextTaskDefinition((ActivityImpl) tr1.getDestination(), activityId, elString,
										processInstanceId);
							}
						}
					}
				} else if ("userTask".equals(ac.getProperty("type"))) {
					return ((UserTaskActivityBehavior) ((ActivityImpl) ac).getActivityBehavior()).getTaskDefinition();
				} else {
				}
			}
			return null;
		}
	}

	/**
	 * 查询流程启动时设置排他网关判断条件信息
	 * 
	 * @param String
	 *            gatewayId 排他网关Id信息, 流程启动时设置网关路线判断条件key为网关Id信息
	 * @param String
	 *            processInstanceId 流程实例Id信息
	 * @return
	 */
	public String getGatewayCondition(String gatewayId, String processInstanceId) {
		Execution execution = runtimeService.createExecutionQuery().processInstanceId(processInstanceId).singleResult();
		try {
			return runtimeService.getVariable(execution.getId(), gatewayId).toString();
		} catch (Exception e) {
			return "true";
		}
	}

	/**
	 * 根据key和value判断el表达式是否通过信息
	 * 
	 * @param String
	 *            key el表达式key信息
	 * @param String
	 *            el el表达式信息
	 * @param String
	 *            value el表达式传入值信息
	 * @return
	 */
	public boolean isCondition(String key, String el, String value) {
		ExpressionFactory factory = new ExpressionFactoryImpl();
		SimpleContext context = new SimpleContext();
		context.setVariable(key, factory.createValueExpression(value, String.class));
		ValueExpression ee = factory.createValueExpression(context, el, boolean.class);
		try {
			return (Boolean) ee.getValue(context);
		} catch (Exception e) {
			return true;
		}

	}

	/**
	 * 获取流程的下一个节点 且要经过规则引擎判断后的节点
	 * 
	 * @param taskId
	 * @return
	 */
	public List<FlowElement> getNextNode2(String taskId) {

		Task task = null;
		task = taskService.createTaskQuery().taskId(taskId).singleResult();
		if (task == null) {
			return null;
		}
		List<FlowElement> list = new ArrayList<FlowElement>();

		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
				.processInstanceId(task.getProcessInstanceId()).singleResult();

		// 当前活动节点
		String activitiId = processInstance.getActivityId();

		System.out.println("当前节点是【" + activitiId + "】");

		// pmmnModel 遍历节点需要它
		BpmnModel bpmnModel = repositoryService.getBpmnModel(task.getProcessDefinitionId());

		List<Process> processList = bpmnModel.getProcesses();

		// 循环多个物理流程
		for (Process process : processList) {

			// 返回该流程的所有任务，事件
			Collection<FlowElement> cColl = process.getFlowElements();
			// 遍历节点
			for (FlowElement f : cColl) {

				// 如果改节点是当前节点 者 输出该节点的下一个节点
				if (f.getId().equals(activitiId)) {

					List<SequenceFlow> sequenceFlowList = new ArrayList<SequenceFlow>();
					// 通过反射来判断是哪种类型
					if (f instanceof org.activiti.bpmn.model.StartEvent) {
						// 开始事件的输出路由
						sequenceFlowList = ((org.activiti.bpmn.model.StartEvent) f).getOutgoingFlows();
					} else if (f instanceof org.activiti.bpmn.model.UserTask) {

						sequenceFlowList = ((org.activiti.bpmn.model.UserTask) f).getOutgoingFlows();

						for (SequenceFlow sf : sequenceFlowList) {

							String targetRef = sf.getTargetRef();
							FlowElement ref = process.getFlowElement(targetRef);

							// nextActivitiIdList.add(ref.getId());

							list.add(ref);
						}

					} else if (f instanceof org.activiti.bpmn.model.SequenceFlow) {

					} else if (f instanceof org.activiti.bpmn.model.EndEvent) {
						sequenceFlowList = ((org.activiti.bpmn.model.EndEvent) f).getOutgoingFlows();
					}
					break;
				}

			}

		}
		return list;
	}

	/**
	 * 取下一个节点的审批人
	 * 
	 * @param taskId
	 * @return
	 */
	public List<String> getNextTaskUserByTaskId(String taskId) {
		List<String> list = new ArrayList<String>();
		List<FlowElement> fList = getNextNode2(taskId);
		for (FlowElement u : fList) {
			String str = ((org.activiti.bpmn.model.UserTask) u).getAssignee();
			list.add(str);
		}
		return list;
	}

	/**
	 * 设置某个节点的审批人员
	 * 
	 * @param taskId
	 * @param user
	 */
	public void setApproveUser(String taskId, String user) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		task.setAssignee(user);
		taskService.saveTask(task);
	}

	public Map<String,Object> getCurrentTaskInfo(String processInstanceId) throws Exception {
		Map<String,Object> map=new HashMap<>();
		ExecutionEntity execution = (ExecutionEntity) runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		// 当前流程节点Id信息
		String activitiId = execution.getActivityId();
		String name = execution.getCurrentActivityName();
		map.put("activitiId", activitiId);
		map.put("name", name);
		return map;

	}
	
	/**
	 * 办理
	 */
	@Transactional
	public void updateClaim(String taskId,String nextHandleUser,String opinion ,Map<String, Object> formProperties,EmployeeVO user) {
		//签收
		taskService.claim(taskId, user.getId());
		
		Task task= taskService.createTaskQuery().taskId(taskId).singleResult();
		
		String processInstanceId = task.getProcessInstanceId();
		
		flowSignatureService.saveHflowSignature(taskId, user, opinion);
		
		taskService.complete(taskId, formProperties);
		
		//更改办理人
		//updateHandler(processInstanceId, nextHandleUser);
		updateNextClaim(processInstanceId, nextHandleUser);
	}
	
	private void updateNextClaim(String processInstanceId,String nextHandleUser) {
		if(net.medcrm.yjb.workflow.util.StringUtils.isNull(nextHandleUser))
			return ;
		Task newTask= taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		taskService.claim(newTask.getId(), nextHandleUser);
	}
	
	
	/**
	 * 修改办理人
	 */
	@Transactional
	public void updateHandler(String processInstanceId,String nextHandleUser) {
		if(net.medcrm.yjb.workflow.util.StringUtils.isNull(nextHandleUser))
			return ;
		Task newTask= taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		LoggerUtils.debug(this.getClass(), newTask+"------------------------");
		//String hisTaskId= actReProcdefMapper.selectNewActHiTaskinst(newTask.getProcessInstanceId());
		//LoggerUtils.debug(this.getClass(), "---------------------------------"+hisTaskId);
		TaskServiceImpl taskServiceImpl=(TaskServiceImpl)taskService;
		
		List<IdentitylinkVO> arpList= actReProcdefMapper.selectActRuIdentitylinkList(newTask.getId());
		List<String> auLinkId=Lists.newArrayList();
		for (IdentitylinkVO vo : arpList) {
			//taskServiceImpl.deleteUserIdentityLink(newTask.getId(), vo.getUserId(), vo.getType());
			auLinkId.add(vo.getId());
		}
		actReProcdefMapper.deleteBatchActRuIdentitylink(auLinkId);
		taskServiceImpl.addUserIdentityLink(newTask.getId(), nextHandleUser, "candidate");
		
		//List<IdentitylinkVO> ahidList= actReProcdefMapper.selectActHiIdentitylinkList(hisTaskId);
	}
	
	
}
