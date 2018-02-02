/**
 * 
 */
package net.medcrm.yjb.workflow.domain;

import java.util.Date;

import net.medcrm.yjb.his.common.model.PersistentObject;

/**
 * 代理
 * @author hybin
 *
 */
public class DelegateInfo extends PersistentObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7030533611922102367L;
	
	private String assignee;
    private String attorney;
    private Date startTime;
    private Date endTime;
    private String processDefinitionId;
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
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}
    
    
}
