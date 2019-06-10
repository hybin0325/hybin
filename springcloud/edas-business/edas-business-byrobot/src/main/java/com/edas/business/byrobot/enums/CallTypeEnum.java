package com.edas.business.byrobot.enums;

/**
 * <p>
 * File Name: CallTypeEnum.java
 * </p>
 * <p>
 * Description: 呼叫类型
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public enum CallTypeEnum {

	/**
	 * 主叫号码类型，0-sim卡,1-固话（默认）, 2-无主叫
	 */
	SIM(0,"sim卡"),
	
	TELEPHONE(1,"固话"),
	
	CALLING(2,"无主叫");
	
	private Integer code;
	
	private String msg;
	
	private CallTypeEnum(Integer code, String msg) {
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