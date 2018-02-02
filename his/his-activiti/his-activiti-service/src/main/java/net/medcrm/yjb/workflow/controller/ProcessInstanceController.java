package net.medcrm.yjb.workflow.controller;

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
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.his.mybatis.dynamicDataSource.page.PageInfo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.log.LoggerUtils;
import net.medcrm.yjb.workflow.cmd.JumpActivityCmd;
import net.medcrm.yjb.workflow.domain.HflowCustomRealTemplate;
import net.medcrm.yjb.workflow.domain.HflowDraftBox;
import net.medcrm.yjb.workflow.domain.HflowSignature;
import net.medcrm.yjb.workflow.dto.FlowDeployDto;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.service.HflowCustomRealTemplateService;
import net.medcrm.yjb.workflow.service.IActReProcdefService;
import net.medcrm.yjb.workflow.service.IHflowCommService;
import net.medcrm.yjb.workflow.service.IHflowDraftBoxService;
import net.medcrm.yjb.workflow.service.IHflowHandleService;
import net.medcrm.yjb.workflow.service.IHflowProcdefService;
import net.medcrm.yjb.workflow.service.IHflowSignatureService;
import net.medcrm.yjb.workflow.util.ProcdefType;
import net.medcrm.yjb.workflow.util.StringUtils;
import net.medcrm.yjb.workflow.vo.FinishedFlowVO;
import net.medcrm.yjb.workflow.vo.HandleInfoVO;
import net.medcrm.yjb.workflow.vo.MonitorVO;
import net.medcrm.yjb.workflow.vo.QuereyParameterVO;
import net.medcrm.yjb.workflow.vo.TaskCompleteVO;

/**
 * 流程运行实例
 * 
 * @author hybin
 *
 */

@RestController
@RequestMapping(value = "/workflow/processinstance")
public class ProcessInstanceController {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	protected TaskService taskService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private ManagementService managementService;

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	@Autowired
	private IHflowProcdefService procdefService;

	@Autowired
	private IActReProcdefService actReProcdefService;

	@Autowired
	private IHflowCommService flowCommService;

	@Autowired
	private IHflowHandleService flowHandleService;

	@Autowired
	private HflowCustomRealTemplateService customRealTemplateService;

	@Autowired
	private IHflowDraftBoxService flowDraftBoxService;

	@Autowired
	private IHflowSignatureService flowSignatureService;

	@ApiOperation(value = "我的消息--返回我的待办总条数", notes = "我的待办总条数", httpMethod = "GET")
	@GetMapping(value = "/msg/getRunningCount")
	public Object getRunningCount() {

		// 当前用户信息
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();

		TaskQuery taskQuery = taskService.createTaskQuery().orderByTaskId().desc().active();
		List<Task> list = taskQuery.taskCandidateOrAssigned(user.getId()).active().orderByTaskId().desc().list();
		return new BaseResp<>(list.size());
	}

