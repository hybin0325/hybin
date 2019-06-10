package com.edas.business.byrobot.enums;

/**
 * <p>
 * File Name: phoneTypeEnum.java
 * </p>
 * <p>
 * Description: 电话类型枚举
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public enum phoneTypeEnum {

	/**
	 * 主叫号码类型：手机(0, "手机"),阿里云固话(1, "阿里云固话"),无主叫固话(2, "无主叫固话"),sip线路(6,"sip线路")
	 */
	PHONE(0,"手机"),
	
	ALI_TELEPHONE(1,"阿里云固话"),
	
	TELEPHONE(2,"无主叫固话"),

	SIP(6,"sip线路");
	
	private Integer code;
	
	private String msg;
	
	private phoneTypeEnum(Integer code, String msg) {
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