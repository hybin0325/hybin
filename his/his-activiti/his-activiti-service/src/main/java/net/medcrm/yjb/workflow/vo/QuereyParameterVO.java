package net.medcrm.yjb.workflow.vo;

import java.io.Serializable;

/**
 * @author 原饼
 * @version 创建时间2018年1月29日上午10:42:09
 * 查询参数
 **/
public class QuereyParameterVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4386623120196368891L;

	private Integer pageSize;
	private Integer pageNum;
	private String modelId;
	private String queryValue;
	private String handleType;
	private String startDate;
	private String endDate;
	
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getQueryValue() {
		return queryValue;
	}

	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
