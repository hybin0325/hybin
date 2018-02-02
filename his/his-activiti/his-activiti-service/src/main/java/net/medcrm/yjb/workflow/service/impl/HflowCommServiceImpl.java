package net.medcrm.yjb.workflow.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.context.Context;
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
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.image.ProcessDiagramGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.log.LoggerUtils;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.service.IHflowCommService;
import net.medcrm.yjb.workflow.util.HandleType;

@Service
public class HflowCommServiceImpl implements IHflowCommService {

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	@Autowired
	private ProcessEngine processEngine;

	@Autowired
	private ProcessEngineConfiguration processEngineConfiguration;

	@Autowired
	private TaskService taskService;

	/**
	 * 根据节点ID查询节点信息
	 * 
	 * @param activityId
	 * @return
	 */
	public Object getActivityImplInfo(String processDefinitionId, String activityId) {
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(processDefinitionId);
		ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);
		return activityImpl.getProperty("name");
	}

	public List<Object> getNodeInfo(String processDefinitionId) {
		List<Object> list = new ArrayList<>();
		BpmnModel model = repositoryService.getBpmnModel(processDefinitionId);
		if (model != null) {
			Collection<FlowElement> flowElements = model.getMainProcess().getFlowElements();
			for (FlowElement e : flowElements) {
				Map<String, Object> map = new HashMap<>();
				System.out.println("flowelement id:" + e.getId() + "  name:" + e.getName() + "   class:"
						+ e.getClass().toString());
				map.put("id", e.getId());
				map.put("name", e.getName());
				map.put("class", e.getClass().toString());
				list.add(map);
			}
		}

		return list;
	}

	@Override
	public Map<String, Object> getStartEventInfo(String processInstanceId) {
		ProcessInstance definition = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId)
				.singleResult();
		Map<String, Object> map = new HashMap<>();
		BpmnModel model = repositoryService.getBpmnModel(definition.getProcessDefinitionId());
		if (model != null) {
			Collection<FlowElement> flowElements = model.getMainProcess().getFlowElements();
			for (FlowElement e : flowElements) {
				if (e.getClass().toString().endsWith("StartEvent")) {
					map.put("id", e.getId());
					map.put("name", e.getName());
				}
			}
		}
		return map;
	}

	/**
	 * 根据与流程定义key获取当前节点的下一个任务节点,最新的流程
	 * 
	 * @param key
	 *            流程定义Key
	 * 
	 * @param elementId
	 *            当前节点Id
	 * @param elString
	 *            当前节点流向下一个节点的匹配字符串 如下 ${deptLeaderPass} ${!deptLeaderPass}
	 *            获取领导同意的userTask，则传入 ${deptLeaderPass}
	 * @return
	 */
	public TaskDefinition getNextTaskDefinition(String key, String activityId, String elString, boolean bFlag) {
		try {
			elString = URLDecoder.decode(elString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ProcessDefinition processDefinition = getNewProcessDefinition(key);
		if (processDefinition != null) {
			ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
					.getDeployedProcessDefinition(processDefinition.getId());
			ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);
			if ("userTask".equals(activityImpl.getProperty("type")) && !bFlag) {
				TaskDefinition taskDefinition = ((UserTaskActivityBehavior) activityImpl.getActivityBehavior())
						.getTaskDefinition();
				return taskDefinition;
			} else {
				List<PvmTransition> pvmTransitions = activityImpl.getOutgoingTransitions();
				List<PvmTransition> outpvmTransitions = null;
				for (PvmTransition pvmTransition : pvmTransitions) {
					PvmActivity pa = pvmTransition.getDestination();// 获取所有的终点节点
					if ("exclusiveGateway".equals(pa.getProperty("type"))) {
						outpvmTransitions = pa.getOutgoingTransitions();
						if (outpvmTransitions.size() == 1) {
							return getNextTaskDefinition(key, pa.getId(), elString, false);
						} else if (outpvmTransitions.size() > 1) {
							for (PvmTransition outPvmTransition : outpvmTransitions) {
								Object object = outPvmTransition.getProperty("conditionText");
								if (elString.equals(StringUtils.trim(object.toString()))) {
									PvmActivity pvmActivity = outPvmTransition.getDestination();
									return getNextTaskDefinition(key, pvmActivity.getId(), elString, false);
								}
							}
						}
					} else if ("userTask".equals(pa.getProperty("type"))) {
						return ((UserTaskActivityBehavior) ((ActivityImpl) pa).getActivityBehavior())
								.getTaskDefinition();
					}
				}
			}
		}
		return null;
	}

	public TaskDefinition getNextTaskDefinition2(String processInstanceId, String activityId, String elString,
			boolean bFlag) {
		try {
			elString = URLDecoder.decode(elString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ProcessDefinitionEntity processDefinitionEntity = getNewProcessDefinitionEntity(processInstanceId);
		if (processDefinitionEntity != null) {
			ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);
			if ("userTask".equals(activityImpl.getProperty("type")) && !bFlag) {
				TaskDefinition taskDefinition = ((UserTaskActivityBehavior) activityImpl.getActivityBehavior())
						.getTaskDefinition();
				return taskDefinition;
			} else {
				List<PvmTransition> pvmTransitions = activityImpl.getOutgoingTransitions();
				List<PvmTransition> outpvmTransitions = null;
				for (PvmTransition pvmTransition : pvmTransitions) {
					PvmActivity pa = pvmTransition.getDestination();// 获取所有的终点节点
					if ("exclusiveGateway".equals(pa.getProperty("type"))) {
						outpvmTransitions = pa.getOutgoingTransitions();
						if (outpvmTransitions.size() == 1) {
							return getNextTaskDefinition2(processInstanceId, pa.getId(), elString, false);
						} else if (outpvmTransitions.size() > 1) {
							for (PvmTransition outPvmTransition : outpvmTransitions) {
								Object object = outPvmTransition.getProperty("conditionText");
								if (elString.equals(StringUtils.trim(object.toString()))) {
									PvmActivity pvmActivity = outPvmTransition.getDestination();
									return getNextTaskDefinition2(processInstanceId, pvmActivity.getId(), elString,
											false);
								}
							}
						}
					} else if ("userTask".equals(pa.getProperty("type"))) {
						return ((UserTaskActivityBehavior) ((ActivityImpl) pa).getActivityBehavior())
								.getTaskDefinition();
					}
				}
			}
		}
		return null;
	}

	/**
	 * 得到节点详细信息
	 * 
	 * @param activityId
	 * @return
	 */
	public List<Map<String, Object>> getTaskDefinition(String processDefinitionId) {
		RepositoryService repositoryService = processEngine.getRepositoryService();
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId)
				.singleResult();
		// ProcessDefinition pd =getNewProcessDefinition(actKey) ;
		ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
				.getDeployedProcessDefinition(pd.getId());
		List<ActivityImpl> activitiList = processDefinition.getActivities();
		List<Map<String, Object>> res = Lists.newArrayList();
		for (ActivityImpl activityImpl : activitiList) {
			if ("userTask".equals(activityImpl.getProperty("type"))) {
				LoggerUtils.debug(this.getClass(), activityImpl.getProperty("name") + "----------");
				TaskDefinition taskDefinition = ((UserTaskActivityBehavior) activityImpl.getActivityBehavior())
						.getTaskDefinition();
				Set<Expression> setGroups = taskDefinition.getCandidateGroupIdExpressions();
				Set<Expression> setUsers = taskDefinition.getCandidateUserIdExpressions();

				Iterator<Expression> iterGroups = setGroups.iterator();
				Iterator<Expression> iterUsers = setUsers.iterator();
				ArrayList<String> alGroups = Lists.newArrayList();
				ArrayList<String> alUsers = Lists.newArrayList();
				while (iterGroups.hasNext()) {
					Expression expression = iterGroups.next();
					alGroups.add(expression.getExpressionText());
				}
				while (iterUsers.hasNext()) {
					Expression expression = iterUsers.next();
					alUsers.add(expression.getExpressionText());
				}
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", activityImpl.getId());
				map.put("name", activityImpl.getProperty("name"));
				if (net.medcrm.yjb.workflow.util.StringUtils.isNotNull(alUsers)) {
					String users = net.medcrm.yjb.workflow.util.StringUtils.listToString2(alUsers, ',');
					BaseResp<List<Map<String, Object>>> userList = employeeServiceClient.getEmpInfoList(users);
					map.put("users", userList.getData());
				} else {
					map.put("users", "");
				}
				if (net.medcrm.yjb.workflow.util.StringUtils.isNotNull(alGroups)) {
					String groups = net.medcrm.yjb.workflow.util.StringUtils.listToString2(alGroups, ',');
					BaseResp<List<Map<String, Object>>> groupList = employeeServiceClient.getEmpInfosList(groups);
					map.put("groups", groupList.getData());
				} else {
					map.put("groups", alGroups);
				}
				if (net.medcrm.yjb.workflow.util.StringUtils.isNull(taskDefinition.getAssigneeExpression())) {
					map.put("assignee", taskDefinition.getAssigneeExpression());
				} else {
					map.put("assignee", taskDefinition.getAssigneeExpression().getExpressionText());
				}

				res.add(map);
			}
		}
		return res;
	}

	/**
	 * 取上个节点的审批人
	 * 
	 * @param actKey
	 * @param processInstanceId
	 * @return
	 */
	public Object getBackUser(String actKey, String processInstanceId) {
		// String userId= actHiTaskinstMapper.selectActHiTaskinst(processInstanceId,
		// actKey);
		String user = "";
		List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery()
				.processInstanceId(processInstanceId).processDefinitionKey(actKey).taskDeleteReason("completed")
				.orderByHistoricTaskInstanceEndTime().desc().list();
		if (list.size() > 0) {
			if (net.medcrm.yjb.workflow.util.StringUtils.isNotNull(list.get(0).getAssignee()))
				user = list.get(0).getAssignee();
		} else {
			HistoricProcessInstance hpi = historyService.createHistoricProcessInstanceQuery()
					.processDefinitionKey(actKey).processInstanceId(processInstanceId).singleResult();
			if (net.medcrm.yjb.workflow.util.StringUtils.isNull(hpi))
				return null;
			user = hpi.getStartUserId();
			LoggerUtils.debug(this.getClass(), hpi.getStartUserId() + " --------------------");
		}

		return employeeServiceClient.getEmpInfo(user);
	}

	/**
	 * 根据key获得一个最新的流程定义
	 * 
	 * @param key
	 * @return
	 */
	protected ProcessDefinition getNewProcessDefinition(String key) {
		// 根据key查询已经激活的流程定义，并且按照版本进行降序。那么第一个就是将要得到的最新流程定义对象
		List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery()
				.processDefinitionKey(key).orderByProcessDefinitionVersion().desc().list();
		if (processDefinitionList.size() > 0) {
			return processDefinitionList.get(0);
		}
		return null;
	}

	protected ProcessDefinitionEntity getNewProcessDefinitionEntity(String processInstanceId) {
		// 获取流程发布Id信息
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		if (net.medcrm.yjb.workflow.util.StringUtils.isNull(processInstance))
			return null;
		String definitionId = processInstance.getProcessDefinitionId();
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
				.getDeployedProcessDefinition(definitionId);
		return processDefinitionEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getUserInfoList(List<String> alUsers) {
		if (net.medcrm.yjb.workflow.util.StringUtils.isNull(alUsers))
			return null;
		BaseResp<List<Map<String, Object>>> base = employeeServiceClient
				.getEmpInfoList(net.medcrm.yjb.workflow.util.StringUtils.listToString(alUsers, ','));
		return (List<Map<String, Object>>) base.getData();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getUserInfos(List<String> alGroups) {
		if (net.medcrm.yjb.workflow.util.StringUtils.isNull(alGroups))
			return null;
		BaseResp<List<Map<String, Object>>> base = employeeServiceClient
				.getEmpInfosList(net.medcrm.yjb.workflow.util.StringUtils.listToString(alGroups, ','));
		return (List<Map<String, Object>>) base.getData();
	}

	public InputStream queryProPlan(String processInstanceId) throws IOException {
		// 获取历史流程实例
		HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		// 获取流程图
		BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
		processEngineConfiguration = processEngine.getProcessEngineConfiguration();
		Context.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);

		ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
		ProcessDefinitionEntity definitionEntity = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(processInstance.getProcessDefinitionId());

		List<HistoricActivityInstance> highLightedActivitList = historyService.createHistoricActivityInstanceQuery()
				.processInstanceId(processInstanceId).list();
		// 高亮环节id集合
		List<String> highLightedActivitis = new ArrayList<String>();

		// 高亮线路id集合
		List<String> highLightedFlows = getHighLightedFlows(definitionEntity, highLightedActivitList);

		for (HistoricActivityInstance tempActivity : highLightedActivitList) {
			String activityId = tempActivity.getActivityId();
			highLightedActivitis.add(activityId);
		}

		// 中文显示的是口口口，设置字体就好了
		InputStream imageStream = diagramGenerator.generateDiagram(bpmnModel, "png", highLightedActivitis,
				highLightedFlows, "宋体", "微软雅黑", "黑体", null, 2.0d);

		// 单独返回流程图，不高亮显示
		// InputStream imageStream = diagramGenerator.generatePngDiagram(bpmnModel);
		// 输出资源内容到相应对象
		return imageStream;

	}

	/**
	 * 获取需要高亮的线
	 * 
	 * @param processDefinitionEntity
	 * @param historicActivityInstances
	 * @return
	 */
	private List<String> getHighLightedFlows(ProcessDefinitionEntity processDefinitionEntity,
			List<HistoricActivityInstance> historicActivityInstances) {

		List<String> highFlows = new ArrayList<String>();// 用以保存高亮的线flowId
		for (int i = 0; i < historicActivityInstances.size() - 1; i++) {// 对历史流程节点进行遍历
			ActivityImpl activityImpl = processDefinitionEntity
					.findActivity(historicActivityInstances.get(i).getActivityId());// 得到节点定义的详细信息
			List<ActivityImpl> sameStartTimeNodes = new ArrayList<ActivityImpl>();// 用以保存后需开始时间相同的节点
			ActivityImpl sameActivityImpl1 = processDefinitionEntity
					.findActivity(historicActivityInstances.get(i + 1).getActivityId());
			// 将后面第一个节点放在时间相同节点的集合里
			sameStartTimeNodes.add(sameActivityImpl1);
			for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
				HistoricActivityInstance activityImpl1 = historicActivityInstances.get(j);// 后续第一个节点
				HistoricActivityInstance activityImpl2 = historicActivityInstances.get(j + 1);// 后续第二个节点
				if (activityImpl1.getStartTime().equals(activityImpl2.getStartTime())) {
					// 如果第一个节点和第二个节点开始时间相同保存
					ActivityImpl sameActivityImpl2 = processDefinitionEntity
							.findActivity(activityImpl2.getActivityId());
					sameStartTimeNodes.add(sameActivityImpl2);
				} else {
					// 有不相同跳出循环
					break;
				}
			}
			List<PvmTransition> pvmTransitions = activityImpl.getOutgoingTransitions();// 取出节点的所有出去的线
			for (PvmTransition pvmTransition : pvmTransitions) {
				// 对所有的线进行遍历
				ActivityImpl pvmActivityImpl = (ActivityImpl) pvmTransition.getDestination();
				// 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
				if (sameStartTimeNodes.contains(pvmActivityImpl)) {
					highFlows.add(pvmTransition.getId());
				}
			}
		}
		return highFlows;
	}

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
		LoggerUtils.debug(this.getClass(), task);
		return task.getCandidateGroupIdExpressions();
	}

	/**
	 * 下个节点选人
	 * 
	 * @param taskId
	 * @return
	 */
	public List<Map<String, Object>> findNextUserList(String taskId) {
		List<Map<String, Object>> res = Lists.newArrayList();
		TaskDefinition taskDefinition = getNextTaskDefinition(taskId);
		if (net.medcrm.yjb.workflow.util.StringUtils.isNull(taskDefinition))
			return res;
		Set<Expression> setGroups = taskDefinition.getCandidateGroupIdExpressions();
		Set<Expression> setUsers = taskDefinition.getCandidateUserIdExpressions();
		Iterator<Expression> iterGroups = setGroups.iterator();
		Iterator<Expression> iterUsers = setUsers.iterator();
		ArrayList<String> alGroups = Lists.newArrayList();
		ArrayList<String> alUsers = Lists.newArrayList();
		while (iterGroups.hasNext()) {
			Expression expression = iterGroups.next();
			alGroups.add(expression.getExpressionText());
		}
		while (iterUsers.hasNext()) {
			Expression expression = iterUsers.next();
			alUsers.add(expression.getExpressionText());
		}
		LoggerUtils.debug(this.getClass(), alUsers + "-------------------------------用户信息");
		LoggerUtils.debug(this.getClass(), alGroups + "----------------------用户组的信息");

		List<Map<String, Object>> users = getUserInfos(alGroups);
		if (net.medcrm.yjb.workflow.util.StringUtils.isNotNull(users)) {
			res.addAll(users);
		}
		List<Map<String, Object>> groups = getUserInfoList(alUsers);
		if (net.medcrm.yjb.workflow.util.StringUtils.isNotNull(groups)) {
			res.addAll(groups);
		}
		return res;
	}

	/**
	 * 下个节点选人
	 * 
	 * @param taskId
	 * @return
	 */
	public List<Map<String, Object>> getNextUserList(String taskId) {
		List<Map<String, Object>> res = Lists.newArrayList();
		TaskDefinition taskDefinition = getNextTaskDefinition(taskId);
		if (net.medcrm.yjb.workflow.util.StringUtils.isNotNull(taskDefinition))
			return res;
		Set<Expression> setGroups = taskDefinition.getCandidateGroupIdExpressions();
		Set<Expression> setUsers = taskDefinition.getCandidateUserIdExpressions();
		Iterator<Expression> iterGroups = setGroups.iterator();
		Iterator<Expression> iterUsers = setUsers.iterator();
		ArrayList<String> alGroups = Lists.newArrayList();
		ArrayList<String> alUsers = Lists.newArrayList();
		while (iterGroups.hasNext()) {
			Expression expression = iterGroups.next();
			alGroups.add(expression.getExpressionText());
		}
		while (iterUsers.hasNext()) {
			Expression expression = iterUsers.next();
			alUsers.add(expression.getExpressionText());
		}
		LoggerUtils.debug(this.getClass(), alUsers + "-------------------------------用户信息");
		LoggerUtils.debug(this.getClass(), alGroups + "----------------------用户组的信息");

		List<Map<String, Object>> users = getUserInfos(alGroups);
		if (net.medcrm.yjb.workflow.util.StringUtils.isNotNull(users)) {
			res.addAll(users);
		}
		List<Map<String, Object>> groups = getUserInfoList(alUsers);
		if (net.medcrm.yjb.workflow.util.StringUtils.isNotNull(groups)) {
			res.addAll(groups);
		}
		return res;
	}
	
	private TaskDefinition getNextTaskDefinition(String taskId) {

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
		return task;
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
							LoggerUtils.debug(this.getClass(), "表达式" + s);
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

	protected String isExclusiveGateway(ActivityImpl activityImpl, String activityId) {
		PvmActivity ac = null;
		Object s = null;
		// 如果遍历节点为用户任务并且节点不是当前节点信息
		if ("userTask".equals(activityImpl.getProperty("type")) && !activityId.equals(activityImpl.getId())) {
			return null;
		} else {
			// 获取节点所有流向线路信息
			List<PvmTransition> outTransitions = activityImpl.getOutgoingTransitions();
			List<PvmTransition> outTransitionsTemp = null;
			for (PvmTransition tr : outTransitions) {
				ac = tr.getDestination(); // 获取线路的终点节点
				// 如果流向线路为排他网关
				if ("exclusiveGateway".equals(ac.getProperty("type"))) {
					outTransitionsTemp = ac.getOutgoingTransitions();
					for (PvmTransition tr1 : outTransitionsTemp) {
						s = tr1.getProperty("conditionText"); // 获取排他网关线路判断条件信息
						if(net.medcrm.yjb.workflow.util.StringUtils.isNotNull(s)) {
							 if(s.toString().indexOf("==")!=-1) {
								 
							 }
						}
					}
				}
			}
		}
		return null;
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
		if (net.medcrm.yjb.workflow.util.StringUtils.isNull(execution))
			return null;
		if (net.medcrm.yjb.workflow.util.StringUtils.isNull(runtimeService.getVariable(execution.getId(), gatewayId)))
			return null;
		return runtimeService.getVariable(execution.getId(), gatewayId).toString();
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
		ValueExpression e = factory.createValueExpression(context, el, boolean.class);
		try {
			return (Boolean) e.getValue(context);
		} catch (Exception ex) {
			ex.printStackTrace();
			return true;
		}
	}
	
	public Map<String,Object> getQueryUser(String handleType,String userId) {
		Map<String,Object> map=Maps.newHashMap();
		List<String> list=Lists.newArrayList();
		if(net.medcrm.yjb.workflow.util.StringUtils.isNull(handleType)) {
			list.add(userId);
			map.put("applyUser", null);
			map.put("handleUser", list);
		}
		if(StringUtils.equals(handleType, HandleType.MYAPPLY.getId())) {
			list.add(userId);
			map.put("applyUser", list);
			map.put("handleUser", null);
		}else if(StringUtils.equals(handleType, HandleType.MYDEPTAPPLY.getId())) {
			BaseResp<List<String>> base = employeeServiceClient.getEmployLeader(userId);
			map.put("applyUser", base.getData());
			map.put("handleUser", null);
		}else if(StringUtils.equals(handleType, HandleType.MYHANDLE.getId())) {
			list.add(userId);
			map.put("applyUser", null);
			map.put("handleUser", list);
		}else if(StringUtils.equals(handleType, HandleType.MYDEPTHANDLE.getId())) {
			map.put("applyUser", null);
			map.put("handleUser", employeeServiceClient.getDeptUser(userId));
		}else if(StringUtils.equals(handleType, HandleType.MYDEPTLEADERHANDLE.getId())) {
			BaseResp<List<String>> base = employeeServiceClient.getEmployLeader(userId);
			map.put("applyUser", null);
			map.put("handleUser", base.getData());
		}
		return map;
	}
	
	

}
