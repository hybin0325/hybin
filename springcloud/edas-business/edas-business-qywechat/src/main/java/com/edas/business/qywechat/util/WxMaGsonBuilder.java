package com.edas.business.qywechat.util;

import com.edas.business.qywechat.entity.template.WxMaTemplateMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WxMaGsonBuilder {
	
	private static final GsonBuilder INSTANCE = new GsonBuilder();

	  static {
	    INSTANCE.disableHtmlEscaping();
	    INSTANCE.registerTypeAdapter(WxMaTemplateMessage.class, new WxMaTemplateMessageGsonAdapter());
	  }

	  public static Gson create() {
	    return INSTANCE.create();
	  }
}
