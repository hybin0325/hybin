package net.medcrm.yjb.workflow.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * jiankong
 * @author Administrator
 *
 */
public class MonitorVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5134985994130997298L;
	private String taskId ;
	private String taskName;
	private String processInstanceId;
	private String processDefinitionId;
	private Date startDate;
	private String startUserId;
	private String startUserName;
	private String processDefinitionKey;
	private String processInstanceName;
	private Integer processDefinitionVersion;
	private String formName;
	private String formVersion;
	private String handler;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getStartUserId() {
		return startUserId;
	}
	public void setStartUserId(String startUserId) {
		this.startUserId = startUserId;
	}
	public String getProcessDefinitionKey() {
		return processDefinitionKey;
	}
	public void setProcessDefinitionKey(String processDefinitionKey) {
		this.processDefinitionKey = processDefinitionKey;
	}
	public String getProcessInstanceName() {
		return processInstanceName;
	}
	public void setProcessInstanceName(String processInstanceName) {
		this.processInstanceName = processInstanceName;
	}
	public Integer getProcessDefinitionVersion() {
		return processDefinitionVersion;
	}
	public void setProcessDefinitionVersion(Integer processDefinitionVersion) {
		this.processDefinitionVersion = processDefinitionVersion;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getFormVersion() {
		return formVersion;
	}
	public void setFormVersion(String formVersion) {
		this.formVersion = formVersion;
	}
	public String getStartUserName() {
		return startUserName;
	}
	public void setStartUserName(String startUserName) {
		this.startUserName = startUserName;
	}
	public String getHandler() {
		return handler;
	}
	public void setHandler(String handler) {
		this.handler = handler;
	}
}
