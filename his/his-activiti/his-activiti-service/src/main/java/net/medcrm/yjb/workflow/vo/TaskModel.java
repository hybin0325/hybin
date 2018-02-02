package net.medcrm.yjb.workflow.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class TaskModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3883192040788925186L;
	
	private String lastForm;
	private String assignee;
	private Date createTime;
	private String id;
	private String name;
	private String processInstanceId;
	private String processDefId;
	private String formKey;
	private String deploymentName;
	private Map<String, String> formData;
	public String getLastForm() {
		return lastForm;
	}
	public void setLastForm(String lastForm) {
		this.lastForm = lastForm;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getProcessDefId() {
		return processDefId;
	}
	public void setProcessDefId(String processDefId) {
		this.processDefId = processDefId;
	}
	public String getFormKey() {
		return formKey;
	}
	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}
	public String getDeploymentName() {
		return deploymentName;
	}
	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}
	public Map<String, String> getFormData() {
		return formData;
	}
	public void setFormData(Map<String, String> formData) {
		this.formData = formData;
	}
}
