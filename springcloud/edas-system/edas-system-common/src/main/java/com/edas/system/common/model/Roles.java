package com.edas.system.common.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Roles implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4578984237295043569L;
	
	private Long id;
	private String code;
    private String name;
    private String description;

}
