package com.edas.job.admin.core.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ResourceDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9203156479121398739L;
	private Long Id;
	private String code;
	private String name;
	private String type;
	private String url;
	private String method;
	private String description;
	private Long parentId;
	private Integer level;

	private List<ResourceDTO> child;

}
