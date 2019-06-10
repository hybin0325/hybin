package com.edas.system.common.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class CurrentUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6513186107678102096L;
	private String username;
	private String name;
	private Object authorities;
	
}
