package net.medcrm.yjb.workflow.util.exception;

/**
 * 自定义异常
 */
public class BaseException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6073047130314629816L;
	private String code;//状态码

    public BaseException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
