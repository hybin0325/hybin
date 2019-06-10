package com.edas.job.admin.core.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class RolesDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3644751042785974572L;
	private int id;
	private String code;
	private String name;
	private String description;
	
	private List<Long> resourceIds;

}
