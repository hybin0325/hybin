package net.medcrm.yjb.workflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.workflow.service.IHflowHandleService;

/**
 * 流程办理相关的信息
 * 
 * @author hybin
 *
 */
@RestController
@RequestMapping(value = "/hflow/handle")
public class HflowHandleController {
	@Autowired
	private IHflowHandleService hflowHandleService;


	@ApiOperation(value = "流程办理相关--获取下一个用户任务信息  ", notes = "获取下一个用户任务信息 ", httpMethod = "GET")
	@ApiImplicitParam(name = "taskId", value = "任务Id信息  ", required = true, dataType = "String")
	@GetMapping(value = "/getNextTaskInfo")
	public Object getNextTaskInfo(String taskId) throws Exception {
		return new BaseResp<>(hflowHandleService.getNextTaskGroup(taskId));
	}
	
	

	@ApiOperation(value = "流程办理相关--获取下一个用户任务信息  ", notes = "获取下一个用户任务信息 ", httpMethod = "GET")
	@ApiImplicitParam(name = "taskId", value = "任务Id信息  ", required = true, dataType = "String")
	@GetMapping(value = "/getNextTaskInfo2")
	public Object getNextTaskInfo2(String taskId) throws Exception {
		//hflowHandleService.getNextNode2(taskId)
		//List<String> list= hflowHandleService.getNextTaskUserByTaskId(taskId);
		return new BaseResp<>(hflowHandleService.getNextNode2(taskId));
	}

}
