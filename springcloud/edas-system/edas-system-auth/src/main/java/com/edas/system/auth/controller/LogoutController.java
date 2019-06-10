package com.edas.system.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edas.edascommon.exception.SystemErrorType;
import com.edas.edascommon.model.Result;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LogoutController {

	@Autowired
	private TokenStore tokenStore;

	@RequestMapping(value = "/oauth/revoke-token", method = RequestMethod.GET)
	public Result logout2(HttpServletRequest request) {
		
		String authHeader = request.getHeader("Authorization");
		try {
			if (authHeader != null) {
				String tokenValue = authHeader.replace("Bearer", "").trim();
				OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
				tokenStore.removeAccessToken(accessToken);
			}
		} catch (Exception e) {
			return Result.fail(SystemErrorType.INVALID_TOKEN);
		}

		return Result.success();

	}

}
