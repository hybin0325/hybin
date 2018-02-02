package com.his.mybatis.pagination;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class Page<T> implements Serializable {

	private Object query;
	private List data;
	private Long totalSize;
	private Integer pageSize = 20;
	private Integer pageNumber = 1;
	private Integer totalPage;

	public Page() {
		query = new HashMap<Object, Object>(0);
	}

	public Page(Integer pageNumber, Integer pageSize) {
		query = new HashMap<Object, Object>(0);
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public Object getQuery() {
		return query;
	}

	public void setQuery(Object query) {
		this.query = query;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {

		this.totalSize = totalSize;
		this.totalPage = Double.valueOf(Math.ceil(new Double(totalSize) / pageSize)).intValue();
	}

	public Integer getStart() {
		return (pageNumber - 1) * pageSize;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = Math.max(1, pageNumber);
	}

	public Integer getTotalPage() {
		return totalPage;
	}
}
