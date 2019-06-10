package com.edas.edascommon.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 业务数据
 * @author nl
 *
 */
@Data
public class MQDataMsg implements Serializable{
	private String message;

	private Integer messtempId;
	private String dld;
	private String type;
	private String messtempType;
	private String messtempTypeMessage;
	private String temType;
	private String temName;
	private String license;
	private String frame;
	private String cusNum;
	private String memLevel;
	private String tiaozhuanUrl;

}
