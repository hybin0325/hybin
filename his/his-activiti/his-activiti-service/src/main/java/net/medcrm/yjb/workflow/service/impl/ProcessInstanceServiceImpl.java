package net.medcrm.yjb.workflow.service.impl;

import java.util.List;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.log.LoggerUtils;
import net.medcrm.yjb.workflow.service.IHflowFormFileService;
import net.medcrm.yjb.workflow.service.IHflowSignatureService;
import net.medcrm.yjb.workflow.service.IProcessInstanceService;

@Service
public class ProcessInstanceServiceImpl implements IProcessInstanceService {

	@Autowired
	private IdentityService identityService;

	@Autowired
	private FormService formService;
	
	@Autowired
	private IHflowFormFileService flowFormFileService;
	
	@Autowired
	private IHflowSignatureService flowSignatureService;
	
	@Autowired
	private TaskService taskService;

	@Override
	@Transactional
	public void saveProcessInstance(String processDefinitionId, Map<String, String> formProperties, EmployeeVO user,String fileIds,Map<String,Object> variables) {
		try {
			identityService.setAuthenticatedUserId(user.getId());
			ProcessInstance processInstance = formService.submitStartFormData(processDefinitionId, formProperties);
			
			LoggerUtils.debug(this.getClass(), "start a processinstance: {}" + processInstance);

			LoggerUtils.debug(this.getClass(), "message", "启动成功，流程ID：" + processInstance.getId());
			
			flowFormFileService.updateBatch(processInstance.getId(),fileIds);
			
			flowSignatureService.saveOpeion(user.getId(), user.getFullName(), user.getMajorName(),
					processInstance.getId());
			
			setTaskVariables(processInstance.getId(), variables);
			
		} finally {
			identityService.setAuthenticatedUserId(null);
		}

	}
	
	/**
	 * 
	 * 
	 * @param taskId
	 * @return
	 */
	public Map<String, Object> setTaskVariables(String processInstanceId,Map<String,Object> variables) {
		List<Task> taskList = taskService.createTaskQuery().processInstanceId(processInstanceId)
				.active().list();
		Task task= taskList.get(0);
		taskService.setVariables(task.getId(),variables);
		return variables;
	}

	/**
	 * 得到流程变量
	 * 
	 * @param taskId
	 * @return
	 */
	public Map<String, Object> getTaskVariables(String taskId) {
		Map<String, Object> variables = taskService.getVariables(taskId);
		LoggerUtils.debug(this.getClass(), "-----------------------" + variables);
		return variables;
	}

}
