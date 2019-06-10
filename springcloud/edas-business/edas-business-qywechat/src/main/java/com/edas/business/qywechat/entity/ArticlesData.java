package com.edas.business.qywechat.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
public class ArticlesData implements Serializable {
	private static final long serialVersionUID = 1L;

	private String title;
	private String description;
	private String url;
	private String picurl;
	
}