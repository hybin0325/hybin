package net.medcrm.yjb.workflow.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ManagementService;
import org.activiti.engine.impl.interceptor.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.fileutil.Base64Util;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.hybflow.HistoryProcessInstanceDiagramCmd;
import net.medcrm.yjb.workflow.service.IHflowCommService;
import net.medcrm.yjb.workflow.service.IHflowLdapService;
import net.medcrm.yjb.workflow.util.StringUtils;
import net.medcrm.yjb.workflow.util.WorkFlowType;

/**
 * 流程资配置API
 * 
 * @author hybin
 *
 */
@RestController
@RequestMapping(value = "/hflow/comm")
public class HflowCommController {

	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	@Autowired
	private IHflowLdapService hflowLdapService;

	@Autowired
	private IHflowCommService flowCommService;

	@Autowired
	private ManagementService managementService;

	/**
	 * 读取详细数据
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "流程组件管理--后台初始通用的流程", notes = "通用的流程", httpMethod = "GET")
	@GetMapping(value = "/getStaticHflow")
	public Object getFlow() {
		Map<String, Object> map = new HashMap<>();
		WorkFlowType[] workFlowType = WorkFlowType.values();
		for (WorkFlowType workFlowType2 : workFlowType) {
			map.put(workFlowType2.getIndex(), workFlowType2.getName());
		}
		return new BaseResp<>(map);
	}

	@ApiOperation(value = "流程组件管理--选择本部人领导", notes = "根据申请人选本部门领导", httpMethod = "GET")
	@ApiImplicitParam(name = "applyUserId", value = "申请请人ID,可以不传后默认取当前登陆人", required = false, dataType = "String")
	@GetMapping(value = "/getDeptLeader")
	public Object getDeptLeader(String applyUserId) {
		if (StringUtils.isNull(applyUserId)) {
			BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
			EmployeeVO user = (EmployeeVO) baseEmployee.getData();
			applyUserId = user.getId();
		}
		List<EmployeeVO> list = hflowLdapService.findDeptLeaders(applyUserId);
		return new BaseResp<>(list);
	}

	@ApiOperation(value = "流程组件管理--查看流程图走向", notes = "查看流程图走向,没有标注当前节点,返回base64", httpMethod = "GET")
	@ApiImplicitParam(name = "processInstanceId", value = "流程实例ID", required = true, dataType = "String")
	@GetMapping("/base64/queryProPlan")
	public Object queryProPlanBase64(String processInstanceId, HttpServletResponse response) throws IOException {
		InputStream imageStream = flowCommService.queryProPlan(processInstanceId);
		return new BaseResp<>(Base64Util.ioToBase64(imageStream));
	}
	
	@ApiOperation(value = "流程组件管理--查看流程图走向", notes = "查看流程图走向,没有标注当前节点", httpMethod = "GET")
	@ApiImplicitParam(name = "processInstanceId", value = "流程实例ID", required = true, dataType = "String")
	@GetMapping("/queryProPlan")
	public void queryProPlan(String processInstanceId, HttpServletResponse response) throws IOException {
		InputStream imageStream = flowCommService.queryProPlan(processInstanceId);
		byte[] b = new byte[1024];
		int len;
		while ((len = imageStream.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
	}

	@ApiOperation(value = "流程组件管理--查看流程图走向", notes = "查看流程图走向,标注当前节点", httpMethod = "GET")
	@ApiImplicitParam(name = "processInstanceId", value = "流程实例ID", required = true, dataType = "String")
	@GetMapping("/graphHistory")
	public void graphHistoryProcessInstance(String processInstanceId, HttpServletResponse response)
			throws IOException {
		Command<InputStream> cmd = new HistoryProcessInstanceDiagramCmd(processInstanceId);
		InputStream is = managementService.executeCommand(cmd);
		response.setContentType("image/png");
		int len = 0;
		byte[] b = new byte[1024];
		while ((len = is.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
		is.close();
	}
	
	@ApiOperation(value = "流程组件管理--查看流程图走向", notes = "查看流程图走向,标注当前节点,返回base64", httpMethod = "GET")
	@ApiImplicitParam(name = "processInstanceId", value = "流程实例ID", required = true, dataType = "String")
	@GetMapping("/base64/graphHistory")
	public Object graphHistoryProcessInstance2(String processInstanceId)
			throws IOException {
		if(StringUtils.isNull(processInstanceId))
			return new BaseResp<>(-1,"参数有误",null);
		Command<InputStream> cmd = new HistoryProcessInstanceDiagramCmd(processInstanceId);
		InputStream is = managementService.executeCommand(cmd);
		return new BaseResp<>(Base64Util.ioToBase64(is));
	}
}
