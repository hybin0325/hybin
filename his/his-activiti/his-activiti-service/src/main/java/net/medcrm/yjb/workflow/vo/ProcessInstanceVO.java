package net.medcrm.yjb.workflow.vo;

import java.io.Serializable;

/**
 * 
 * 办理中的
 * @author Administrator
 *
 */

public class ProcessInstanceVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -627421306274312761L;
	
	private String processDefinitionId;
	private String processDefinitionKey;
	private String processInstanceName;
	private Integer processDefinitionVersion;
	private String deploymentId;
	private String businessKey;
	private  boolean suspended;
	private  String description;
	private String localizedDescription;
	private  String id;
	private  boolean ended;
	private  String activityId;
	private  Object activityName;
	private  String processInstanceId;
	  
	
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
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
	public String getBusinessKey() {
		return businessKey;
	}
	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}
	
	public Integer getProcessDefinitionVersion() {
		return processDefinitionVersion;
	}
	public void setProcessDefinitionVersion(Integer processDefinitionVersion) {
		this.processDefinitionVersion = processDefinitionVersion;
	}
	public String getDeploymentId() {
		return deploymentId;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLocalizedDescription() {
		return localizedDescription;
	}
	public void setLocalizedDescription(String localizedDescription) {
		this.localizedDescription = localizedDescription;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public boolean isSuspended() {
		return suspended;
	}
	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}
	public boolean isEnded() {
		return ended;
	}
	public void setEnded(boolean ended) {
		this.ended = ended;
	}
	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	
	public Object getActivityName() {
		return activityName;
	}
	public void setActivityName(Object activityName) {
		this.activityName = activityName;
	}
	
	

}
