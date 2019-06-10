package com.edas.system.common.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthUtils {

	static final String SECRET = "123456"; // JWT密码
	static final String TOKEN_PREFIX = "Bearer"; // Token前缀
	static final String HEADER_STRING = "Authorization";// 存放Token的Header Key

	public static Map<String,Object> getReqUser(HttpServletRequest req) {
		String header = req.getHeader(HEADER_STRING);
		log.info("header--------------------------------------" + header);
		String token = StringUtils.substringAfter(header, TOKEN_PREFIX);
		log.info("token--------------------------------------" + token);
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(SECRET.getBytes("UTF-8")).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}
		String localUser = (String) claims.get("username");
		log.info("localUser--------------------------------------" + localUser);
		String name = (String) claims.get("name");
		String email = (String) claims.get("email");
		Map<String,Object> map=new HashMap<>();
		map.put("username", localUser);
		map.put("name", name);
		map.put("email", email);
		map.put("authorities", claims.get("authorities"));
		
		// 拿到当前用户
		return map;
	}

	
}
