package com.edas.business.tripartite.enums;

/**
 * <p>
 * Description: 电话场景枚举
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public enum phoneSceneTypeEnum {
	
	/**
	 * 应用场景 1:呼入,2:呼出,3:呼入呼出
	 */
	CALLIN(1,"呼入"),
	
	CALLOUT(2,"呼出"),
	
	CALLINOUT(3,"呼入呼出");	
	
	private Integer code;
	
	private String msg;
	
	private phoneSceneTypeEnum(Integer code, String msg) {
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
