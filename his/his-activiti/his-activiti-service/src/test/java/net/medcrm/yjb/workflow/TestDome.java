package net.medcrm.yjb.workflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDome {
	@Autowired
	private ProcessEngine processEngine;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;

	// 部署流程定义
	@Test
	public void addTest() {
		Deployment deployment = processEngine.getRepositoryService()// 获取流程定义和部署对象相关的Service
				.createDeployment()// 创建部署对象
				.name("huiqian")// 声明流程的名称
				.addClasspathResource("processes/testhuiqi.bpmn")// 加载资源文件，一次只能加载一个文件
				.addClasspathResource("processes/testhuiqi.png")//
				.deploy();// 完成部署
		System.out.println("部署ID：" + deployment.getId());// 
		System.out.println("部署时间：" + deployment.getDeploymentTime());
		
		List<String> assigneeList=new ArrayList<String>(); //分配任务的人员
		assigneeList.add("tom");
		assigneeList.add("jeck");
		assigneeList.add("mary");
		Map<String, Object> vars = new HashMap<String, Object>(); //参数
		vars.put("assigneeList", assigneeList);

		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("huiqian",vars);
		
		System.out.println("afash：" + processInstance.getActivityId());
	}
	
	@Test
	public void getTest() {
		List<Task> tasks = taskService.createTaskQuery().taskAssignee("mary").list();
		System.out.println(tasks.size()+"   ;9999999999999999");
	}
}
