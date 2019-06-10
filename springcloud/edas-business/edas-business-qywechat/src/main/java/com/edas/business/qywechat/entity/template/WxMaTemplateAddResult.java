package com.edas.business.qywechat.entity.template;

import java.io.Serializable;
import com.edas.business.qywechat.util.WxGsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@SuppressWarnings("serial")
@Data
public class WxMaTemplateAddResult implements Serializable {
	@SerializedName("template_id")
	private String templateId;

	public static WxMaTemplateAddResult fromJson(String json) {
		return WxGsonBuilder.create().fromJson(json, WxMaTemplateAddResult.class);
	}
}