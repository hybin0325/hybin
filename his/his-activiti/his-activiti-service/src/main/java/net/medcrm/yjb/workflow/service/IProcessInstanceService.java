package net.medcrm.yjb.workflow.service;

import java.util.Map;

import net.medcrm.yjb.his.feign.EmployeeVO;

/**
 * 流程实例保存
 * @author Administrator
 *
 */
public interface IProcessInstanceService {

	public void saveProcessInstance(String processDefinitionId,Map<String, String> formProperties, EmployeeVO user,String fileIds,Map<String,Object> variables);
	
	public Map<String, Object> getTaskVariables(String taskId);

}
