package net.medcrm.yjb.workflow.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 完成的流程
 * @author Administrator
 *
 */
public class FinishedFlowVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3337257718467713990L;
	private String id ;
	private String processInstanceId;
	private String processDefinitionId;
	private Date startDate;
	private Date endDate;
	private String startUserId;
	private String processDefinitionKey;
	private String processInstanceName;
	private Integer processDefinitionVersion;
	private String deploymentId;
	private String toDate;
	
	private Object form;
	
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	public String getDeploymentId() {
		return deploymentId;
	}
	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Object getForm() {
		return form;
	}
	public void setForm(Object form) {
		this.form = form;
	}
	
	
}
