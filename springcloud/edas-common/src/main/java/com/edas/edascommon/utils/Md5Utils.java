package com.edas.edascommon.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class Md5Utils {

	/**
	 * 生成签名
	 * 
	 * @param map
	 * @return
	 */
	public static String getSignToken(Map<String, String> map) {
		String result = "";
		try {
			List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(map.entrySet());
			// 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
			Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {

				public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
					return (o1.getKey()).toString().compareTo(o2.getKey());
				}
			});
			// 构造签名键值对的格式
			StringBuilder sb = new StringBuilder();
			for (Map.Entry<String, String> item : infoIds) {
				if (item.getKey() != null || item.getKey() != "") {
					String key = item.getKey();
					String val = item.getValue();
					if (!(val == "" || val == null)) {
						sb.append(key + "=" + val + "&");
					}
				}
			}
			result = sb.toString();
			result= result.substring(0, result.lastIndexOf("&"));
			System.out.println("排序后： "+result);
			// 进行MD5加密
			result = getMD5Value(result);
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	
	
	/**
	 * Description:MD5工具生成token
	 * @param value
	 * @return
	 */
	public static String getMD5Value(String value){
	    try {
	        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
	        byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
	        BigInteger bigInteger = new BigInteger(1 , md5ValueByteArray);
	        return bigInteger.toString(16).toLowerCase();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public static void main(String[] args) {
		String url="accessKeyID=7YHFNIl08cA3DNyJ&accessKeySecret=9StX0WsHRJFUUXBiu5BFTeGTqalVzEPP&commKey=1bMyAkLSOAEC1Yfu&data=%7B%22page%22%3A1%2C%22size%22%3A15%7D&timestamp=1554254400&version=2016-01-08&";
		System.out.println(url.substring(0,url.lastIndexOf("&")) );
	}
	
	

}
