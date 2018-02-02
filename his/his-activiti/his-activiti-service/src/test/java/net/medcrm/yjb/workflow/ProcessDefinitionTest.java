package net.medcrm.yjb.workflow;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessDefinitionTest {
	@Autowired
	private ProcessEngine processEngine;

	// 部署流程定义
	@Test
	public void deployementProcessDefinition() {
		Deployment deployment = processEngine.getRepositoryService()// 获取流程定义和部署对象相关的Service
				.createDeployment()// 创建部署对象
				.name("test-email")// 声明流程的名称
				.addClasspathResource("processes/mail/test-email.bpmn")// 加载资源文件，一次只能加载一个文件
				.addClasspathResource("processes/mail/test-email.png")//
				.deploy();// 完成部署
		System.out.println("部署ID：" + deployment.getId());// 
		System.out.println("部署时间：" + deployment.getDeploymentTime());
	}

	// 部署流程定义
	//@Test
	public void deployementProcessNotify() {
		Deployment deployment = processEngine.getRepositoryService()// 获取流程定义和部署对象相关的Service
				.createDeployment()// 创建部署对象
				.name("任务计划")// 声明流程的名称
				.addClasspathResource("processes/notify.bpmn")// 加载资源文件，一次只能加载一个文件
				.addClasspathResource("processes/notify.png")//
				.deploy();// 完成部署
		System.out.println("部署ID：" + deployment.getId());// 1
		System.out.println("部署名称：" + deployment.getName());//
		System.out.println("部署时间：" + deployment.getDeploymentTime());
	}

	/** 部署请假流程（从zip） */
	//@Test
	public void deploymentProcessDefinition_zip() {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("processes/SimpleUserTask.zip");
		ZipInputStream zipInputStream = new ZipInputStream(in);
		Deployment deployment = processEngine.getRepositoryService()/** 与请假流程和部署对象相关的Service */
				.createDeployment()/** 创建一个部署对象 */
				.name("简单用户任务")/** 添加部署的名称 */
				.addZipInputStream(zipInputStream)/** 指定zip格式的文件完成部署 */
				.deploy();/** 完成部署 */
		/**
		 * 部署ID：1 部署名称：请假流程
		 */
		System.out.println("部署ID：" + deployment.getId());//
		System.out.println("部署名称：" + deployment.getName());//
	}
}
