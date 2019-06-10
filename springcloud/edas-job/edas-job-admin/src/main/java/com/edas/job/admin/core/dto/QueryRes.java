package com.edas.job.admin.core.dto;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

/**
 *  查询
 * @author nl
 *
 */
@Data
public class QueryRes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pageNo=1;
	private Integer pageSize=10;
	private Map<String, Object> params;
	
	
}
