package net.medcrm.yjb.workflow.vo;

import java.util.Date;

public class ActReProcdefVO {
	
	private String titleName;// 标题
	private String description;//
	private String actProcodefId;// 流程布署成功后流和定义id
	private Integer pVersion;// 版本
	private Integer status;// 状态 0 可用 1停用 2挂起
	private Integer pSort;// 排序
	private String createUser;// 创建人
	private Date createDate;
	private String key;
	private Date updateDate;
	private String updateUser;
	
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
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}