	@ApiOperation(value = "回退上一个步审批操作", notes = "回退上一个步审批操作", httpMethod = "GET")
	@ApiImplicitParam(name = "taskId", value = "taskId流程ID", required = true, dataType = "String")
	@GetMapping(value = "jump/taskRollback")
	public Object taskRollback(@PathVariable("taskId") String taskId) {

		// 根据要跳转的任务ID获取其任务
		HistoricTaskInstance hisTask = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
		// 进而获取流程实例
		ProcessInstance instance = runtimeService.createProcessInstanceQuery()
				.processInstanceId(hisTask.getProcessInstanceId()).singleResult();
		// 取得流程定义
		ProcessDefinitionEntity definition = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(hisTask.getProcessDefinitionId());
		// 获取历史任务的Activity
		ActivityImpl hisActivity = definition.findActivity(hisTask.getTaskDefinitionKey());
		// 所有节点
		List<ActivityImpl> activitiList = definition.getActivities();
		for (ActivityImpl activityImpl : activitiList) {
			System.out.println(activityImpl.getId());
		}
		// 实现跳转
		managementService.executeCommand(new JumpActivityCmd(instance.getId(), hisActivity.getId()));
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	@ApiOperation(value = "跳到指定审批环节", notes = "跳到指定审批环节", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "taskId", value = "taskId流程ID", required = false, dataType = "String"),
			@ApiImplicitParam(name = "activityId", value = "activityId节点ID", required = false, dataType = "String") })
	@PostMapping(value = "jump")
	public Object jump(@RequestParam("taskId") String taskId, @RequestParam("activityId") String activityId) {

		// 根据要跳转的任务ID获取其任务
		HistoricTaskInstance hisTask = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
		// 进而获取流程实例
		ProcessInstance instance = runtimeService.createProcessInstanceQuery()
				.processInstanceId(hisTask.getProcessInstanceId()).singleResult();
		Command<Object> cmd = new JumpActivityCmd(instance.getId(), activityId);
		managementService.executeCommand(cmd);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	/**
	 * 已结束的流程实例
	 *
	 * @param model
	 * @return
	 */
	@ApiOperation(value = "分页查询已结束的流程实例", notes = "根据每页数pageSize,当前页码pageNum查询已结束的流程实例", httpMethod = "POST")
	@ApiImplicitParam(name = "quereyPara", value = "查询参数类", required = false, dataType = "QuereyParameterVO")
	@PostMapping(value = "/finishedList")
	public Object finished(@RequestBody QuereyParameterVO quereyPara) {
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		String applyUser = "";
		if (StringUtils.isNotNull(quereyPara.getQueryValue())) {
			String userid = employeeServiceClient.getEmpId(quereyPara.getQueryValue());
			if (StringUtils.isNotNull(userid))
				applyUser = userid;
		}
		Map<String, Object> queryUser = flowCommService.getQueryUser(quereyPara.getHandleType(), user.getId());
		PageInfo<FinishedFlowVO> pageInfo = actReProcdefService.finished(applyUser, queryUser, quereyPara);
		return new BaseResp<>(pageInfo);
	}

	/**
	 * 已结束的流程实例
	 *
	 * @param model
	 * @return
	 */
	@ApiOperation(value = "分页查询经手的流程实例", notes = "根据每页数pageSize,当前页码pageNum查询经手的流程实例", httpMethod = "POST")
	@ApiImplicitParam(name = "quereyPara", value = "查询参数类", required = false, dataType = "QuereyParameterVO")
	@PostMapping(value = "/getHandleRuningList")
	public Object getHandleRuningList(@RequestBody QuereyParameterVO quereyPara) {
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		String applyUser = null;
		if (StringUtils.isNotNull(quereyPara.getQueryValue())) {
			String userid = employeeServiceClient.getEmpId(quereyPara.getQueryValue());
			if (StringUtils.isNotNull(userid))
				applyUser = userid;
		}
		Map<String, Object> queryUser = flowCommService.getQueryUser(quereyPara.getHandleType(), user.getId());
		PageInfo<HandleInfoVO> pageInfo = actReProcdefService.findRunningFlows(applyUser, queryUser, quereyPara);
		return new BaseResp<>(pageInfo);
	}

	@ApiOperation(value = "查询待办列表", notes = "根据每页数pageSize,当前页码pageNum查询待办列表", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "每页数pageSize", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageNum", value = "当前页码pageNum", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "modelId", value = "modelId模块ID", required = false, dataType = "String"),
			@ApiImplicitParam(name = "queryValue", value = "申请人、标题、办理要求", required = false, dataType = "String"),
			@ApiImplicitParam(name = "handleType", value = "办理类别", required = false, dataType = "String"),
			@ApiImplicitParam(name = "startDate", value = "查询开始日期", required = false, dataType = "String"),
			@ApiImplicitParam(name = "endDate", value = "查询结束始日期", required = false, dataType = "String") })
	@PostMapping("/flow/getHandleList")
	public Object getHandleHFlow(
			@RequestParam(value = "pageSize", defaultValue = "1000", required = false) Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
			@RequestParam(value = "modelId", required = false) String modelId,
			@RequestParam(value = "queryValue", required = false) String queryValue,
			@RequestParam(value = "handleType", required = false) String handleType,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate) {
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		String applyUser = null;
		if (StringUtils.isNotNull(queryValue)) {
			String userid = employeeServiceClient.getEmpId(queryValue);
			if (StringUtils.isNotNull(userid))
				applyUser = userid;
		}
		PageInfo<HandleInfoVO> pageInfo = actReProcdefService.getHandleHFlow(applyUser, startDate, endDate, queryValue,
				modelId, user.getId(), pageNum, pageSize);

		return new BaseResp<>(pageInfo);

	}

	@ApiOperation(value = "用户发起流程列表", notes = "用户发起流程列表", httpMethod = "POST")
	@ApiImplicitParam(name = "modelId", value = "modelId模块ID", required = false, dataType = "String")
	@PostMapping("/deployFlowList")
	public Object getDeployFlow(String modelId) {
		List<FlowDeployDto> dto = procdefService.findAllDeploy(ProcdefType.PRCDE.getIndex(), modelId);
		return new BaseResp<List<FlowDeployDto>>(dto);
	}

	@ApiOperation(value = "查询流程中所有的审批节点", notes = "审批节点", httpMethod = "GET")
	@ApiImplicitParam(name = "processDefinitionId", value = "流程实例ID", required = true, dataType = "String")
	@GetMapping("/elements/getUserTask")
	public Object getUserTask(String processDefinitionId) {
		List<Map<String, Object>> list = new ArrayList<>();
		BpmnModel model = repositoryService.getBpmnModel(processDefinitionId);
		if (model != null) {
			Collection<FlowElement> flowElements = model.getMainProcess().getFlowElements();
			for (FlowElement e : flowElements) {
				if (e.getClass().toString().endsWith("StartEvent")) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", e.getId());
					map.put("name", e.getName());
					HflowCustomRealTemplate listCT = customRealTemplateService.selectByFlowIdAndNodeId(processDefinitionId,e.getId());
					if (StringUtils.isNotNull(listCT)) {
						listCT.setTpl("");
						// table.setVersion(tpl.getVersion());
						map.put("table", listCT);
					} else {
						map.put("table", "");
					}
					list.add(map);
				} else if (e.getClass().toString().endsWith("UserTask")) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", e.getId());
					map.put("name", e.getName());
					HflowCustomRealTemplate listCT = customRealTemplateService.selectByFlowIdAndNodeId(processDefinitionId,e.getId());
					if (StringUtils.isNotNull(listCT)) {
						// table.setVersion(tpl.getVersion());
						listCT.setTpl("");
						map.put("table", listCT);
					} else {
						map.put("table", "");
					}
					list.add(map);
				} else if (e.getClass().toString().endsWith("EndEvent")) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", e.getId());
					map.put("name", e.getName());
					HflowCustomRealTemplate listCT = customRealTemplateService.selectByFlowIdAndNodeId(processDefinitionId,e.getId());
					if (StringUtils.isNotNull(listCT)) {
						// table.setVersion(tpl.getVersion());
						listCT.setTpl("");
						map.put("table", listCT);
					} else {
						map.put("table", "");
					}
					list.add(map);
				}
			}
			return new BaseResp<>(list);
		}
		return new BaseResp<>(ResultStatus.FAIL);
	}

	@ApiOperation(value = "查询用户经办列表", notes = "根据每页数pageSize,当前页码pageNum查询经办列表", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "每页数pageSize", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageNum", value = "当前页码pageNum", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "modelId", value = "modelId模块ID", required = false, dataType = "String") })
	@PostMapping("/flow/getHistoryList")
	public Object getHistoryFlow(
			@RequestParam(value = "pageSize", defaultValue = "1000", required = false) Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
			@RequestParam(value = "modelId", required = false) String modelId) {
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		PageInfo<HandleInfoVO> pageInfo = actReProcdefService.getHistoryFlow(modelId, user.getId(), pageNum, pageSize);
		return new BaseResp<>(pageInfo);
	}

	@ApiOperation(value = "流程监控", notes = "根据每页数pageSize,当前页码pageNum流程监控列表", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "每页数pageSize", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageNum", value = "当前页码pageNum", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "modelId", value = "modelId模块ID", required = false, dataType = "String"),
			@ApiImplicitParam(name = "queryValue", value = "查询", required = false, dataType = "String")})
	@PostMapping("/flow/getFlowMonitor")
	public Object findFlowMonitor(
			@RequestParam(value = "pageSize", defaultValue = "1000", required = false) Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
			@RequestParam(value = "modelId", required = false) String modelId,
			@RequestParam(value = "queryValue", required = false) String queryValue) {
		String applyUser = "";
		if (StringUtils.isNotNull(queryValue)) {
			String userid = employeeServiceClient.getEmpId(queryValue);
			if (StringUtils.isNull(userid))
				applyUser = userid;
		}
		PageInfo<MonitorVO> pageInfo = actReProcdefService.findFlowMonitor(applyUser, queryValue, modelId, pageNum,
				pageSize);
		LoggerUtils.debug(this.getClass(), "pageInfo.getTotal------------- " + pageInfo.toString());
		return new BaseResp<>(pageInfo);
	}

	/**
	 * 签收任务、办理,提交task的并保存form
	 */
	@ApiOperation(value = "流程办理", notes = "签收任务、办理,提交task的并保存form", httpMethod = "POST")
	@ApiImplicitParam(name = "vompleteVO", value = "formData表单数据、opinio审批意见", required = false, dataType = "TaskCompleteVO")
	@PostMapping(value = "task/complete")
	public Object completeTaske(@RequestBody TaskCompleteVO vompleteVO) {
		if (StringUtils.isNull(vompleteVO)) {
			return new BaseResp<>(-1, "参数有误", null);
		}
		if (StringUtils.isNull(vompleteVO.getTaskId())) {
			return new BaseResp<>(-1, "参数有误", null);
		}
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();

		// Map<String, Object> formProperties = JSON.parseObject(variables);
		Map<String, Object> formProperties = vompleteVO.getVariables();
		LoggerUtils.debug(this.getClass(), "start form parameters: {}" + formProperties);

		flowHandleService.updateClaim(vompleteVO.getTaskId(), vompleteVO.getNextHandleUser(), vompleteVO.getOpinion(),
				formProperties, user);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	/**
	 * 显示上一步人员
	 * 
	 * @param oaType
	 *            流程Key
	 * @param oaActivityId
	 *            当前节点ID consultation:1:10
	 * @param oaElString
	 *            当前节点流向下一个节点的字符串表达式
	 * @return
	 */
	@ApiOperation(value = "流程审批--显示上一步人员", notes = "显示上一步人员", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "processDefinitionKey", value = "流程key", required = true, dataType = "String"),
			@ApiImplicitParam(name = "processInstanceId", value = "流程实例ID", required = true, dataType = "String") })
	@PostMapping(value = "/getShowBackUser")
	public Object showBackUser(String processDefinitionKey, String processInstanceId) {
		if (StringUtils.isNull(processInstanceId)) {
			return new BaseResp<>(ResultStatus.FAIL);
		}
		return new BaseResp<>(flowCommService.getBackUser(processDefinitionKey, processInstanceId));
	}

	/**
	 * 获取下一步处理人员列表
	 * 
	 * @param oaType
	 *            流程Key
	 * @param oaActivityId
	 *            当前节点ID
	 * @param oaElString
	 *            当前节点流向下一个节点的字符串表达式
	 * @return
	 */
	@ApiOperation(value = "流程审批--获取下一步处理人员列表", notes = "显示下一步人员", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "processInstanceId", value = "流程实例ID", required = true, dataType = "String"),
			@ApiImplicitParam(name = "activityId", value = "流程节点ID", required = true, dataType = "String"),
			@ApiImplicitParam(name = "elString", value = "流程网关判断表达式", required = true, dataType = "String") })
	@PostMapping(value = "/getNextUserList")
	public Object getNextUserList(String processInstanceId, String activityId, String elString) {
		if (StringUtils.isNull(activityId)) {
			return new BaseResp<>(-1, "参数有误", null);
		}
		TaskDefinition taskDefinition = flowCommService.getNextTaskDefinition2(processInstanceId, activityId, elString,
				true);
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
		// Map<String, Object> map = Maps.newHashMap();
		// map.put("users", alUsers);
		// map.put("groups", alGroups);\
		List<Map<String, Object>> res = Lists.newArrayList();
		List<Map<String, Object>> users = flowCommService.getUserInfos(alGroups);
		if (StringUtils.isNotNull(users)) {
			res.addAll(users);
		}
		List<Map<String, Object>> groups = flowCommService.getUserInfoList(alUsers);
		if (StringUtils.isNotNull(groups)) {
			res.addAll(groups);
		}
		return new BaseResp<>(res);
	}

	/**
	 * 获取下一步处理人员列表
	 * 
	 * @param oaType
	 *            流程Key
	 * @param oaActivityId
	 *            当前节点ID
	 * @param oaElString
	 *            当前节点流向下一个节点的字符串表达式
	 * @return
	 */
	@ApiOperation(value = "流程审批--获取下一步处理人员列表", notes = "显示下一步人员", httpMethod = "GET")
	@ApiImplicitParam(name = "taskId", value = "流程运行任务ID", required = true, dataType = "String")
	@GetMapping(value = "/findNextUserList")
	public Object findNextUserList(String taskId) {
		if (StringUtils.isNull(taskId)) {
			return new BaseResp<>(-1, "参数有误", null);
		}
		return new BaseResp<>(flowCommService.findNextUserList(taskId));
	}

	@ApiOperation(value = "流程草稿箱列表", notes = "流程草稿箱列表", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "每页数pageSize", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageNum", value = "当前页码pageNum", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "queryValue", value = "查询字段", required = false, dataType = "String") })
	@PostMapping("/getDraftBoxList")
	public Object getDraftBoxList(
			@RequestParam(value = "pageSize", defaultValue = "1000", required = false) Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
			@RequestParam(value = "queryValue", required = false) String queryValue) {
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();

		List<HflowDraftBox> list = flowDraftBoxService.findAll(user.getId(), queryValue, pageNum, pageSize);
		PageInfo<HflowDraftBox> pageInfo = new PageInfo<HflowDraftBox>(list);
		return new BaseResp<>(pageInfo);
	}

	@ApiOperation(value = "流程审批--查询流程处理情况", notes = "查询流程处理情况", httpMethod = "GET")
	@ApiImplicitParam(name = "taskId", value = "流程运行id", required = true, dataType = "String")
	@GetMapping(value = "/getHflowSignature")
	public Object getHflowSignature(String taskId) {
		List<HflowSignature> list = flowSignatureService.findListInfo(taskId);
		return new BaseResp<>(list);
	}

}
