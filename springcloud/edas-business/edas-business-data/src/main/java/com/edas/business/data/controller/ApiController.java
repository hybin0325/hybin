package com.edas.business.data.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;
import com.edas.system.common.model.LoginUsers;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
//@Api(value = "/api",tags = "token开放")
public class ApiController {

	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public RetResult<LoginUsers> authDemo(OAuth2Authentication auth) {
		// 获取当前用户资源
		LoginUsers user = (LoginUsers) auth.getPrincipal();
		return RetResponse.makeOKRsp(user);
	}
	



}
