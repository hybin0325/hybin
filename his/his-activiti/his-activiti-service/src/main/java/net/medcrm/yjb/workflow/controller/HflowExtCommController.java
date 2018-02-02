package net.medcrm.yjb.workflow.controller;


import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.log.LoggerUtils;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.service.IProcessCoreService;
import net.medcrm.yjb.workflow.util.StringUtils;

/**
 * 流程扩展类
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value = "/flow/ext/comm")
public class HflowExtCommController {
	
	@Autowired
	private IProcessCoreService processCoreService;
	
	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	@ApiOperation(value = "流程扩展管理--根据当前任务ID，查询可以驳回的任务节点", notes = "根据当前任务ID，查询可以驳回的任务节点", httpMethod = "GET")
	@ApiImplicitParam(name = "taskId", value = "任务ID", required = true, dataType = "String")
	@GetMapping(value = "/findBackAvtivity")
	public Object findBackAvtivity(String taskId) {
		if(StringUtils.isNull(taskId))
		   return new BaseResp<>(-1,"参数有误",null);
		List<ActivityImpl> list=processCoreService.findBackAvtivity(taskId);
		
		List<Map<String, Object>> mapList = Lists.newArrayList();
		for (ActivityImpl activityImpl : list) {
			Map<String, Object> map = Maps.newHashMap();
			map.put("activityId", activityImpl.getId());
			mapList.add(map);
			LoggerUtils.debug(this.getClass(), "activityImpl"+activityImpl);
		}
		return new BaseResp<>(mapList);
	}
	
	@ApiOperation(value = "流程扩展管理--取回流程", notes = "取回流程", httpMethod = "GET")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "taskId", value = "任务ID", required = true, dataType = "String"),
		@ApiImplicitParam(name = "activityId", value = "流程节点ID", required = true, dataType = "String")})
	@GetMapping(value = "/callBackProcess")
	public Object callBackProcess(String taskId, String activityId) {
		if(StringUtils.isNull(taskId))
			   return new BaseResp<>(-1,"参数有误",null);
		if(StringUtils.isNull(activityId))
			   return new BaseResp<>(-1,"参数有误",null);
		processCoreService.callBackProcess(taskId, activityId);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}
	
	@ApiOperation(value = "流程扩展管理--驳回流程", notes = "驳回流程", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "taskId", value = "任务ID", required = true, dataType = "String"),
		@ApiImplicitParam(name = "activityId", value = "流程节点ID", required = true, dataType = "String"),
		@ApiImplicitParam(name = "variables", value = "驳回流程的参数", required = false, dataType = "String")})
	@PostMapping(value = "/backProcess")
	public Object backProcess(String taskId, String activityId ,@RequestBody String variables) {
		if(StringUtils.isNull(taskId))
			   return new BaseResp<>(-1,"参数有误",null);
		if(StringUtils.isNull(activityId))
			   return new BaseResp<>(-1,"参数有误",null);
		
		Map<String, Object> formProperties = JSON.parseObject(variables);
		processCoreService.backProcess(taskId, activityId,formProperties);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}
	
	@ApiOperation(value = "流程扩展管理--中止流程(特权人直接审批通过等)", notes = "中止流程(特权人直接审批通过等)", httpMethod = "GET")
	@ApiImplicitParam(name = "taskId", value = "任务ID", required = true, dataType = "String")
	@GetMapping(value = "/endProcess")
	public Object endProcess(String taskId) {
		if(StringUtils.isNull(taskId))
		   return new BaseResp<>(-1,"参数有误",null);
		processCoreService.endProcess(taskId);
	
		return new BaseResp<>(ResultStatus.SUCCESS);
	}
	
	
	@ApiOperation(value = "流程扩展管理--转办流程", notes = "转办流程", httpMethod = "GET")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "taskId", value = "任务ID", required = true, dataType = "String"),
		@ApiImplicitParam(name = "userId", value = "被转办人Id", required = true, dataType = "String")})
	@GetMapping(value = "/transferAssignee")
	public Object transferAssignee(String taskId, String userId) {
		if(StringUtils.isNull(taskId))
			   return new BaseResp<>(-1,"参数有误",null);
		if(StringUtils.isNull(userId))
			   return new BaseResp<>(-1,"参数有误",null);
		processCoreService.transferAssignee(taskId, userId);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}
	
	@ApiOperation(value = "流程扩展管理--会签操作", notes = "会签操作", httpMethod = "GET")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "taskId", value = "任务ID", required = true, dataType = "String"),
		@ApiImplicitParam(name = "userIds", value = "会签人账号,多个用逗号拼接", required = true, dataType = "String")})
	@GetMapping(value = "/jointProcess")
	public Object jointProcess(String taskId, String userIds) {
		if(StringUtils.isNull(taskId))
			   return new BaseResp<>(-1,"参数有误",null);
		if(StringUtils.isNull(userIds))
			   return new BaseResp<>(-1,"参数有误",null);
		List<String> userList= StringUtils.str2List(userIds, ",");
		processCoreService.jointProcess(taskId, userList);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}
	
	@ApiOperation(value = "流程扩展管理--查询我申请任务", notes = "查询我申请任务", httpMethod = "GET")
	@GetMapping(value = "/findFirstTask")
	public Object findFirstTask() throws XMLStreamException {
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		return new BaseResp<>(processCoreService.findFirstTask(user.getId()));
	}
	
}
