package com.edas.business.tripartite.enums;

/**
 * <p>
 * Description: 任务类型
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public enum TaskTypeEnum {

	/**
	 * '1-定时,2-手动'
	 */
	MANUAL(2,"手动"),

	TIMING(1,"定时");
	
	private Integer code;
	
	private String msg;
	
	private TaskTypeEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getCode() {
		return code;
	}
}