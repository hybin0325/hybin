package net.medcrm.yjb.workflow.service;

import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.activiti.engine.impl.pvm.process.ActivityImpl;

import net.medcrm.yjb.workflow.vo.TaskModel;

public interface IProcessCoreService {

	/**
	 * 取回流程
	 * @param taskId
	 * @param activityId
	 */
	public void callBackProcess(String taskId, String activityId);
	
	/**
	 * 驳回流程
	 * @param taskId
	 * @param activityId
	 * @param variables
	 */
	public void backProcess(String taskId, String activityId, Map<String, Object> variables);
	
	/**
	 * 根据当前任务ID，查询可以驳回的任务节点
	 * @param taskId
	 * @return
	 */
	List<ActivityImpl> findBackAvtivity(String taskId);
	
	/**
	 * 中止流程(特权人直接审批通过等)
	 * @param taskId
	 */
	public void endProcess(String taskId);
	
	/**
	 * 转办流程
	 * @param taskId
	 * @param userCode
	 */
	public void transferAssignee(String taskId, String userCode);
	
	/**
	 * 会签操作
	 * @param taskId
	 * @param userCodes
	 */
	public void jointProcess(String taskId, List<String> userCodes);
	
	/**
	 * 查询我申请未提交的任务
	 * @param userId
	 * @return
	 * @throws XMLStreamException
	 */
	public List<TaskModel> findFirstTask(String userId) throws XMLStreamException;
}
