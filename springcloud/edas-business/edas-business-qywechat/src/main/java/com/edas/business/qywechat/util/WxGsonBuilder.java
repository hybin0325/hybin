package com.edas.business.qywechat.util;

import com.edas.business.qywechat.entity.WxError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WxGsonBuilder {

	private static final GsonBuilder INSTANCE = new GsonBuilder();

	static {
		INSTANCE.disableHtmlEscaping();
		INSTANCE.registerTypeAdapter(WxError.class, new WxErrorAdapter());
	}

	public static Gson create() {
		return INSTANCE.create();
	}

}
