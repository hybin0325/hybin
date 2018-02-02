package net.medcrm.yjb.workflow.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.delegate.Expression;
import org.activiti.engine.impl.task.TaskDefinition;

public interface IHflowCommService {
	
	
	List<Object> getNodeInfo(String processDefinitionId);
	
	/**
	 * 取开始节点的信息
	 * @param processDefinitionId
	 * @return
	 */
	Map<String,Object> getStartEventInfo(String processInstanceId);
	
	/**
	 * 根据与流程定义key获取当前节点的下一个任务节点
	 * @param key
	 * @param activityId
	 * @param elString
	 * @param bFlag
	 * @return
	 */
	TaskDefinition getNextTaskDefinition(String key, String activityId, String elString, boolean bFlag);
	
	TaskDefinition getNextTaskDefinition2(String key, String activityId, String elString, boolean bFlag);
	
	Object getBackUser(String actKey, String processInstanceId);
	
	List<Map<String, Object>> getUserInfoList(List<String> alUsers);
	
	List<Map<String, Object>> getUserInfos(List<String> alGroups);
	
	InputStream queryProPlan(String processInstanceId) throws IOException ;
	
	List<Map<String, Object>> getTaskDefinition(String processDefinitionId);
	
	Object getActivityImplInfo(String processDefinitionId,String activityId);
	
	Set<Expression> getNextTaskGroup(String taskId)throws Exception ;
	
	List<Map<String, Object>> findNextUserList(String taskId);
	
	Map<String,Object> getQueryUser(String handleType,String userId);

}
