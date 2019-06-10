package com.edas.job.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.edas.edascommon.model.Result;
import com.edas.job.admin.core.dto.QueryRes;
import com.edas.job.admin.core.model.XxlJobGroup;
import com.edas.job.admin.core.model.XxlJobUser;
import com.edas.job.admin.core.util.CookieUtil;
import com.edas.job.admin.core.util.I18nUtil;
import com.edas.job.admin.core.util.JacksonUtil;
import com.edas.job.admin.dao.XxlJobGroupDao;
import com.edas.job.admin.dao.XxlJobUserDao;
import com.edas.job.admin.fegin.AuthFeign;
import com.edas.job.admin.service.LoginService;
import com.edas.job.core.biz.model.ReturnT;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xuxueli 2019-05-04 16:39:50
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private XxlJobUserDao xxlJobUserDao;
	@Autowired
	private XxlJobGroupDao xxlJobGroupDao;

	@Autowired
	private AuthFeign authFeign;

	@RequestMapping
	public String index(Model model, HttpServletRequest request) {
		// 执行器列表
		List<XxlJobGroup> groupList = xxlJobGroupDao.findAll();
		model.addAttribute("groupList", groupList);
		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
		Result rest = authFeign.findRoles(CookieUtil.getHeader(loginUser.getUsername()));
		log.info("rest{} " + rest);
		model.addAttribute("roleList", rest.getData());
		return "user/user.index";
	}

	@RequestMapping("/pageList")
	@ResponseBody
	public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int start,
			@RequestParam(required = false, defaultValue = "10") int length, String username, int role,
			HttpServletRequest request) {

		// page list
		// List<XxlJobUser> list = xxlJobUserDao.pageList(start, length, username,
		// role);
		log.info("开始分页数 start{}  ===> ", start);
		log.info("开始分页码 length{}  ===> ", length);
		QueryRes res = new QueryRes();
		res.setPageNo(start / length + 1);
		res.setPageSize(length);
		Map<String, Object> params = Maps.newHashMap();
		params.put("username", username);
		res.setParams(params);
		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
		Result rest = authFeign.listUsers(CookieUtil.getHeader(loginUser.getUsername()), res);

		// int list_count = xxlJobUserDao.pageListCount(start, length, username, role);
		JSONObject jsono = JSONObject.parseObject(JSONObject.toJSON(rest.getData()).toString());
		int list_count = jsono.getInteger("total");
		String json_list = jsono.getJSONArray("list").toString();
		List<XxlJobUser> list = JacksonUtil.jsonToList(json_list, XxlJobUser.class);
		for (XxlJobUser xxlJobUser : list) {
			XxlJobUser xuser = xxlJobUserDao.loadByUserName(xxlJobUser.getUsername());
			if (xuser != null) {
				xxlJobUser.setPermission(xuser.getPermission());
			}
		}
		log.info("分页数据 list{}  ===> " + list);
		// package result
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("recordsTotal", list_count); // 总记录数
		maps.put("recordsFiltered", list_count); // 过滤后的总记录数
		maps.put("data", list); // 分页列表
		return maps;
	}

	@RequestMapping("/add")
	@ResponseBody
	public ReturnT<String> add(XxlJobUser xxlJobUser, String roles, HttpServletRequest request) {
		log.info("XxlJobUser{} ==> " + xxlJobUser);

		// valid username
		if (!StringUtils.hasText(xxlJobUser.getUsername())) {
			return new ReturnT<String>(ReturnT.FAIL_CODE,
					I18nUtil.getString("system_please_input") + I18nUtil.getString("user_username"));
		}
		xxlJobUser.setUsername(xxlJobUser.getUsername().trim());
		if (!(xxlJobUser.getUsername().length() >= 4 && xxlJobUser.getUsername().length() <= 20)) {
			return new ReturnT<String>(ReturnT.FAIL_CODE, I18nUtil.getString("system_lengh_limit") + "[4-20]");
		}
		// valid password
		if (!StringUtils.hasText(xxlJobUser.getPassword())) {
			return new ReturnT<String>(ReturnT.FAIL_CODE,
					I18nUtil.getString("system_please_input") + I18nUtil.getString("user_password"));
		}
		xxlJobUser.setPassword(xxlJobUser.getPassword().trim());
		if (!(xxlJobUser.getPassword().length() >= 4 && xxlJobUser.getPassword().length() <= 20)) {
			return new ReturnT<String>(ReturnT.FAIL_CODE, I18nUtil.getString("system_lengh_limit") + "[4-20]");
		}
		// md5 password
		// xxlJobUser.setPassword(DigestUtils.md5DigestAsHex(xxlJobUser.getPassword().getBytes()));

		// check repeat
		Result<XxlJobUser> restUser = authFeign.getUserName(xxlJobUser.getUsername());
		// XxlJobUser existUser =
		// xxlJobUserDao.loadByUserName(xxlJobUser.getUsername());
		XxlJobUser existUser = restUser.getData();
		if (existUser != null) {
			return new ReturnT<String>(ReturnT.FAIL_CODE, I18nUtil.getString("user_username_repeat"));
		}
		if (roles != null && !"".equals(roles)) {
			xxlJobUser.setRoleIds(JacksonUtil.stringToLongList(roles));
		}

		// write
		// xxlJobUserDao.save(xxlJobUser);
		log.info("XxlJobUser{} ==> " + xxlJobUser);
		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
		authFeign.saveUser(CookieUtil.getHeader(loginUser.getUsername()), xxlJobUser);
		xxlJobUserDao.save(xxlJobUser);
		return ReturnT.SUCCESS;
	}

	@RequestMapping("/update")
	@ResponseBody
	public ReturnT<String> update(HttpServletRequest request, XxlJobUser xxlJobUser, String roles) {

		// avoid opt login seft
		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
		if (loginUser.getUsername().equals(xxlJobUser.getUsername())) {
			return new ReturnT<String>(ReturnT.FAIL.getCode(), I18nUtil.getString("user_update_loginuser_limit"));
		}

		// valid password
		if (StringUtils.hasText(xxlJobUser.getPassword())) {
			xxlJobUser.setPassword(xxlJobUser.getPassword().trim());
			if (!(xxlJobUser.getPassword().length() >= 4 && xxlJobUser.getPassword().length() <= 20)) {
				return new ReturnT<String>(ReturnT.FAIL_CODE, I18nUtil.getString("system_lengh_limit") + "[4-20]");
			}
			// md5 password
			// xxlJobUser.setPassword(DigestUtils.md5DigestAsHex(xxlJobUser.getPassword().getBytes()));
		} else {
			xxlJobUser.setPassword(null);
		}

		// write
		if (roles != null && !"".equals(roles)) {
			xxlJobUser.setRoleIds(JacksonUtil.stringToLongList(roles));
		}
		authFeign.updateUser(CookieUtil.getHeader(loginUser.getUsername()), xxlJobUser);

		XxlJobUser xUser = xxlJobUserDao.loadByUserName(xxlJobUser.getUsername());
		if (xUser != null) {
			xUser.setPermission(xxlJobUser.getPermission());
			xxlJobUserDao.update(xUser);
		} else {
			xxlJobUserDao.save(xxlJobUser);
		}

		return ReturnT.SUCCESS;
	}

	@RequestMapping("/remove")
	@ResponseBody
	public ReturnT<String> remove(HttpServletRequest request, long id) {

		// avoid opt login seft
		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
		authFeign.delete(CookieUtil.getHeader(loginUser.getUsername()), id);
		// xxlJobUserDao.delete(id);
		return ReturnT.SUCCESS;
	}

	@RequestMapping("/updatePwd")
	@ResponseBody
	public ReturnT<String> updatePwd(HttpServletRequest request, String password) {

		// valid password
		if (password == null || password.trim().length() == 0) {
			return new ReturnT<String>(ReturnT.FAIL.getCode(), "密码不可为空");
		}
		password = password.trim();
		if (!(password.length() >= 4 && password.length() <= 20)) {
			return new ReturnT<String>(ReturnT.FAIL_CODE, I18nUtil.getString("system_lengh_limit") + "[4-20]");
		}

		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);

		// do write
		authFeign.changePassword(CookieUtil.getHeader(loginUser.getUsername()), loginUser.getUsername(),
				loginUser.getPassword(), password);
		return ReturnT.SUCCESS;
	}

}
