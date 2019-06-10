package com.edas.system.common.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.edas.system.common.constants.ResultEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
public class ResultBody<T> implements Serializable {
	private static final long serialVersionUID = -6190689122701100762L;

	/**
	 * 消息码
	 */
	private String code = "0";
	
	/**
	 * 返回消息
	 */
	private String msg;


	/**
	 * 返回数据
	 */
	private T data;

	/**
	 * http状态码
	 */
	private int httpStatus;

	

	/**
	 * 服务器时间
	 */
	private long timestamp = System.currentTimeMillis();

	public ResultBody() {
		super();
	}

	public static <T> ResultBody success() {
		return new ResultBody().setMsg("success");
	}

	public static <T> ResultBody success(T data) {
		return new ResultBody().setData(data).setMsg("success");
	}

	public static <T> ResultBody success(String msg, T result) {
		return new ResultBody().setMsg(msg).setData(result);
	}

	public static ResultBody failed(String msg) {
		return new ResultBody().setCode(ResultEnum.FAIL.getCode()+"").setMsg(msg);
	}

	public static ResultBody failed() {
		return new ResultBody().setCode(ResultEnum.FAIL.getCode()+"").setMsg(ResultEnum.FAIL.getMsg());
	}

	public static ResultBody error() {
		return new ResultBody().setCode(ResultEnum.ERROR.getCode()+"").setMsg(ResultEnum.ERROR.getMsg());
	}

	public static ResultBody failed(String code, String msg) {
		return new ResultBody().setCode(code).setMsg(msg);
	}
	public static ResultBody failed(String code, String msg,int httpStatus) {
		return new ResultBody().setCode(code).setMsg(msg).setHttpStatus(httpStatus);
	}

	public static ResultBody failed(ResultEnum code, String msg) {
		return failed(code.getCode()+"", msg);
	}

	public String getCode() {
		return code;
	}

	public ResultBody setCode(String code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ResultBody setMsg(String message) {
		this.msg = message;
		return this;
	}

	public T getData() {
		return data;
	}

	public ResultBody setData(T data) {
		this.data = data;
		return this;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public ResultBody setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	@JSONField(serialize = false, deserialize = false)
	@JsonIgnore
	public int getHttpStatus() {
		return httpStatus;
	}

	public ResultBody setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
		return this;
	}

	@Override
	public String toString() {
		return "ResultBody{" + "code=" + code +  ", msg='" + msg + '\'' 
				+ '\'' + ", data=" + data + ", httpStatus=" + httpStatus + ", timestamp="
				+ timestamp + '}';
	}
}
