package com.edas.edascommon.exception;

import lombok.Getter;

@Getter
public enum SystemErrorType implements ErrorType {

    SYSTEM_ERROR("-1", "系统异常"),
    SYSTEM_BUSY("000001", "系统繁忙,请稍候再试"),

    GATEWAY_NOT_FOUND_SERVICE("010404", "服务未找到"),
    GATEWAY_ERROR("010500", "网关异常"),
    GATEWAY_CONNECT_TIME_OUT("010002", "网关超时"),
    
    BAD_REQUEST("400", "请求出错"),
    FORBIDDEN("403", "没有访问权限"),
    UNAUTHORIZED("401","未认证（签名错误）"),
    UN_AUTHORIZED("402","权限不足，无法访问该资源"),

    ARGUMENT_NOT_VALID("020000", "请求参数校验不通过"),
    UPLOAD_FILE_SIZE_LIMIT("020001", "上传文件大小超过限制"),
    INVALID_REQUEST("040001", "无效请求"),
    INVALID_CLIENT("040002", "无效client_id"),
    INVALID_GRANT("040003", "无效授权"),
    INVALID_SCOPE("040004", "无效scope"),
    INVALID_TOKEN("040005", "无效token"),
    INSUFFICIENT_SCOPE("040010", "授权不足"),
    REDIRECT_URI_MISMATCH("040020", "redirect url不匹配"),
    ACCESS_DENIED("040030", "拒绝访问"),
    METHOD_NOT_ALLOWED("040040", "不支持该方法"),
    SERVER_ERROR("040050", "权限服务错误"),
    UNAUTHORIZED_CLIENT("040060", "未授权客户端"),
    UNSUPPORTED_RESPONSE_TYPE("040070", " 支持的响应类型"),
    UNSUPPORTED_GRANT_TYPE("040071", "不支持的授权类型");;
	
	
	
	

    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String msg;

    SystemErrorType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
