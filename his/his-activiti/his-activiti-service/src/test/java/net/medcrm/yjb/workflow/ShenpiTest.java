package net.medcrm.yjb.workflow;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.his.mybatis.dynamicDataSource.page.PageInfo;


import net.medcrm.yjb.workflow.domain.Shenpi;
import net.medcrm.yjb.workflow.service.IShenpiService;
import net.medcrm.yjb.workflow.util.PageUtil;
import net.medcrm.yjb.workflow.util.WorkFlowType;
import net.medcrm.yjb.workflow.vo.ShenpiVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShenpiTest {
	
	@Autowired
	private ProcessEngine processEngine;
	
	@Autowired IShenpiService shenpiService;

	// 部署流程定义
	//@Test
	public void deployementProcessDefinition() {
		Deployment deployment = processEngine.getRepositoryService()// 获取流程定义和部署对象相关的Service
				.createDeployment()// 创建部署对象
				.name(WorkFlowType.SHENPI.getIndex())// 声明流程的名称
				.addClasspathResource("processes/jiandanshenpi.bpmn")// 加载资源文件，一次只能加载一个文件
				.addClasspathResource("processes/jiandanshenpi.png")//
				.deploy();// 完成部署
		System.out.println("部署ID：" + deployment.getId());// 
		System.out.println("部署时间：" + deployment.getDeploymentTime());
	}
	
	//@Test
	public void addTest() {
		Shenpi shenpi = new Shenpi();
		shenpi.setUserId("c55470bcb7e1428dabe1dd37d6bc6eba");
		shenpi.setUserName("李晓明");
		shenpi.setTitleName("李晓明的审请33ddasfas");
		shenpi.setMarke("史珍香你要快点批43asfas");
		Map<String, Object> variables = new HashMap<String, Object>();
		ProcessInstance processInstance = shenpiService.startWorkflow(shenpi, variables);
		System.out.println(processInstance.getId());
	}
	
	@Test
	public void findDaiban() {
		PageInfo<ShenpiVO> page = new PageInfo<ShenpiVO>();
		int[] pageParams = PageUtil.init(page, 1, 1000);
		shenpiService.findTodoTasks("c9e1f0a7e81146e29115f304157e6366", page, pageParams);
		System.out.println(page.getList().size());
	}


}
