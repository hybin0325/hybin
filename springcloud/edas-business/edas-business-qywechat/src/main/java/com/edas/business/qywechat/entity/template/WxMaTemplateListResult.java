package com.edas.business.qywechat.entity.template;

import java.io.Serializable;
import java.util.List;

import com.edas.business.qywechat.util.WxGsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@SuppressWarnings("serial")
@Data
public class WxMaTemplateListResult implements Serializable {
	private List<TemplateInfo> list;

	public static WxMaTemplateListResult fromJson(String json) {
		return WxGsonBuilder.create().fromJson(json, WxMaTemplateListResult.class);
	}

	@Data
	public static class TemplateInfo {

		@SerializedName("template_id")
		private String templateId;
		private String title;
		private String content;
		private String example;
	}
}
