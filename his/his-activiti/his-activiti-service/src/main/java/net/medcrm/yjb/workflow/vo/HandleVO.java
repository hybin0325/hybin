package net.medcrm.yjb.workflow.vo;

import java.io.Serializable;

/**
 * 待办、办理返回前端类
 * @author Administrator
 *
 */
public class HandleVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1694245130099174408L;
	private TaskVO task;
	private ProcessDefinitionVO processDefinition;
	private ProcessInstanceVO processInstance;
	private Object form;
	public TaskVO getTask() {
		return task;
	}
	public void setTask(TaskVO task) {
		this.task = task;
	}
	public ProcessDefinitionVO getProcessDefinition() {
		return processDefinition;
	}
	public void setProcessDefinition(ProcessDefinitionVO processDefinition) {
		this.processDefinition = processDefinition;
	}
	public ProcessInstanceVO getProcessInstance() {
		return processInstance;
	}
	public void setProcessInstance(ProcessInstanceVO processInstance) {
		this.processInstance = processInstance;
	}
	public Object getForm() {
		return form;
	}
	public void setForm(Object form) {
		this.form = form;
	}
	
	
}
