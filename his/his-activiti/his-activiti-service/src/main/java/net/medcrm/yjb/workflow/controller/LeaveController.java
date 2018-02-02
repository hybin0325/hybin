package net.medcrm.yjb.workflow.controller;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.mybatis.dynamicDataSource.page.PageInfo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.workflow.domain.Leave;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.service.ILeaveWorkflowService;
import net.medcrm.yjb.workflow.util.PageUtil;
import net.medcrm.yjb.workflow.util.Variable;

/**
 * 请假控制器，包含保存、启动流程
 *
 * @author HenryYan
 */
@Controller
@RequestMapping(value = "/oa/leave")
public class LeaveController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected ILeaveWorkflowService workflowService;

	@Autowired
	protected RuntimeService runtimeService;

	@Autowired
	protected TaskService taskService;
	
	@Autowired
	private EmployeeServiceClient employeeServiceClient;
	

	/**
	 * 启动请假流程
	 *
	 * @param leave
	 */
	@ApiOperation(value = "启动请假流程", notes = "系统定好的请假流程", httpMethod = "POST")
	@ApiImplicitParam(name = "leave", value = "请假流程实例leave", required = false, dataType = "leave")
	@PostMapping(value = "start")
	public Object startWorkflow(Leave leave) {
		try {
			BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
			EmployeeVO user = (EmployeeVO) baseEmployee.getData();
			// 用户未登录不能操作
			leave.setUserId(user.getAccountId());
			Map<String, Object> variables = new HashMap<String, Object>();
			ProcessInstance processInstance = workflowService.startWorkflow(leave, variables);
			logger.info("流程已启动，流程ID：", processInstance.getId());
		} catch (ActivitiException e) {
			if (e.getMessage().indexOf("no processes deployed with key") != -1) {
				logger.warn("没有部署流程!", e);
				return new BaseResp<>(ResultStatus.error_start_workflow);
			} else {
				logger.error("启动请假流程失败：", e);
				return new BaseResp<>(ResultStatus.http_status_internal_server_error);
			}
		} catch (Exception e) {
			logger.error("启动请假流程失败：", e);
			return new BaseResp<>(ResultStatus.http_status_internal_server_error);
		}
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	/**
	 * 任务列表
	 *
	 * @param leave
	 */
	@ApiOperation(value = "当前用户请假流程任务列表", notes = "根据每页数pageSize,当前页码pageNum查询当前用户请假流程任务列表", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "每页数pageSize", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageNum", value = "当前页码pageNum", required = false, dataType = "Integer") })
	@PostMapping(value = "list/task")
	public Object taskList(@RequestParam(value = "pageSize", defaultValue = "1000", required = false) Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum) {
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();

		PageInfo<Leave> page = new PageInfo<Leave>();
		int[] pageParams = PageUtil.init(page, pageNum, pageSize);
		workflowService.findTodoTasks(user.getAccountId(), page, pageParams);
		return new BaseResp<PageInfo<Leave>>(page);
	}

	/**
	 * 读取运行中的流程实例
	 *
	 * @return
	 */
	@ApiOperation(value = "查看所有运行中的请假流程实例", notes = "根据每页数pageSize,当前页码pageNum查询所有运行中的请假流程实例", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "每页数pageSize", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageNum", value = "当前页码pageNum", required = false, dataType = "Integer") })
	@PostMapping(value = "list/running")
	public Object runningList(
			@RequestParam(value = "pageSize", defaultValue = "1000", required = false) Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum) {
		PageInfo<Leave> page = new PageInfo<Leave>();
		int[] pageParams = PageUtil.init(page, pageNum, pageSize);
		workflowService.findRunningProcessInstaces(page, pageParams);
		return new BaseResp<PageInfo<Leave>>(page);
	}

	/**
	 * 读取运行完成的流程实例
	 *
	 * @return
	 */
	@ApiOperation(value = "查看所有运行完成的请假流程实例", notes = "根据每页数pageSize,当前页码pageNum查询所有运行完成的请假流程实例", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "每页数pageSize", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageNum", value = "当前页码pageNum", required = false, dataType = "Integer") })
	@PostMapping(value = "list/finished")
	public Object finishedList(
			@RequestParam(value = "pageSize", defaultValue = "1000", required = false) Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum) {

		PageInfo<Leave> page = new PageInfo<Leave>();
		int[] pageParams = PageUtil.init(page, pageNum, pageSize);
		workflowService.findFinishedProcessInstaces(page, pageParams);
		return new BaseResp<PageInfo<Leave>>(page);
	}

	/**
	 * 签收任务
	 */
	@ApiOperation(value = "签收任务", notes = "签收任务", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "任务ID", required = false, dataType = "String"),
			@ApiImplicitParam(name = "redirectAttributes", value = "redirectAttributes自定义类", required = false, dataType = "RedirectAttributes") })
	@PostMapping(value = "task/claim")
	public Object claim(@PathVariable("id") String taskId, RedirectAttributes redirectAttributes) {
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		taskService.claim(taskId, user.getAccountId());
		return new BaseResp<>(ResultStatus.error_claim_workflow);
	}

	/**
	 * 读取详细数据
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查看详细数据", notes = "查看详细数据", httpMethod = "GET")
	@ApiImplicitParam(name = "id", value = "请假id", required = true, dataType = "String")
	@GetMapping(value = "detail/{id}")
	public Object getLeave(@PathVariable("id") String id) {
		Leave leave = workflowService.findById(id);
		return new BaseResp<Leave>(leave);
	}

	/**
	 * 读取详细数据
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查看详细数据", notes = "查看详细数据", httpMethod = "GET")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "请假id", required = false, dataType = "String"),
			@ApiImplicitParam(name = "taskId", value = "流程实例id", required = false, dataType = "String") })
	@RequestMapping(value = "detail-with-vars/{id}/{taskId}")
	public Object getLeaveWithVars(@PathVariable("id") String id, @PathVariable("taskId") String taskId) {
		Leave leave = workflowService.findById(id);
		Map<String, Object> variables = taskService.getVariables(taskId);
		leave.setVariables(variables);
		return new BaseResp<Leave>(leave);
	}

	/**
	 * 办理完成任务
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "办理任务", notes = "办理任务", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "任务ID", required = false, dataType = "String"),
			@ApiImplicitParam(name = "Variable", value = "var自定义类", required = false, dataType = "Variable") })
	@PostMapping(value = "complete/{id}")
	public Object complete(@PathVariable("id") String taskId, Variable var) {

		Map<String, Object> variables = var.getVariableMap();
		taskService.complete(taskId, variables);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	

}
