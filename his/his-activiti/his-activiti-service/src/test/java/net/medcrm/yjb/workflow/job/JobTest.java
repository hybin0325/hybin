package net.medcrm.yjb.workflow.job;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 定时任务测试
 * 
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@EnableTransactionManagement
@SpringBootTest
public class JobTest {
	@Autowired
	private ProcessEngine processEngine;

	// 部署流程定义
	@Test
	public void deployementProcessDefinition() {
		Deployment deployment = processEngine.getRepositoryService()// 获取流程定义和部署对象相关的Service
				.createDeployment()// 创建部署对象
				.name("timer-transition1")// 声明流程的名称
				.addClasspathResource("processes/job/timer-transition.bpmn")// 加载资源文件，一次只能加载一个文件
				.addClasspathResource("processes/job/timer-transition.png")//
				.deploy();// 完成部署
		System.out.println("部署ID：" + deployment.getId());//
		System.out.println("部署时间：" + deployment.getDeploymentTime());
	}
}
