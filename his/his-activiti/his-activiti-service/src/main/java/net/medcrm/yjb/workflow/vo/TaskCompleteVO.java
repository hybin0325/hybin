package net.medcrm.yjb.workflow.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 原饼
 * @version 创建时间2018年1月29日上午10:07:09
 **/
public class TaskCompleteVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3343155137772179662L;

	@JsonProperty("formData")
	private Map<String, Object> variables = new HashMap<>();

	private String opinion;

	private String nextHandleUser;

	private String taskId;

	public Map<String, Object> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getNextHandleUser() {
		return nextHandleUser;
	}

	public void setNextHandleUser(String nextHandleUser) {
		this.nextHandleUser = nextHandleUser;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

}
