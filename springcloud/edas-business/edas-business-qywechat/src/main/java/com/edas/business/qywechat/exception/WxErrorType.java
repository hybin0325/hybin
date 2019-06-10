package com.edas.business.qywechat.exception;

import com.edas.edascommon.exception.ErrorType;

import lombok.Getter;

@Getter
public enum WxErrorType implements ErrorType {
	
	SYSTEM_ERROR("-1", "系统异常"),
    
	WX_ERROR("WX0001", "微信服务端异常，超出重试次数");
	
    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String msg;

    WxErrorType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
