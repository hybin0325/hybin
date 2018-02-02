package net.medcrm.yjb.workflow.taskListener;

import java.util.Map;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;

import net.medcrm.yjb.workflow.domain.DelegateInfo;
import net.medcrm.yjb.workflow.service.impl.DelegateServiceImpl;

public class TaskAsigneeListenerImpl implements TaskListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8046462707236976906L;
	@Autowired
	private DelegateServiceImpl delegateServiceImpl;

	@Override
	public void notify(DelegateTask delegateTask) {
		Map<String, Object> map = delegateTask.getVariables();
		delegateTask.setAssignee(map.get("userId").toString());

		// 如果有委托，设置委托人
		String assignee = delegateTask.getAssignee();
		String processDefinitionId = delegateTask.getProcessDefinitionId();
		DelegateInfo delegateInfo = delegateServiceImpl.getDelegateInfo(assignee, processDefinitionId);

		if (delegateInfo == null) {
			return;
		}

		String attorney = delegateInfo.getAttorney();
		delegateTask.setAssignee(attorney);
		delegateServiceImpl.saveRecord(assignee, attorney, delegateTask.getId());

	}
}
