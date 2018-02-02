package net.medcrm.yjb.workflow.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.workflow.domain.Consultation;
import net.medcrm.yjb.workflow.domain.User;
import net.medcrm.yjb.workflow.service.IConsultationService;
import net.medcrm.yjb.workflow.util.Variable;

/**
 * 会诊
 * 
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("consultation")
public class ConsultationController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IConsultationService consultationService;

	@Resource(name = "identityService")
	private org.activiti.engine.IdentityService identityService;

	@Resource(name = "runtimeService")
	private RuntimeService runtimeService;

	@Resource(name = "historyService")
	private HistoryService historyService;

	@Resource(name = "taskService")
	private TaskService taskService;

	@Resource(name = "managementService")
	private ManagementService managementService;

	@Resource // (name="formService")
	private FormService formService;

	@Resource(name = "repositoryService")
	private RepositoryService repositoryService;

	@PostMapping("/list")
	public Object getList(@RequestParam(value = "rowSize", defaultValue = "1000", required = false) Integer rowSize,
			@RequestParam(value = "page", defaultValue = "1", required = false) Integer page) {
		List<Consultation> list = consultationService.findAllConsultation(page, rowSize);
		return new BaseResp<List<Consultation>>(list);
	}

	/**
	 * 新增申请信息流程开始
	 * 
	 * @param consultation
	 * @return
	 */
	@ApiOperation(value = "新增会诊申请信息流程开始", notes = "根据consultation对象创建会诊", httpMethod = "POST")
	@ApiImplicitParam(name = "consultation", value = "会诊详细实体consultation", required = true, dataType = "consultation")
	@PostMapping("/save")
	public Object getList(Consultation consultation) {
		Map<String, Object> variables = new HashMap<String, Object>();

		// 申请人
		String applyUserName = "";
		// consultation.setApplyUser(applyUser);
		consultationService.addConsultation(consultation);
		// 与业务绑定(将请假实例的id与流程实例绑定),通过请假单据的主键id号关联本流程
		String businessKey = consultation.getId().toString();

		// 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
		identityService.setAuthenticatedUserId(consultation.getApplyUserId());
		try {
			// 根据流程定义的key启动工作流
			ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("consultation", businessKey,
					variables);
			consultation.setProcessInstance(processInstance);
			consultation.setProcessInstanceId(processInstance.getId());
			System.out.println("流程已启动，流程ID：" + processInstance.getId());
		} catch (ActivitiException e) {
			if (e.getMessage().indexOf("no processes deployed with key") != -1) {
				logger.warn("没有部署流程!", e);
				return new BaseResp<>(ResultStatus.error_start_workflow);
			} else {
				logger.error("启动请假流程失败：", e);
				return new BaseResp<>(ResultStatus.FAIL);
			}
		} catch (Exception e) {
			logger.error("启动请假流程失败：", e);
			return new BaseResp<>(ResultStatus.FAIL);
		}
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	/**
	 * 根据用户Id查询待办任务列表
	 * 
	 * @param userid
	 * @return
	 */
	@ApiOperation(value = "查询当前用户待办任务列表", notes = "", httpMethod = "POST")
	@PostMapping(value = "/task/list")
	public Object findTask() {
		// 当前用户信息
		User user = new User();
		List<Consultation> tasklist = consultationService.findUserTask(String.valueOf(user.getUserId()), "leave");
		// 如果该用户没有任务，去查看该用户所担当的角色的任务
		if (tasklist.size() <= 0) {
			List<Group> datas = identityService.createGroupQuery().groupMember(String.valueOf(user.getUserId())).list();// 该用户所在的组
			// List<User> datas =
			// identityService.createUserQuery().MemberOfGroup(group.getId()).list();//该组下的用户
			tasklist = consultationService.findGroupTask(String.valueOf(user.getUserId()), datas, "leave");
		}
		return new BaseResp<List<Consultation>>(tasklist);
	}

	/**
	 * 2017-02-06新增 查询流程实例
	 * 
	 * @param processDefinitionKey
	 *            //流程定义key
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiOperation(value = "查询流程实例", notes = "", httpMethod = "GET")
	@GetMapping(value = "process/all/leave/list")
	public Object findAllProcessInstaces() {
		// 获取所有定义的流程
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
		return new BaseResp<List<ProcessDefinition>>(list);
	}

	/**
	 * 根据流程定义的key查询运行中的流程实例
	 * 
	 * @param processDefinitionKey
	 *            //流程定义key
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiOperation(value = "根据流程定义的key查询运行中的流程实例", notes = "根据流程定义的key查询", httpMethod = "GET")
	@ApiImplicitParam(name = "processDefinitionKey", value = "流程定义的key", required = true, dataType = "String")
	@RequestMapping(value = "/process/running/{processDefinitionKey}/list", method = { RequestMethod.GET })
	public Object findRunningProcessInstaces(@PathVariable("processDefinitionKey") String processDefinitionKey) {

		List<Consultation> runningProcessInstaces = consultationService
				.findRunningProcessInstaces(processDefinitionKey);

		return new BaseResp<List<Consultation>>(runningProcessInstaces);
	}

	/**
	 * 查询已结束的流程实例
	 * 
	 * @param processDefinitionKey
	 * @return
	 */
	@ApiOperation(value = "查询已结束的流程实例", notes = "根据流程定义的key查询", httpMethod = "GET")
	@ApiImplicitParam(name = "processDefinitionKey", value = "流程定义的key", required = true, dataType = "String")
	@RequestMapping(value = "/process/finished/{processDefinitionKey}/list", method = { RequestMethod.GET })
	public Object findFinishedProcessInstaces(@PathVariable("processDefinitionKey") String processDefinitionKey) {

		List<Consultation> finishedProcessInstaces = consultationService
				.findFinishedProcessInstaces(processDefinitionKey);
		return new BaseResp<List<Consultation>>(finishedProcessInstaces);
	}

	/**
	 * 根据任务Id签收任务
	 * 
	 * @param userid
	 * @return
	 */
	@ApiOperation(value = "根据任务Id签收任务", notes = "根据任务Id查找", httpMethod = "GET")
	@ApiImplicitParam(name = "taskId", value = "任务Id", required = true, dataType = "String")
	@GetMapping(value = "/task/{taskId}/claim")
	public Object claimTask(@PathVariable("taskId") String taskId, HttpSession session) {
		User user = (User) session.getAttribute("loginuser");
		taskService.claim(taskId, String.valueOf(user.getUserId()));// 签收
		return new BaseResp<Consultation>(ResultStatus.SUCCESS);// 跳转到待办任务列表
	}

	/**
	 * 根据任务Id完成任务
	 * 驳回
	 * @param userid
	 * @return
	 */
	@ApiOperation(value = "完成任务", notes = "根据任务Id查找", httpMethod = "GET")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "taskId", value = "任务Id", required = true, dataType = "String"),
        @ApiImplicitParam(name = "variable", value = "自定义类", required = true, dataType = "Variable")
	})
	@RequestMapping(value = "/task/{taskId}/complete", method = { RequestMethod.GET, RequestMethod.POST })
	public Object completeTask(@PathVariable("taskId") String taskId, Variable variable) {
		try {
			// Variable自定义存储数据的bean
			Map<String, Object> variables = variable.getVariableMap();
			taskService.complete(taskId, variables);
			return new BaseResp<String>(ResultStatus.SUCCESS);
		} catch (Exception e) {
		}
		return new BaseResp<String>(ResultStatus.FAIL);// 返回办理信息到viewform
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "得到会诊详细信息", notes = "根据会诊id查找", httpMethod = "GET")
	@ApiImplicitParam(name = "id", value = "会诊id", required = true, dataType = "String")
	@RequestMapping(value = "/detail/{id}/consultation", method = { RequestMethod.GET })
	public Object getLeaveById(@PathVariable("id") String id) {
		Consultation consultation = consultationService.findById(id);
		return new BaseResp<Consultation>(consultation);
	}

	/**
	 * 根据会诊id和任务id获取实体
	 * 
	 * @param id
	 * @param taskId
	 * @return
	 */
	@ApiOperation(value = "办理任务", notes = "根据会诊id和任务id获取实体", httpMethod = "GET")
	@ApiImplicitParam(name = "taskId", value = "会诊id 任务id", required = true, dataType = "String")
	@RequestMapping(value = "/detail/consultation/{taskId}", method = { RequestMethod.GET })
	public Object getLeaveWithVars(@PathVariable("taskId") String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();// 获取任务
		ExecutionEntity executionEntity = (ExecutionEntity) runtimeService.createExecutionQuery()
				.executionId(task.getExecutionId()).processInstanceId(task.getProcessInstanceId()).singleResult();
		/*
		 * ExecutionEntity实现了接口ActivityExecution，ActivityExecution是流程运行管理接口。
		 * ExecutionEntity提供的功能如下：
		 * 启动、结束、销毁流程。对流程元素ActivityImpl的管理（添加删除修改父节点、实例ID、任务等）。
		 * ExecutionEntity里几个重要的方法：initialize()里面初始化task、job、variable、event。
		 * start()是流程启动方法 performOperation()是流程执行方法，流程的推动都调用performOperation()。
		 */
		// 获取当前正在执行的节点
		String activityId = executionEntity.getActivityId();
		String processInstanceId = task.getProcessInstanceId();
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		String businessKey = processInstance.getBusinessKey();
		Consultation consultation = consultationService.findById(businessKey);
		Map<String, Object> variables = taskService.getVariables(taskId);
		consultation.setVariables(variables);
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("taskId", taskId);
		map.put("consultation", consultation);
		map.put("activityId", activityId);
		return new BaseResp<Map<String, Object>>(map);
	}

	/* 2017-01-22增加在springmvc中如果表单属性的类型是日期型时，从页面绑定字符串数据会出错 */
	// SimpleDateFormat日期格式与页面日期格式要一致！ 对应的controller中增加属性编辑器
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
