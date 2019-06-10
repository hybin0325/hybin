package com.edas.edascommon.exception;

/**
 * Created by zhoutaoo on 2018/6/2.
 */
public class ServiceException extends BaseException {

	private static final long serialVersionUID = 1213855733833039552L;

	public ServiceException(String message, Throwable cause) {
		super(SystemErrorType.SYSTEM_ERROR, message, cause);
		// TODO Auto-generated constructor stub
	}

	// TODO 对业务异常的返回码进行校验，规范到一定范围内

}
