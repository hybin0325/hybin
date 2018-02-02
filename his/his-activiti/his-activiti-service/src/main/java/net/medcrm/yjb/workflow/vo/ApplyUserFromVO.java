package net.medcrm.yjb.workflow.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
*@author 原饼
*@version 创建时间2018年1月30日下午3:29:12
**/
public class ApplyUserFromVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9154126910925868199L;
	
	@JsonProperty("formData")
	private Map<String, String> variables = new HashMap<>();

	private String processDefinitionId;

	private String fileIds;

	public Map<String, String> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, String> variables) {
		this.variables = variables;
	}

	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}

	public String getFileIds() {
		return fileIds;
	}

	public void setFileIds(String fileIds) {
		this.fileIds = fileIds;
	}
	
	

}
