package net.medcrm.yjb.workflow.vo;

import java.io.Serializable;

public class ShenpiVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7515635520568067449L;
	private String userId;
	private String userName;
	private String titleName;
	private String marke;
	
	private TaskVO task;
	
	private ProcessInstanceVO processInstance;
	
	private ProcessDefinitionVO processDefinition;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getMarke() {
		return marke;
	}
	public void setMarke(String marke) {
		this.marke = marke;
	}
	public TaskVO getTask() {
		return task;
	}
	public void setTask(TaskVO task) {
		this.task = task;
	}
	public ProcessInstanceVO getProcessInstance() {
		return processInstance;
	}
	public void setProcessInstance(ProcessInstanceVO processInstance) {
		this.processInstance = processInstance;
	}
	public ProcessDefinitionVO getProcessDefinition() {
		return processDefinition;
	}
	public void setProcessDefinition(ProcessDefinitionVO processDefinition) {
		this.processDefinition = processDefinition;
	}
	
}
