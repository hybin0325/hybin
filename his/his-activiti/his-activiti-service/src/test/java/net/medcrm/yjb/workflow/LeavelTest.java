package net.medcrm.yjb.workflow;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.medcrm.yjb.workflow.domain.Leave;
import net.medcrm.yjb.workflow.service.ILeaveWorkflowService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeavelTest {

	@Autowired
	private ILeaveWorkflowService workflowService;

	@Test
	public void addTest() {
		Leave leave = new Leave();
		leave.setStartTime(new Date());
		leave.setEndTime(new Date());
		leave.setReason("云付出盽要");
		leave.setApplyTime(new Date());
		leave.setUserId("admin");
		leave.setLeaveType("调休");
		leave.createPersistentObject();
		Map<String, Object> variables = new HashMap<String, Object>();
		ProcessInstance processInstance = workflowService.startWorkflow(leave, variables);
		System.out.println(processInstance.getId());
	}

}
