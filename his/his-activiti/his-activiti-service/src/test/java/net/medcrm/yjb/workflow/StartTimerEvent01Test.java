package net.medcrm.yjb.workflow;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.medcrm.yjb.workflow.jump.MyBeanStartTimerEvent;
import net.medcrm.yjb.workflow.service.IShenpiService;
import net.medcrm.yjb.workflow.util.WorkFlowType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StartTimerEvent01Test {

	@Autowired
	private ProcessEngine processEngine;

	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;

	// 部署流程定义
	@Test
	public void deployementProcessDefinition() throws InterruptedException {
		Deployment deployment = processEngine.getRepositoryService()// 获取流程定义和部署对象相关的Service
				.createDeployment()// 创建部署对象
				.name(WorkFlowType.SHENPI.getIndex())// 声明流程的名称
				.addClasspathResource("processes/startTimerEvent01.bpmn")// 加载资源文件，一次只能加载一个文件
				.addClasspathResource("processes/startTimerEvent01.png")//
				.deploy();// 完成部署
		System.out.println("部署ID：" + deployment.getId());//
		System.out.println("部署时间：" + deployment.getDeploymentTime());

		// 启动流程
		System.out.println("开始启动流程...");
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("myDate1", "2018-01-07T20:34:00");
		variables.put("myDate2", "2018-01-07T20:35:00");
		variables.put("myBean", new MyBeanStartTimerEvent());
		runtimeService.startProcessInstanceByKey("startTimerEvent01", variables);

		// 查询第一个任务（需要等到第一个定时器触发后才能得到任务）
		Thread.sleep(1000 * 60);

		Task task = taskService.createTaskQuery().singleResult();
		System.out.println("task = " + task);
		System.out.println("任务ID：" + task.getId() + "  任务名称：" + task.getName());
		taskService.complete(task.getId());

		// 重置第二个定时器的时间
		Thread.sleep(1000 * 5);
		Map<String, Object> variables2 = new HashMap<String, Object>();
		variables2.put("myDate2", "2018-01-07T20:37:00");
		runtimeService.setVariables(task.getExecutionId(), variables2);

		// 流程结束
		System.out.println("流程结束...");
	}
}
