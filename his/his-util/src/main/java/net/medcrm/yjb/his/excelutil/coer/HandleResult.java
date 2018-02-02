package net.medcrm.yjb.his.excelutil.coer;

import java.io.Serializable;

public class HandleResult implements Serializable {
	private static final long serialVersionUID = 5951230455429081400L;
	private String code;
	private String message;

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
