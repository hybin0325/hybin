package net.medcrm.yjb.workflow.vo;

import java.io.Serializable;

/**
*@author 原饼
*@version 创建时间2018年1月31日上午10:27:59
**/
public class ModelVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1435779667800814838L;
	private String name;
	private String key;
	private String description;
	private String typeId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	
	
}
