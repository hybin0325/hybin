package com.edas.edascommon.utils;

import java.util.HashMap;
import java.util.Map;

public class UrlUtils {

	/**
	 * 
	 * @param url
	 * @param method
	 * @param parameter 参数
	 * @return
	 */
	public static String getRqstUrl(String url, String method, Map<String, String> params) {
		
		
		StringBuilder builder = new StringBuilder(url.trim());
		builder.append(method.trim());
		boolean isFirst = true;
		for (String key : params.keySet()) {
			if (key != null && params.get(key) != null) {
				if (isFirst) {
					isFirst = false;
					builder.append("?");
				} else {
					builder.append("&");
				}
				builder.append(key).append("=").append(params.get(key));
			}
		}
		return builder.toString();
	}
	public static void main(String[] args) {
		String url="https://openapi.deliyun.cn/parking";
		String method="/findParkOutLog";
		Map<String, String> params=new HashMap<>();
		params.put("accessKeyID", "7YHFNIl08cA3DNyJ");
		params.put("commKey", "1bMyAkLSOAEC1Yfu");
		System.out.println(getRqstUrl(url,method,params));
	}

}
