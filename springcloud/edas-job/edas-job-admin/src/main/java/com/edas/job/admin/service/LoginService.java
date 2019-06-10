package com.edas.job.admin.service;

import java.math.BigInteger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.edas.edascommon.model.Result;
import com.edas.job.admin.core.model.XxlJobUser;
import com.edas.job.admin.core.util.CookieUtil;
import com.edas.job.admin.core.util.I18nUtil;
import com.edas.job.admin.core.util.JacksonUtil;
import com.edas.job.admin.dao.XxlJobUserDao;
import com.edas.job.admin.fegin.AuthFeign;
import com.edas.job.core.biz.model.ReturnT;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xuxueli 2019-05-04 22:13:264
 */
@Slf4j
//@Configuration
@Service
public class LoginService {

	public static final String LOGIN_IDENTITY_KEY = "XXL_JOB_LOGIN_IDENTITY";

	@Resource
	private XxlJobUserDao xxlJobUserDao;

	@Autowired
	private AuthFeign authFeign;

	private String makeToken(XxlJobUser xxlJobUser) {
		String tokenJson = JacksonUtil.writeValueAsString(xxlJobUser);
		String tokenHex = new BigInteger(tokenJson.getBytes()).toString(16);
		return tokenHex;
	}

	private XxlJobUser parseToken(String tokenHex) {
		XxlJobUser xxlJobUser = null;
		if (tokenHex != null) {
			String tokenJson = new String(new BigInteger(tokenHex, 16).toByteArray()); // username_password(md5)
			xxlJobUser = JacksonUtil.readValue(tokenJson, XxlJobUser.class);
		}
		return xxlJobUser;
	}

	public ReturnT<String> login(HttpServletRequest request, HttpServletResponse response, String username,
			String password, boolean ifRemember) {

		// param
		if (username == null || username.trim().length() == 0 || password == null || password.trim().length() == 0) {
			return new ReturnT<String>(500, I18nUtil.getString("login_param_empty"));
		}

		// valid passowrd
//		XxlJobUser xxlJobUser = xxlJobUserDao.loadByUserName(username);
//		if (xxlJobUser == null) {
//			return new ReturnT<String>(500, I18nUtil.getString("login_param_unvalid"));
//		}
//		String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
//		if (!passwordMd5.equals(xxlJobUser.getPassword())) {
//			return new ReturnT<String>(500, I18nUtil.getString("login_param_unvalid"));
//		}
//		

		Result rest = authFeign.userLogin(username, password);
		log.info("Result{} " + rest);
		if (rest == null || rest.getData() == null) {
			return new ReturnT<String>(500, I18nUtil.getString("login_param_unvalid"));
		}
		JSONObject jsono = JSONObject.parseObject(JSONObject.toJSON(rest.getData()).toString());
		log.info("JSONObject{} " + jsono);
		String accessToken = jsono.getString("access_token");
		log.info("loginToken{} " + accessToken);
		Result<XxlJobUser> restUser = authFeign.getUserName(username);
		XxlJobUser xxlJobUser = restUser.getData();
		xxlJobUser.setRole(1);
		// xxlJobUser.setAccessToken(accessToken);
		String loginToken = makeToken(xxlJobUser);
		CookieUtil.USERTOKEN.put(username, accessToken);
		// do login
		CookieUtil.set(response, LOGIN_IDENTITY_KEY, loginToken, ifRemember);
		return ReturnT.SUCCESS;
	}

	/**
	 * logout
	 *
	 * @param request
	 * @param response
	 */
	public ReturnT<String> logout(HttpServletRequest request, HttpServletResponse response) {
		CookieUtil.remove(request, response, LOGIN_IDENTITY_KEY);
		return ReturnT.SUCCESS;
	}

	public ReturnT<String> logout2(HttpServletRequest request, HttpServletResponse response) {
		String cookieToken = CookieUtil.remove2(request, response, LOGIN_IDENTITY_KEY);
		XxlJobUser cookieUser = null;
		try {
			cookieUser = parseToken(cookieToken);
		} catch (Exception e) {
			logout(request, response);
		}
		authFeign.removeToken(CookieUtil.getHeader(cookieUser.getUsername()));
		CookieUtil.USERTOKEN.remove(cookieUser.getUsername());
		return ReturnT.SUCCESS;
	}
	
	

	/**
	 * logout
	 *
	 * @param request
	 * @return
	 */
	public XxlJobUser ifLogin(HttpServletRequest request, HttpServletResponse response) {
		String cookieToken = CookieUtil.getValue(request, LOGIN_IDENTITY_KEY);
		if (cookieToken != null) {
			XxlJobUser cookieUser = null;
			try {
				cookieUser = parseToken(cookieToken);
			} catch (Exception e) {
				logout(request, response);
			}
			if (cookieUser != null) {
				// XxlJobUser dbUser = xxlJobUserDao.loadByUserName(cookieUser.getUsername());
				String username = cookieUser.getUsername();
				Result<XxlJobUser> rest = authFeign.getUserName(username);
				XxlJobUser dbUser = rest.getData();
				if (dbUser != null) {
					if (cookieUser.getPassword().equals(dbUser.getPassword())) {
						dbUser.setRole(1);
						return dbUser;
					}
				}
			}
		}
		return null;
	}

}
