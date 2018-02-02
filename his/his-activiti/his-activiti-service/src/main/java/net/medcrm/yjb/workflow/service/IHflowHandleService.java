package net.medcrm.yjb.workflow.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.bpmn.model.FlowElement;
import org.activiti.engine.delegate.Expression;

import net.medcrm.yjb.his.feign.EmployeeVO;

/**
 * 流程办理相关
 * 
 * @author Administrator
 *
 */
public interface IHflowHandleService {


	Set<Expression> getNextTaskGroup(String taskId) throws Exception ;
	
	List<FlowElement> getNextNode2(String taskId);
	
	List<String> getNextTaskUserByTaskId(String taskId);
	
	void updateHandler(String processInstanceId,String userId);
	
	void updateClaim(String taskId,String nextHandleUser,String opinion ,Map<String, Object> formProperties,EmployeeVO user);
}
