package me.zhengjie.modules.system.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class GroupDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 824879438645104458L;

	private Long id;

	private String groupName;

	private Timestamp createTime;
	
	private int status;
}
