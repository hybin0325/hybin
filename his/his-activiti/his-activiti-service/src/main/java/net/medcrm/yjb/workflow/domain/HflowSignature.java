package net.medcrm.yjb.workflow.domain;

import java.util.Date;

import net.medcrm.yjb.his.common.model.PersistentObject;

public class HflowSignature extends PersistentObject {

	/**
	* 
	*/
	private static final long serialVersionUID = 4039117649299339710L;
	private String processInstanceId;
	private String taskDefKey;
	private String taskDefName;
	private String opinion;
	private String handler;
	private String handlerId;
	private String handlerDeptName;
	private Date sendDate;
	private String sender;
	private String senderDeptName;
	private String useDate;
	
	private String proId;
	
	private int pSort;

	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getTaskDefKey() {
		return taskDefKey;
	}
	public void setTaskDefKey(String taskDefKey) {
		this.taskDefKey = taskDefKey;
	}
	public String getTaskDefName() {
		return taskDefName;
	}
	public void setTaskDefName(String taskDefName) {
		this.taskDefName = taskDefName;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getHandler() {
		return handler;
	}
	public void setHandler(String handler) {
		this.handler = handler;
	}
	public String getHandlerId() {
		return handlerId;
	}
	public void setHandlerId(String handlerId) {
		this.handlerId = handlerId;
	}
	public String getHandlerDeptName() {
		return handlerDeptName;
	}
	public void setHandlerDeptName(String handlerDeptName) {
		this.handlerDeptName = handlerDeptName;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderDeptName() {
		return senderDeptName;
	}
	public void setSenderDeptName(String senderDeptName) {
		this.senderDeptName = senderDeptName;
	}
	public String getUseDate() {
		return useDate;
	}
	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}
	public int getpSort() {
		return pSort;
	}
	public void setpSort(int pSort) {
		this.pSort = pSort;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	
}
