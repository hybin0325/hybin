package com.edas.system.auth.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.edas.edascommon.model.Result;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginController {

	@Value("${edas.common.clientId}")
	private String clientId;

	@Value("${edas.common.clientSecret}")
	private String clientSecret;

	@Value("${edas.common.accessTokenUri}")
	private String accessTokenUri;

	@Autowired
	private RestTemplate openRestTemplate;

	

	/**
	 * 获取用户访问令牌 基于oauth2密码模式登录
	 *
	 * @param username
	 * @param password
	 * @return access_token
	 */
	@ApiOperation(value = "获取用户访问令牌", notes = "基于oauth2密码模式登录,无需签名,返回access_token")
	@ApiImplicitParams({ @ApiImplicitParam(name = "username", required = true, value = "登录名", paramType = "form"),
			@ApiImplicitParam(name = "password", required = true, value = "登录密码", paramType = "form") })
	@PostMapping("/oauth/login")
	public Object getLoginToken(@RequestParam String username, @RequestParam String password,
			@RequestHeader HttpHeaders headers) {
		log.info("username:" + username);
		// 使用oauth2密码模式登录.
		MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
		postParameters.add("username", username);
		postParameters.add("password", password);
		// postParameters.add("client_id", "test_client");
		// postParameters.add("client_secret", "test_secret");
		postParameters.add("client_id", clientId);
		postParameters.add("client_secret", clientSecret);
		postParameters.add("grant_type", "password");
		// 使用客户端的请求头,发起请求
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// 强制移除 原来的请求头,防止token失效
		headers.remove(HttpHeaders.AUTHORIZATION);
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity(postParameters, headers);
		// Map result =
		// openRestTemplate.postForObject("http://127.0.0.1:19012/oauth/token", request,
		// Map.class);
		Map result = openRestTemplate.postForObject(accessTokenUri, request, Map.class);
		if (result.containsKey("access_token")) {
			return Result.success(result);
		} else {
			log.info("result:" + result);
			return result;
		}
	}


}
