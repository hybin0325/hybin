package com.edas.business.systask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.systask.quartz.QuartzEntity;
import com.edas.business.systask.service.TaskService;
import com.edas.business.systask.service.impl.QuartzService;
import com.edas.edascommon.model.Result;

import io.swagger.annotations.Api;

/**
 * <p>
 * File Name: ApiController.java
 * </p>
 * <p>
 * Description: 开放api，不需要token
 * </p>
 * <p>
 * Date：2019年5月27日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */

@Api(tags = "open-apis", description = "第三方调用-apis")
@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private QuartzService quartzService;
	
	@GetMapping(value = "/test")
	public Object test() {			
		return Result.success(taskService.selectAll());
	}
	
	@GetMapping(value = "/quartz")
	public Object quartz() {		
		QuartzEntity quartz = new QuartzEntity();
		quartz.setJobName("job1");
		quartz.setJobGroup("计划任务");
		quartz.setJobClassName("com.edas.business.systask.quartz.TaskJob"); 
		quartz.setDescription("计划任务启动:job1");
		quartz.setCronExpression("0/10 * * * * ?");
		quartzService.save(quartz);
		return "ok";
	}
}
