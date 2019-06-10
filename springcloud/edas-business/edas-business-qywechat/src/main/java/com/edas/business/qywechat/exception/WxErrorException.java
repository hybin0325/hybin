package com.edas.business.qywechat.exception;

import com.edas.business.qywechat.entity.WxError;

@SuppressWarnings("serial")
public class WxErrorException extends Exception {

	private WxError error;

	public WxErrorException(WxError error) {
		super(error.toString());
		this.error = error;
	}

	public WxErrorException(WxError error, Throwable cause) {
		super(error.toString(), cause);
		this.error = error;
	}

	public WxError getError() {
		return this.error;
	}

}
