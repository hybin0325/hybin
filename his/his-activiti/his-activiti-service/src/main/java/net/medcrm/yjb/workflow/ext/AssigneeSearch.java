package net.medcrm.yjb.workflow.ext;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.util.StringUtils;

public class AssigneeSearch implements TaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3127008559779556962L;
	
	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	@SuppressWarnings("unchecked")
	@Override
	public void notify(DelegateTask delegateTask) {
		
		String userId = delegateTask.getVariable("applyUserId").toString();
		BaseResp<List<String>> base = employeeServiceClient.getEmployLeader(userId);
		List<String> leaderList=(List<String>)base.getData();
		delegateTask.setVariable("deptLeaderUser", leaderList);
		
	}
	
}