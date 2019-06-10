package com.edas.business.tripartite.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

/**
 * <p>
 * Description: 百应工具类
 * </p>
 * <p>
 * Date：2019年5月7日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("restriction")
public class ByUtils {

	public static String toGMTString(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.UK);
		df.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
		return df.format(date);
	}

	public static String generateSign(String date, String appKey, String appSecret) {
		String stringToSign = appKey + "\n" + date;
		return HMACSha1(stringToSign, appSecret);
	}


	public static String HMACSha1(String data, String key) {
		String result;
		try {
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);
			byte[] rawHmac = mac.doFinal(data.getBytes());
			result = (new BASE64Encoder()).encode(rawHmac);
		} catch (Exception e) {
			throw new Error("Failed to generate HMAC : " + e.getMessage());
		}
		return result;
	}
	
	public static Map<String, Object> getHeaders(String appKey, String appSecret) {
		Map<String, Object> headersMap = new HashMap<String, Object>();
		String date = toGMTString(new Date());
        String sign = generateSign(date, appKey, appSecret);             
        headersMap.put("datetime", date);
        headersMap.put("appkey", appKey);
        headersMap.put("sign", sign);
		return headersMap;
	}
	
	public static String base64Encode(byte[] data) {		
		return (new BASE64Encoder()).encode(data);
	}
	
	public static byte[] base64Dcode(String data) {		
		byte[] decodeBuffer = null;
		try {
			decodeBuffer = (new BASE64Decoder()).decodeBuffer(data);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return decodeBuffer;
	}
}
