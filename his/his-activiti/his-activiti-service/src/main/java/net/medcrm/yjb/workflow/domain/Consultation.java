package net.medcrm.yjb.workflow.domain;

import java.util.Date;
import java.util.Map;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 会诊
 * 
 * @author Administrator
 *
 */
public class Consultation {
	private String id;
	private String applyDepartment;// 申请科室
	private String applyDepartmentId;//
	private String applyUser;
	private String applyUserId;// 申请人
	private String patient;// 患者ID
	private Date applyDate;// 申请日期
	private String patientName;// 患者姓名
	private Integer patientBedNumber;// 患者床位
	private String illnessDesc;// 病情描述
	private String consultationResults;// 会诊目的
	private String consultationType;// 会诊类型
	private Date consultationDate;// 会诊日期
	private String appointmentDepartment;// 预约科室
	private String appointmentDepartmentId;
	private String appointmentUser;// 预约医生
	private String appointmentUserId;
	private Date createDate;

	// 流程任务
	private Task task;

	private Map<String, Object> variables;

	// 运行中的流程实例
	private ProcessInstance processInstance;

	// 历史的流程实例
	private HistoricProcessInstance historicProcessInstance;

	// 流程定义
	private ProcessDefinition processDefinition;
	
	private String processInstanceId;//流程实例id

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplyDepartment() {
		return applyDepartment;
	}

	public void setApplyDepartment(String applyDepartment) {
		this.applyDepartment = applyDepartment;
	}

	public String getApplyDepartmentId() {
		return applyDepartmentId;
	}

	public void setApplyDepartmentId(String applyDepartmentId) {
		this.applyDepartmentId = applyDepartmentId;
	}

	public String getApplyUser() {
		return applyUser;
	}

	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}

	public String getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Integer getPatientBedNumber() {
		return patientBedNumber;
	}

	public void setPatientBedNumber(Integer patientBedNumber) {
		this.patientBedNumber = patientBedNumber;
	}

	public String getIllnessDesc() {
		return illnessDesc;
	}

	public void setIllnessDesc(String illnessDesc) {
		this.illnessDesc = illnessDesc;
	}

	public String getConsultationResults() {
		return consultationResults;
	}

	public void setConsultationResults(String consultationResults) {
		this.consultationResults = consultationResults;
	}

	public String getConsultationType() {
		return consultationType;
	}

	public void setConsultationType(String consultationType) {
		this.consultationType = consultationType;
	}

	public Date getConsultationDate() {
		return consultationDate;
	}

	public void setConsultationDate(Date consultationDate) {
		this.consultationDate = consultationDate;
	}

	public String getAppointmentDepartment() {
		return appointmentDepartment;
	}

	public void setAppointmentDepartment(String appointmentDepartment) {
		this.appointmentDepartment = appointmentDepartment;
	}

	public String getAppointmentDepartmentId() {
		return appointmentDepartmentId;
	}

	public void setAppointmentDepartmentId(String appointmentDepartmentId) {
		this.appointmentDepartmentId = appointmentDepartmentId;
	}

	public String getAppointmentUser() {
		return appointmentUser;
	}

	public void setAppointmentUser(String appointmentUser) {
		this.appointmentUser = appointmentUser;
	}

	public String getAppointmentUserId() {
		return appointmentUserId;
	}

	public void setAppointmentUserId(String appointmentUserId) {
		this.appointmentUserId = appointmentUserId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Map<String, Object> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}

	public ProcessInstance getProcessInstance() {
		return processInstance;
	}

	public void setProcessInstance(ProcessInstance processInstance) {
		this.processInstance = processInstance;
	}

	public HistoricProcessInstance getHistoricProcessInstance() {
		return historicProcessInstance;
	}

	public void setHistoricProcessInstance(HistoricProcessInstance historicProcessInstance) {
		this.historicProcessInstance = historicProcessInstance;
	}

	public ProcessDefinition getProcessDefinition() {
		return processDefinition;
	}

	public void setProcessDefinition(ProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	
}
