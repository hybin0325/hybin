package com.edas.business.tripartite.enums;

/**
 * <p>
 * Description: 任务状态
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public enum TaskStatusEnum {

	/**
	 * 任务状态, 0:未开始,1:进行中,2:已完成,3:调度中,4:手动暂停,5:自动暂停,6:已终止,7:排队中,8:AI到期,9:账户欠费,10:短信欠费
	 */
	NOT_BEGUN(0,"未开始"),
	
	IN_PROGRESS(1,"进行中"),
	
	COMPLETE(2,"已完成"),
	
	DISPATCH(3,"调度中"),
	
	MANUAL_PAUSE(4,"手动暂停"),
	
	AUTOMATIC_PAUSE(5,"自动暂停"),
	
	TERMINATION(6,"已终止"),
	
	QUEUING(7,"排队中"),
	
	AI_EXPIRE(8,"AI到期"),
	
	ACCOUNT_ARREARS(9,"账户欠费"),
	
	SMS_ARREARS(10,"短信欠费");
	
	private Integer code;
	
	private String msg;
	
	private TaskStatusEnum(Integer code, String msg) {
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