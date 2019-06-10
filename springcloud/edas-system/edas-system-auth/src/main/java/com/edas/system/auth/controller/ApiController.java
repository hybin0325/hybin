package com.edas.system.auth.controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.edas.edascommon.exception.SystemErrorType;
import com.edas.edascommon.model.Result;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;
import com.edas.system.auth.service.IUserService;
import com.edas.system.common.model.LoginUsers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(value="权限放行controller")
@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
	   
    @Autowired
	private IUserService userService;
	/**
	 * 定义用户信息
	 *
	 * @param authentication
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Result getUser(OAuth2Authentication authentication) {
		log.info("----------------------------");
		Authentication oauth = authentication.getUserAuthentication();
		LoginUsers user = (LoginUsers) oauth.getPrincipal();
		return Result.success(user);
	}

	@RequestMapping(value = "/user2", method = RequestMethod.GET)
	public Result getUser2(Authentication oauth) {
		log.info("----------------------------" + oauth);
		LoginUsers user = (LoginUsers) oauth.getPrincipal();
		return Result.success(user);
	}
	
	@GetMapping("/user3")
	public Principal getUser(Principal user) {
		return user;
	}

	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public Result authDemo(OAuth2Authentication auth) {
		// 获取当前用户资源
		LoginUsers user = (LoginUsers) auth.getPrincipal();
		return Result.success(user);
	}

	

	@GetMapping("/me")
	public Result getCurrentUser(Authentication user, HttpServletRequest request) throws UnsupportedEncodingException {

		String s = user.getPrincipal().toString();
		String name = user.getName();
		String header = request.getHeader("Authorization");
		String token = StringUtils.substringAfter(header, "bearer ");
		Claims body = Jwts.parser().setSigningKey("123456".getBytes("UTF-8")).parseClaimsJws(token).getBody();

		String username = (String) body.get("username");
		log.info("解析token获取到的username为{}", username);
		log.info("从Authentication里获取到的username为{}", s);
		log.info("从Authentication里获取到的username为{}", name);
		return Result.success(user);
	}
	
	@Resource
	private ConsumerTokenServices consumerTokenServices;

	@GetMapping("user/logout")
	public Result logout(@RequestParam("token") String accessToken) {
		log.info("accessToken:{} " + accessToken);
		boolean isRemoved = consumerTokenServices.revokeToken(accessToken);
		if (isRemoved) {
			Result.success(isRemoved);
		}
		return Result.fail(SystemErrorType.INVALID_TOKEN);
	}
	
	@ApiOperation(value = "根据用户username获取用户")
	@GetMapping("/{username}")
	public Result getUserName(@PathVariable String username) {
		return Result.success(userService.getByUsername(username));
	}
}
