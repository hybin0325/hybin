package com.edas.system.auth.entity.dto;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class PageTableRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7948286745048045398L;
	private Integer pageNo=1;
	private Integer pageSize=10;
	private Map<String, Object> params;


}
