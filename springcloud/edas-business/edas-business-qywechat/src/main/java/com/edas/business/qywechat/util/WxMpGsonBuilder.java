package com.edas.business.qywechat.util;

import com.edas.business.qywechat.entity.template.WxMpTemplateIndustry;
import com.edas.business.qywechat.entity.template.WxMpTemplateMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WxMpGsonBuilder {

  private static final GsonBuilder INSTANCE = new GsonBuilder();

  static {
	  INSTANCE.registerTypeAdapter(WxMpTemplateIndustry.class, new WxMpIndustryGsonAdapter());
	  INSTANCE.registerTypeAdapter(WxMpTemplateMessage.class, new WxMpTemplateMessageGsonAdapter());
  }

  public static Gson create() {
    return INSTANCE.create();
  }

}
