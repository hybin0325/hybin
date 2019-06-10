package com.edas.business.qywechat.entity.template;

import lombok.Data;

@Data
public class WxMaTemplateData {

	private String name;
	private String value;
	private String color;
	
	public WxMaTemplateData() {
	}
	
	public WxMaTemplateData(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public WxMaTemplateData(String name, String value, String color) {
		this.name = name;
		this.value = value;
		this.color = color;
	}
}
