package com.edas.edasmessage.entity.rsp;

import java.io.Serializable;

import lombok.Data;

@Data
public class RespResultObj<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int ecode;

    private String msg;

    private T data;
}
