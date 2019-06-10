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
import com.edas.job.admin.core.dto.ResourceDTO;
import com.edas.job.admin.core.model.XxlJobGroup;
import com.edas.job.admin.core.model.XxlJobUser;
import com.edas.job.admin.core.util.CookieUtil;
import com.edas.job.admin.core.util.I18nUtil;
import com.edas.job.admin.core.util.JacksonUtil;
import com.edas.job.admin.dao.XxlJobGroupDao;
import com.edas.job.admin.fegin.AuthFeign;
import com.edas.job.admin.service.LoginService;
import com.edas.job.core.biz.model.ReturnT;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/resource")
public class ResourceController {
	@Autowired
	private XxlJobGroupDao xxlJobGroupDao;

	@Autowired
	private AuthFeign authFeign;

	@RequestMapping
	public String index(Model model,HttpServletRequest request) {
		// 执行器列表
		List<XxlJobGroup> groupList = xxlJobGroupDao.findAll();
		model.addAttribute("groupList", groupList);
		
		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
		Result rest= authFeign.findParentResources(CookieUtil.getHeader(loginUser.getUsername()));
		log.info("Result:{}  ===> ", rest.getData());
		model.addAttribute("menuList", rest.getData());
		return "resource/resource.index";
	}

	@RequestMapping("/pageList")
	@ResponseBody
	public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int start,
			@RequestParam(required = false, defaultValue = "10") int length, String name, HttpServletRequest request) {

		log.info("开始分页数 start{}  ===> ", start);
		log.info("开始分页码 length{}  ===> ", length);
		QueryRes res = new QueryRes();
		res.setPageNo(start / length + 1);
		res.setPageSize(length);
		Map<String, Object> params = Maps.newHashMap();
		params.put("name", name);
		res.setParams(params);
		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
		Result rest = authFeign.findPageResources(CookieUtil.getHeader(loginUser.getUsername()), res);
		JSONObject jsono = JSONObject.parseObject(JSONObject.toJSON(rest.getData()).toString());
		int list_count = jsono.getInteger("total");
		String json_list = jsono.getJSONArray("list").toString();
		List<ResourceDTO> list = JacksonUtil.jsonToList(json_list, ResourceDTO.class);

		log.info("分页数据 list{}  ===> " + list);
		// package result
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("recordsTotal", list_count); // 总记录数
		maps.put("recordsFiltered", list_count); // 过滤后的总记录数
		maps.put("data", list); // 分页列表
		return maps;
	}

	@RequestMapping("/remove")
	@ResponseBody
	public ReturnT<String> remove(HttpServletRequest request, long id) {
		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
		authFeign.deleteResource(CookieUtil.getHeader(loginUser.getUsername()), id);
		return ReturnT.SUCCESS;
	}

	@RequestMapping("/add")
	@ResponseBody
	public ReturnT<String> add(ResourceDTO resource, HttpServletRequest request) {
		log.info("ResourceDTO{} ==> " + resource);
		if (!StringUtils.hasText(resource.getName())) {
			return new ReturnT<String>(ReturnT.FAIL_CODE,
					I18nUtil.getString("system_please_input") + I18nUtil.getString("name"));
		}
		if(resource.getParentId()==null) {
			resource.setParentId(0L);
		}
		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
		authFeign.saveResource(CookieUtil.getHeader(loginUser.getUsername()), resource);
		return ReturnT.SUCCESS;
	}

	@RequestMapping("/update")
	@ResponseBody
	public ReturnT<String> update(ResourceDTO resource, HttpServletRequest request) {
		log.info("ResourceDTO{} ==> " + resource);
		if (!StringUtils.hasText(resource.getName())) {
			return new ReturnT<String>(ReturnT.FAIL_CODE,
					I18nUtil.getString("system_please_input") + I18nUtil.getString("name"));
		}
		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
		authFeign.updateResource(CookieUtil.getHeader(loginUser.getUsername()), resource);
		return ReturnT.SUCCESS;
	}

}
