package com.edas.edasmessage.entity.rsp;

import java.io.Serializable;
import java.util.List;

import lombok.Data;



@Data
public class RespResult<T> implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int code;

    private String msg;

    private List<T> data;

}
