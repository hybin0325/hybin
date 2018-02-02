package net.medcrm.yjb.his.omp.configure;

import java.util.List;

public class ResponseModel {
	Integer code;
	List<?> listData;
	Object data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public List<?> getListData() {
		return listData;
	}
	public void setListData(List<?> listData) {
		this.listData = listData;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResponseModel(Integer code) {
		this.code = code;
	}
	public ResponseModel(Integer code, List<?> listData) {
		this.code = code;
		this.listData = listData;
	}
	public ResponseModel(Integer code, Object data) {
		this.code = code;
		this.data = data;
	}
	
}
