package net.medcrm.yjb.workflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
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
public class TestppTest {

	@Autowired
	private ProcessEngine processEngine;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	// 部署流程定义
	// @Test
	public void deployementProcessDefinition() throws InterruptedException {
		Deployment deployment = processEngine.getRepositoryService()// 获取流程定义和部署对象相关的Service
				.createDeployment()// 创建部署对象
				.name("testpp")// 声明流程的名称
				.addClasspathResource("processes/testpp.bpmn")// 加载资源文件，一次只能加载一个文件
				.addClasspathResource("processes/testpp.png")//
				.deploy();// 完成部署
		System.out.println("部署ID：" + deployment.getId());//
		System.out.println("部署时间：" + deployment.getDeploymentTime());
	}

	//@Test
	public void startprocessByKey() {
		String key = "testpp";
		String applyuser = "zyq";
		identityService.setAuthenticatedUserId(applyuser);
		Map<String, Object> variables = new HashMap<>();// 设置流程变量
		variables.put("applyUserId", "qwer");
		variables.put("applyTitle", "test_请假申请流程");
		variables.put("applyTime", "7天");
		variables.put("applyCtreateTime", new Date());
		variables.put("applyReason", "休假");
		// 设置候选人：上级领导审批
		List list = new ArrayList();
		list.add("zzz");
		list.add("xxx");
		variables.put("managerIds", list);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, variables);
		Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
		System.out.println(task.getAssignee());
	}
	
	@Test
	public void query() {
		  List<Task> list = taskService.createTaskQuery().taskCandidateUser("zzz").
	                orderByTaskCreateTime().desc().list();//查询所拥有的候选任务
		  for (Task task : list) {
			System.out.println(task.getProcessVariables());
		}
	}

}
