package com.edas.business.qywechat.exception;


import com.edas.edascommon.exception.ErrorType;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class WxException extends RuntimeException {
    
	/**
     * 异常对应的错误类型
     */
    private final ErrorType errorType;

    /**
     * 默认是系统异常
     */
    public WxException() {
        this.errorType = WxErrorType.SYSTEM_ERROR;
    }

    public WxException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public WxException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public WxException(ErrorType errorType, String message, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
    }
    
   
}
