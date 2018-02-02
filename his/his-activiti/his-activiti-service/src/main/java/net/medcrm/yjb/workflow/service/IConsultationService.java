package net.medcrm.yjb.workflow.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

import net.medcrm.yjb.workflow.domain.Consultation;

public interface IConsultationService {
	int addConsultation(Consultation consultation);
	
	Consultation findById(String id);

	List<Consultation> findAllConsultation(int pageNum, int pageSize);
	
	/**
	 * 启动工作流
	 * @param key
	 * @param businessKey
	 * @param variables
	 * @return
	 */
	public ProcessInstance startWorkflow(String key,String businessKey,Map<String, Object> variables);
	
	public ProcessInstance startWorkflow(Consultation entity, Map<String, Object> variables);
	
	/**
	 * 查询已结束的流程实例
	 * @param processDefinitionKey
	 * @return
	 */
	public List<Consultation> findFinishedProcessInstaces(String processDefinitionKey);
	
	/**
	 * 查询运行中的流程实例
	 * @param processDefinitionKey 流程定义的key
	 * @return
	 */
	public List<Consultation> findRunningProcessInstaces(String processDefinitionKey);
	
	
	/**
	 * 查看当前任务
	 * @param userid
	 * @param processDefinitionKey
	 * @return
	 */
	public List<Consultation> findUserTask(String userid,String processDefinitionKey);
	
	/**
	 * 工作组
	 * @param userid
	 * @param datas
	 * @param processDefinitionKey
	 * @return
	 */
	public List<Consultation> findGroupTask(String userid,List<Group> datas,String processDefinitionKey);
	

	/**
	 * 根据流程定义Id查询流程定义
	 * @param processDefinitionId
	 * @return
	 */
	public ProcessDefinition getProcessDefinition(String processDefinitionId);
	
	
	
	
	public TaskEntity findTaskById(String taskId) throws Exception;
	
}
