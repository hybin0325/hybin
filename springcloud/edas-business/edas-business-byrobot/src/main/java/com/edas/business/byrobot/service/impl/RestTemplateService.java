package com.edas.business.byrobot.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>
 * File Name: RestTemplateService.java
 * </p>
 * <p>
 * Description: RestTemplateService
 * </p>
 * <p>
 * Date：2019年5月7日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Service
public class RestTemplateService {
	@Autowired
	private RestTemplate restTemplate;
	
	/**
     * 
     * @Description http get
     *
     * @param url
	 * @param parmsMap
	 * @param headersMap
	 * @return JSONObject
     *
     * @date 2019年5月8日
     * @author zzw
     */
	public JSONObject getGetForEntity(String url, Map<String, Object> parmsMap, Map<String, Object> headersMap) {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		for (String key : headersMap.keySet()) {
			if (key != null && headersMap.get(key) != null) {
				headers.add(key, headersMap.get(key).toString());				
			}
		}		
		HttpEntity<Map<String, Object>> formEntity = new HttpEntity<Map<String, Object>>(parmsMap, headers);			  
		JSONObject json = restTemplate.exchange(url, HttpMethod.GET, formEntity,JSONObject.class).getBody();			
		return json;
	}
	
	/**
     * 
     * @Description http post
     *
     * @param url
	 * @param data
	 * @param headersMap
	 * @return JSONObject
     *
     * @date 2019年5月8日
     * @author zzw
     */
	public JSONObject getPostForEntity(String url, String data, Map<String, Object> headersMap) {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		for (String key : headersMap.keySet()) {
			if (key != null && headersMap.get(key) != null) {
				headers.add(key, headersMap.get(key).toString());				
			}
		}		
		HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);		
		JSONObject json = restTemplate.postForEntity(url, formEntity, JSONObject.class).getBody();			
		return json;		
	}
}
