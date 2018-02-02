package net.medcrm.yjb.workflow.domain;

import java.util.Date;

import net.medcrm.yjb.his.common.model.PersistentObject;

/**
 * 代理
 * 
 * @author hybin
 *
 */
public class DelegateHistory extends PersistentObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4405203362563444498L;
	
	private String assignee;
	private String attorney;
	private Date delegateTime;
	private String taskId;
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getAttorney() {
		return attorney;
	}
	public void setAttorney(String attorney) {
		this.attorney = attorney;
	}
	public Date getDelegateTime() {
		return delegateTime;
	}
	public void setDelegateTime(Date delegateTime) {
		this.delegateTime = delegateTime;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	
}
