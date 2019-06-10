package com.edas.business.dingtalk.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@ToString
public class ResBodyParmData implements Serializable {
	private static final long serialVersionUID = 1L;

	private String dld;
	private String license;
	private String users;
	private String tiaozhuan_url;
	private String title;
	private String content;
	private String file_url;
	private String pic_url;

	
}