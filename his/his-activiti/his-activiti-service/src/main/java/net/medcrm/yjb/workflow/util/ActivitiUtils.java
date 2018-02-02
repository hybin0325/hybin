package net.medcrm.yjb.workflow.util;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskInfo;

import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.feign.PositionVO;
import net.medcrm.yjb.workflow.domain.HflowProcdef;
import net.medcrm.yjb.workflow.vo.ProcessDefinitionVO;
import net.medcrm.yjb.workflow.vo.ProcessInstanceVO;
import net.medcrm.yjb.workflow.vo.TaskInfoVO;
import net.medcrm.yjb.workflow.vo.TaskVO;

/**
 * @author hasee
 * @TIME 2016年12月27日 注意类的隐藏和实例创建
 */
public class ActivitiUtils {

	public static UserEntity toActivitiUser(EmployeeVO bUser) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(bUser.getId());
		userEntity.setFirstName(bUser.getFullName());
		userEntity.setLastName(bUser.getFullName());
		userEntity.setPassword(null);
		userEntity.setEmail(bUser.getEmail());
		userEntity.setRevision(1);
		return userEntity;
	}

	public static GroupEntity toActivitiGroup(PositionVO bGroup) {
		GroupEntity groupEntity = new GroupEntity();
		groupEntity.setRevision(1);
		groupEntity.setType("assignment");
		groupEntity.setId(bGroup.getId());
		groupEntity.setName(bGroup.getName());
		return groupEntity;
	}

	public static List<org.activiti.engine.identity.Group> toActivitiGroups(List<PositionVO> bGroups) {
		List<org.activiti.engine.identity.Group> groupEntitys = new ArrayList<org.activiti.engine.identity.Group>();
		for (PositionVO bGroup : bGroups) {
			GroupEntity groupEntity = toActivitiGroup(bGroup);
			groupEntitys.add(groupEntity);
		}
		return groupEntitys;
	}

	/**
	 * 转换正在运行
	 * 
	 * @param task
	 * @return
	 */
	public static TaskVO toConverterTaskVO(Task task) {
		TaskVO vo = new TaskVO();
		vo.setAssignee(task.getAssignee());
		vo.setCategory(task.getCategory());
		vo.setCreateTime(task.getCreateTime());
		vo.setDescription(task.getDescription());
		vo.setDueDate(task.getDueDate());
		vo.setExecutionId(task.getExecutionId());
		vo.setFormKey(task.getFormKey());
		vo.setId(task.getId());
		vo.setName(task.getName());
		vo.setOwner(task.getOwner());
		vo.setParentTaskId(task.getParentTaskId());
		vo.setPriority(task.getPriority());
		vo.setProcessDefinitionId(task.getProcessDefinitionId());
		vo.setProcessInstanceId(task.getProcessInstanceId());
		vo.setTaskDefinitionKey(task.getTaskDefinitionKey());
		vo.setTenantId(task.getTenantId());
		vo.setProcessVariables(task.getProcessVariables());
		vo.setTaskLocalVariables(task.getTaskLocalVariables());
		vo.setSuspended(task.isSuspended());
		vo.setDelegationState(task.getDelegationState());
		return vo;
	}

	public static ProcessDefinitionVO toConverterProcessDefinitionVO(ProcessDefinition entity) {
		ProcessDefinitionVO vo = new ProcessDefinitionVO();
		vo.setCategory(entity.getCategory());
		vo.setDeploymentId(entity.getDeploymentId());
		vo.setDescription(entity.getDescription());
		vo.setDiagramResourceName(entity.getDiagramResourceName());
		vo.setHasGraphicalNotation(entity.hasGraphicalNotation());
		vo.setHasStartFormKey(entity.hasStartFormKey());
		vo.setId(entity.getId());
		vo.setKey(entity.getKey());
		vo.setName(entity.getName());
		vo.setResourceName(entity.getResourceName());
		vo.setSuspended(entity.isSuspended());
		vo.setTenantId(entity.getTenantId());
		vo.setVersion(entity.getVersion());
		return vo;

	}
	
	public static ProcessInstanceVO toConverterProcessInstanceVO(ProcessInstance entity,Object activityName) {
		ProcessInstanceVO vo=new ProcessInstanceVO();
		vo.setBusinessKey(entity.getBusinessKey());
		vo.setProcessDefinitionId(entity.getProcessDefinitionId());
		vo.setProcessDefinitionKey(entity.getProcessDefinitionKey());
		vo.setProcessDefinitionVersion(entity.getProcessDefinitionVersion());
		vo.setProcessInstanceName(entity.getProcessDefinitionName());
		vo.setDeploymentId(entity.getDeploymentId());
		vo.setDescription(entity.getDescription());
		vo.setLocalizedDescription(entity.getLocalizedDescription());
		vo.setSuspended(entity.isSuspended());
		vo.setId(entity.getId());
		vo.setEnded(entity.isEnded());
		vo.setActivityId(entity.getActivityId());
		vo.setActivityName(activityName);
		vo.setProcessInstanceId(entity.getProcessInstanceId());
		return vo;
		
	}
	
	public static HflowProcdef toConverterHflowProcdef(ProcessDefinition processDefinition) {
		HflowProcdef procdef = new HflowProcdef();
		procdef.setTitleName(processDefinition.getName());
		procdef.setDescription(processDefinition.getDescription());
		procdef.setpVersion(processDefinition.getVersion());
		procdef.setStatus(processDefinition.isSuspended() ? StatusType.NO.getIndex() : StatusType.TES.getIndex());
		procdef.setActProcodefId(processDefinition.getId());
		procdef.setActKey(processDefinition.getKey());
		return procdef;
	}
	
	public static TaskInfoVO toConverterTaskInfoVO(TaskInfo task) {
		TaskInfoVO vo = new TaskInfoVO();
		vo.setAssignee(task.getAssignee());
		vo.setCategory(task.getCategory());
		vo.setCreateTime(task.getCreateTime());
		vo.setDescription(task.getDescription());
		vo.setDueDate(task.getDueDate());
		vo.setExecutionId(task.getExecutionId());
		vo.setFormKey(task.getFormKey());
		vo.setId(task.getId());
		vo.setName(task.getName());
		vo.setOwner(task.getOwner());
		vo.setParentTaskId(task.getParentTaskId());
		vo.setPriority(task.getPriority());
		vo.setProcessDefinitionId(task.getProcessDefinitionId());
		vo.setProcessInstanceId(task.getProcessInstanceId());
		vo.setTaskDefinitionKey(task.getTaskDefinitionKey());
		vo.setTenantId(task.getTenantId());
		vo.setProcessVariables(task.getProcessVariables());
		vo.setTaskLocalVariables(task.getTaskLocalVariables());
		return vo;
	}

}
