/**
 * 
 */
package net.medcrm.yjb.workflow.domain;

import net.medcrm.yjb.his.common.model.PersistentObject;

/**
 * 模块内容表
 * 
 * @author hybin
 *
 */
public class HflowProcdef extends PersistentObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3434851399237568127L;
	private String titleName;// 标题
	private String description;//
	private Integer type;// 类型：0流程 1表单 3报表 4查询表

	private String actModelId;// 自定义流程模板ID
	private String actProcodefId;// 流程布署成功后流和定义id
	private Integer pVersion;// 版本
	private Integer status;// 状态 0 可用 1停用 2挂起
	private Integer pSort;// 排序

	private String actKey;

	private String modelId;

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getActModelId() {
		return actModelId;
	}

	public void setActModelId(String actModelId) {
		this.actModelId = actModelId;
	}

	public String getActProcodefId() {
		return actProcodefId;
	}

	public void setActProcodefId(String actProcodefId) {
		this.actProcodefId = actProcodefId;
	}

	public Integer getpVersion() {
		return pVersion;
	}

	public void setpVersion(Integer pVersion) {
		this.pVersion = pVersion;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getpSort() {
		return pSort;
	}

	public void setpSort(Integer pSort) {
		this.pSort = pSort;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getActKey() {
		return actKey;
	}

	public void setActKey(String actKey) {
		this.actKey = actKey;
	}
	
	
}
