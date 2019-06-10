package com.edas.edasmessage.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edas.edasmessage.entity.CarParkLog;
import com.edas.edasmessage.entity.User;
import com.edas.edasmessage.entity.rsp.RespResult;
import com.edas.edasmessage.entity.rsp.RespResultObj;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RestTemplateService {
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * POST 请求
	 * 
	 * @param url
	 * @param data
	 * @param clazz
	 * @return
	 */
	public List<CarParkLog> getPostCarParkLog(String url, String data) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded");
		HttpEntity<String> formEntity = new HttpEntity<>(data, headers);
		ResponseEntity<RespResult<CarParkLog>> responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, formEntity,
				new ParameterizedTypeReference<RespResult<CarParkLog>>() {
				});
		RespResult<CarParkLog> respResult = responseEntity.getBody();
		return respResult.getData();
	}

	/**
	 * 返回集合
	 * 
	 * @param url
	 * @param data
	 * @param clazz
	 * @return
	 */
	public <T> List<T> getPostForEntity(String url, String data, Class<T> clazz) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded");
		HttpEntity<String> formEntity = new HttpEntity<>(data, headers);
		JSONObject json = restTemplate.postForEntity(url, formEntity, JSONObject.class).getBody();

		log.info("rdata:  " + json.get("data"));
		List<T> ts = (List<T>) JSONArray.parseArray(JSON.toJSONString(json.get("data")), clazz);
		return ts;
	}
	
	/**
	 * 返回对象
	 * @param url
	 * @param data
	 * @param clazz
	 * @return
	 */
	public <T> T getPostForEntityObj(String url, String data, Class<T> clazz) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded");
		HttpEntity<String> formEntity = new HttpEntity<>(data, headers);
		JSONObject json = restTemplate.postForEntity(url, formEntity, JSONObject.class).getBody();

		String rdata = json.get("data").toString();
		log.info("rdata:  " + rdata);
		return  com.edas.edasmessage.utils.StringUtils.stringToBean(JSON.toJSONString(json.get("data")), clazz);
	}

	public User getUser(String url, Map<String, Object> parmsMap) {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		HttpEntity<Map<String, Object>> formEntity = new HttpEntity<Map<String, Object>>(parmsMap, headers);
		ParameterizedTypeReference<RespResultObj<User>> typeRef = new ParameterizedTypeReference<RespResultObj<User>>() {
		};
		ResponseEntity<RespResultObj<User>> responseEntity = restTemplate.exchange(url, HttpMethod.POST, formEntity,
				typeRef);
		log.info("myModelClasses :" + responseEntity.getBody());
		RespResultObj<User> myModelClasses = responseEntity.getBody();

		return myModelClasses.getData();
	}

	public <E> E methodPost(String url, Map<String, Object> parmsMap, Class<E> clazz) {

		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		HttpEntity<Map<String, Object>> formEntity = new HttpEntity<Map<String, Object>>(parmsMap, headers);

		ParameterizedTypeReference<RespResultObj<E>> typeRef = new ParameterizedTypeReference<RespResultObj<E>>() {
		};

		ResponseEntity<RespResultObj<E>> responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, formEntity,
				typeRef);
		RespResultObj<E> respResult = responseEntity.getBody();

		log.info("respResult: " + respResult);
		return (E) respResult.getData();
	}

}
