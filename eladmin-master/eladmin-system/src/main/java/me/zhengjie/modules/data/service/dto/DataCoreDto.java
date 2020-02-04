package me.zhengjie.modules.data.service.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DataCoreDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4212970599965210335L;

	private String id;
	
	private String proName;
	
	private String createTime;

}
