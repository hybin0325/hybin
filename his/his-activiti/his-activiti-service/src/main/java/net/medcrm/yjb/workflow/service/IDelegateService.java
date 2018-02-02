package net.medcrm.yjb.workflow.service;

import java.util.Date;

import net.medcrm.yjb.workflow.domain.DelegateInfo;
/**
 * 自定义代理
 * @author Administrator
 *
 */
public interface IDelegateService {

	DelegateInfo getDelegateInfo(String targetAssignee, String targetProcessDefinitionId);

	void saveRecord(String assignee, String attorney, String taskId);

	void removeRecord(String id);

	void addDelegateInfo(String assignee, String attorney, Date startTime, Date endTime, String processDefinitionId);
}
