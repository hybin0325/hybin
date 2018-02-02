package net.medcrm.yjb.workflow.jump;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 会签测试
 * 
 * @author hybin
 *
 */
@RunWith(SpringRunner.class)
@EnableTransactionManagement
@SpringBootTest
public class JumpTest {
	@Autowired
	private ProcessEngine processEngine;

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;

	// 部署流程定义
	// @Test
	public void deployementProcessDefinition() {
		Deployment deployment = processEngine.getRepositoryService()// 获取流程定义和部署对象相关的Service
				.createDeployment()// 创建部署对象
				.name("multiInstance")// 声明流程的名称
				.addClasspathResource("processes/jump/multiInstance.bpmn")// 加载资源文件，一次只能加载一个文件
				.addClasspathResource("processes/jump/multiInstance.png")//
				.deploy();// 完成部署
		System.out.println("部署ID：" + deployment.getId());//
		System.out.println("部署时间：" + deployment.getDeploymentTime());
	}

	// @Test
	public void startProcessInstanceById() throws IOException {
		// runtimeService.startProcessInstanceById("subprocess:1:4", "shareniu");

		Map<String, Object> var = new HashMap<String, Object>();
		var.put("a", "a");
		runtimeService.startProcessInstanceById("multiInstance:1:42504");

	}

	@Test
	public void findActivities() {
		String processDefinitionId = "multiInstance:1:42504";
		ProcessDefinitionEntity pdf = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(processDefinitionId);
		List<ActivityImpl> activities = pdf.getActivities();
		for (ActivityImpl activityImpl : activities) {
			Object object = activityImpl.getProperties().get(ExtensionBpmnConstants.PROPERTY_OPERATIONS_DEFINITION);
			if (object instanceof Map) {
				Map<String, Object> map = (Map<String, Object>) object;
				for (Object obj : map.keySet()) {
					ExtensionOperation value = (ExtensionOperation) map.get(obj);
				}
			}
			if (activityImpl.getId().equals("operationTask")) {
				// 获取operationTask节点的入线
				List<PvmTransition> incomingTransitions = activityImpl.getIncomingTransitions();
				System.out.println(incomingTransitions.get(0).getId());
				// 获取operationTask节点的出线
				List<PvmTransition> outgoingTransitions = activityImpl.getOutgoingTransitions();
				for (PvmTransition pvmTransition : outgoingTransitions) {
				}
			}
		}
	}

}
