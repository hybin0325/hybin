package net.medcrm.yjb.workflow.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.form.StartFormDataImpl;
import org.activiti.engine.impl.form.TaskFormDataImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.mybatis.dynamicDataSource.page.PageInfo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.log.LoggerUtils;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.util.PageUtil;
import net.medcrm.yjb.workflow.util.UserUtil;

/**
 * 动态表单Controller 了解不同表单请访问
 *
 * @author hybin
 */
@RestController
@RequestMapping(value = "/form/dynamic")
public class DynamicFormController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private FormService formService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	/**
	 * 动态form流程列表
	 *
	 * @param model
	 * @return
	 */
	@GetMapping(value = { "process-list" })
	public Object processDefinitionList(Model model,
			@RequestParam(value = "processType", required = false) String processType,
			@RequestParam(value = "pageSize", defaultValue = "1000", required = false) Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum) {
		PageInfo<ProcessDefinition> page = new PageInfo<ProcessDefinition>();
		int[] pageParams = PageUtil.init(page, pageNum, pageSize);
		if (!StringUtils.equals(processType, "all")) {
			/*
			 * 只读取动态表单的流程
			 */
			ProcessDefinitionQuery query1 = repositoryService.createProcessDefinitionQuery()
					.processDefinitionKey("leave-dynamic-from").active().orderByDeploymentId().desc();
			List<ProcessDefinition> list = query1.listPage(pageParams[0], pageParams[1]);

			ProcessDefinitionQuery query2 = repositoryService.createProcessDefinitionQuery()
					.processDefinitionKey("dispatch").active().orderByDeploymentId().desc();
			List<ProcessDefinition> dispatchList = query2.listPage(pageParams[0], pageParams[1]);

			ProcessDefinitionQuery query3 = repositoryService.createProcessDefinitionQuery()
					.processDefinitionKey("leave-jpa").active().orderByDeploymentId().desc();
			List<ProcessDefinition> list3 = query3.listPage(pageParams[0], pageParams[1]);

			list.addAll(list3);
			list.addAll(dispatchList);

			page.setList(list);
			page.setTotal(query1.count() + query2.count());
		} else {
			// 读取所有流程
			ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery().active()
					.orderByDeploymentId().desc();
			List<ProcessDefinition> list = query.list();
			page.setList(list);
			page.setTotal(query.count());
			System.out.println(list.size());
			return new BaseResp<List<ProcessDefinition>>(list);
		}

		return null;
	}

	/**
	 * 初始化启动流程，读取启动流程的表单字段来渲染start form
	 */
	@ApiOperation(value = "动态表单--初始化启动流程，读取启动流程的表单字段来渲染start form", notes = "启动流程的表单字段{processDefinitionId}实例ID", httpMethod = "GET")
	@GetMapping(value = "get-form/start/{processDefinitionId}")
	@SuppressWarnings("unchecked")
	public Object findStartForm(@PathVariable("processDefinitionId") String processDefinitionId) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		StartFormDataImpl startFormData = (StartFormDataImpl) formService.getStartFormData(processDefinitionId);
		startFormData.setProcessDefinition(null);

		// 读取enum类型数据，用于下拉框
		List<FormProperty> formProperties = startFormData.getFormProperties();
		for (FormProperty formProperty : formProperties) {
			Map<String, String> values = (Map<String, String>) formProperty.getType().getInformation("values");
			if (values != null) {
				for (Entry<String, String> enumEntry : values.entrySet()) {
					LoggerUtils.debug(this.getClass(), "enum, key: {}, value: {}", enumEntry.getKey(),
							enumEntry.getValue());
				}
				result.put("enum_" + formProperty.getId(), values);
			}
		}
		result.put("form", startFormData);
		return new BaseResp<>(result);
	}
	/**
	 * 读取Task的表单
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get-form/task/{taskId}")
	@ResponseBody
	public Map<String, Object> findTaskForm(@PathVariable("taskId") String taskId) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		TaskFormDataImpl taskFormData = (TaskFormDataImpl) formService.getTaskFormData(taskId);

		// 设置task为null，否则输出json的时候会报错
		taskFormData.setTask(null);

		result.put("taskFormData", taskFormData);
		/*
		 * 读取enum类型数据，用于下拉框
		 */
		List<FormProperty> formProperties = taskFormData.getFormProperties();
		for (FormProperty formProperty : formProperties) {
			Map<String, String> values = (Map<String, String>) formProperty.getType().getInformation("values");
			if (values != null) {
				for (Entry<String, String> enumEntry : values.entrySet()) {
					logger.debug("enum, key: {}, value: {}", enumEntry.getKey(), enumEntry.getValue());
				}
				result.put(formProperty.getId(), values);
			}
		}

		return result;
	}

	/**
	 * 办理任务，提交task的并保存form
	 */
	@RequestMapping(value = "task/complete/{taskId}")
	public String completeTask(@PathVariable("taskId") String taskId,
			@RequestParam(value = "processType", required = false) String processType,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		Map<String, String> formProperties = new HashMap<String, String>();

		// 从request中读取参数然后转换
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<Entry<String, String[]>> entrySet = parameterMap.entrySet();
		for (Entry<String, String[]> entry : entrySet) {
			String key = entry.getKey();

			// fp_的意思是form paremeter
			if (StringUtils.defaultString(key).startsWith("fp_")) {
				formProperties.put(key.split("_")[1], entry.getValue()[0]);
			}
		}

		logger.debug("start form parameters: {}", formProperties);

		User user = UserUtil.getUserFromSession(request.getSession());

		// 用户未登录不能操作，实际应用使用权限框架实现，例如Spring Security、Shiro等
		if (user == null || StringUtils.isBlank(user.getId())) {
			return "redirect:/login?timeout=true";
		}
		try {
			identityService.setAuthenticatedUserId(user.getId());
			formService.submitTaskFormData(taskId, formProperties);
		} finally {
			identityService.setAuthenticatedUserId(null);
		}

		redirectAttributes.addFlashAttribute("message", "任务完成：taskId=" + taskId);
		return "redirect:/form/dynamic/task/list?processType=" + processType;
	}

	/**
	 * 提交启动流程
	 */
	@ApiOperation(value = "动态表单--提交表单、启动流程", notes = "提交表单、启动流程{processDefinitionId}实例ID", httpMethod = "POST")
	@PostMapping(value = "/start-process/{processDefinitionId}")
	public Object submitStartFormAndStartProcessInstance(
			@PathVariable("processDefinitionId") String processDefinitionId,
			HttpServletRequest request) {
		Map<String, String> formProperties = new HashMap<String, String>();

		// 从request中读取参数然后转换
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<Entry<String, String[]>> entrySet = parameterMap.entrySet();
		for (Entry<String, String[]> entry : entrySet) {
			String key = entry.getKey();
			// fp_的意思是form paremeter
			if (StringUtils.defaultString(key).startsWith("fp_")) {
				formProperties.put(key.split("_")[1], entry.getValue()[0]);
			}
		}

		LoggerUtils.debug(this.getClass(),"start form parameters: {}"+ formProperties);
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		
		if (user == null || StringUtils.isBlank(user.getId())) {
			return new BaseResp<>(-1,"用户没登陆",null);
		}
		ProcessInstance processInstance = null;
		try {
			identityService.setAuthenticatedUserId(user.getId());
			processInstance = formService.submitStartFormData(processDefinitionId, formProperties);
			logger.debug("start a processinstance: {}", processInstance);
		} finally {
			identityService.setAuthenticatedUserId(null);
		}
		return new BaseResp<>(processInstance.getId());
	}

	/**
	 * task列表
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "task/list")
	public ModelAndView taskList(@RequestParam(value = "processType", required = false) String processType,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/form/dynamic/dynamic-form-task-list");
		User user = UserUtil.getUserFromSession(request.getSession());

		List<Task> tasks = new ArrayList<Task>();

		if (!StringUtils.equals(processType, "all")) {
			/**
			 * 这里为了演示区分开自定义表单的请假流程，值读取leave-dynamic-from 在FormKeyController中有使用native方式查询的例子
			 */

			List<Task> dynamicFormTasks = taskService.createTaskQuery().processDefinitionKey("leave-dynamic-from")
					.taskCandidateOrAssigned(user.getId()).active().orderByTaskId().desc().list();

			List<Task> dispatchTasks = taskService.createTaskQuery().processDefinitionKey("dispatch")
					.taskCandidateOrAssigned(user.getId()).active().orderByTaskId().desc().list();

			List<Task> leaveJpaTasks = taskService.createTaskQuery().processDefinitionKey("leave-jpa")
					.taskCandidateOrAssigned(user.getId()).active().orderByTaskId().desc().list();

			tasks.addAll(dynamicFormTasks);
			tasks.addAll(dispatchTasks);
			tasks.addAll(leaveJpaTasks);
		} else {
			tasks = taskService.createTaskQuery().taskCandidateOrAssigned(user.getId()).active().orderByTaskId().desc()
					.list();
		}

		mav.addObject("tasks", tasks);
		return mav;
	}

	/**
	 * 签收任务
	 */
	@RequestMapping(value = "task/claim/{id}")
	public String claim(@PathVariable("id") String taskId, HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		String userId = UserUtil.getUserFromSession(session).getId();
		taskService.claim(taskId, userId);
		redirectAttributes.addFlashAttribute("message", "任务已签收");
		return "redirect:/form/dynamic/task/list?processType="
				+ StringUtils.defaultString(request.getParameter("processType"));
	}

	/**
	 * 运行中的流程实例
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "process-instance/running/list")
	public ModelAndView running(Model model, @RequestParam(value = "processType", required = false) String processType,
			@RequestParam(value = "pageSize", defaultValue = "1000", required = false) Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum) {
		ModelAndView mav = new ModelAndView("/form/running-list", Collections.singletonMap("processType", processType));
		PageInfo<ProcessInstance> page = new PageInfo<ProcessInstance>();
		int[] pageParams = PageUtil.init(page, pageNum, pageSize);

		if (!StringUtils.equals(processType, "all")) {
			ProcessInstanceQuery leaveDynamicQuery = runtimeService.createProcessInstanceQuery()
					.processDefinitionKey("leave-dynamic-from").orderByProcessInstanceId().desc().active();
			List<ProcessInstance> list = leaveDynamicQuery.listPage(pageParams[0], pageParams[1]);

			ProcessInstanceQuery dispatchQuery = runtimeService.createProcessInstanceQuery()
					.processDefinitionKey("dispatch").active().orderByProcessInstanceId().desc();
			List<ProcessInstance> list2 = dispatchQuery.listPage(pageParams[0], pageParams[1]);
			list.addAll(list2);

			ProcessInstanceQuery leaveJpaQuery = runtimeService.createProcessInstanceQuery()
					.processDefinitionKey("leave-jpa").active().orderByProcessInstanceId().desc();
			List<ProcessInstance> list3 = leaveJpaQuery.listPage(pageParams[0], pageParams[1]);
			list.addAll(list3);

			page.setList(list);
			page.setTotal(leaveDynamicQuery.count() + dispatchQuery.count());
		} else {
			ProcessInstanceQuery dynamicQuery = runtimeService.createProcessInstanceQuery().orderByProcessInstanceId()
					.desc().active();
			List<ProcessInstance> list = dynamicQuery.listPage(pageParams[0], pageParams[1]);
			page.setList(list);
			page.setTotal(dynamicQuery.count());
		}
		mav.addObject("page", page);
		return mav;
	}

	/**
	 * 已结束的流程实例
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "process-instance/finished/list")
	public Object finished(Model model, @RequestParam(value = "processType", required = false) String processType,
			@RequestParam(value = "pageSize", defaultValue = "1000", required = false) Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum) {
		PageInfo<HistoricProcessInstance> page = new PageInfo<HistoricProcessInstance>();
		int[] pageParams = PageUtil.init(page, pageNum, pageSize);

		if (!StringUtils.equals(processType, "all")) {
			HistoricProcessInstanceQuery leaveDynamicQuery = historyService.createHistoricProcessInstanceQuery()
					.processDefinitionKey("leave-dynamic-from").finished().orderByProcessInstanceEndTime().desc();
			List<HistoricProcessInstance> list = leaveDynamicQuery.listPage(pageParams[0], pageParams[1]);

			HistoricProcessInstanceQuery dispatchQuery = historyService.createHistoricProcessInstanceQuery()
					.processDefinitionKey("dispatch").finished().orderByProcessInstanceEndTime().desc();
			List<HistoricProcessInstance> list2 = dispatchQuery.listPage(pageParams[0], pageParams[1]);

			HistoricProcessInstanceQuery leaveJpaQuery = historyService.createHistoricProcessInstanceQuery()
					.processDefinitionKey("leave-jpa").finished().orderByProcessInstanceEndTime().desc();
			List<HistoricProcessInstance> list3 = leaveJpaQuery.listPage(pageParams[0], pageParams[1]);

			list.addAll(list2);
			list.addAll(list3);

			page.setList(list);
			page.setTotal(leaveDynamicQuery.count() + dispatchQuery.count());
		} else {
			HistoricProcessInstanceQuery dynamicQuery = historyService.createHistoricProcessInstanceQuery().finished()
					.orderByProcessInstanceEndTime().desc();
			List<HistoricProcessInstance> list = dynamicQuery.listPage(pageParams[0], pageParams[1]);
			page.setList(list);
			page.setTotal(dynamicQuery.count());
		}

		return new BaseResp<PageInfo<HistoricProcessInstance>>(page);
	}

}
