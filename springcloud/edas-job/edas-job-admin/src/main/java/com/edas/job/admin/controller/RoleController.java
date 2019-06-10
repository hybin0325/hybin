package com.edas.job.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.edas.edascommon.model.Result;
import com.edas.job.admin.core.dto.QueryRes;
import com.edas.job.admin.core.dto.RolesDTO;
import com.edas.job.admin.core.model.XxlJobGroup;
import com.edas.job.admin.core.model.XxlJobUser;
import com.edas.job.admin.core.util.CookieUtil;
import com.edas.job.admin.core.util.JacksonUtil;
import com.edas.job.admin.dao.XxlJobGroupDao;
import com.edas.job.admin.fegin.AuthFeign;
import com.edas.job.admin.service.LoginService;
import com.edas.job.core.biz.model.ReturnT;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private XxlJobGroupDao xxlJobGroupDao;
	
	@Autowired
	private AuthFeign authFeign;

	@RequestMapping
	public String index(Model model) {
		// 执行器列表
		List<XxlJobGroup> groupList = xxlJobGroupDao.findAll();
		model.addAttribute("groupList", groupList);
		return "role/role.index";
	}
	
	@RequestMapping("/pageList")
	@ResponseBody
	public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int start,
			@RequestParam(required = false, defaultValue = "10") int length, String name,
			HttpServletRequest request) {

		// page list
		//List<XxlJobUser> list = xxlJobUserDao.pageList(start, length, username, role);
		log.info("开始分页数 start{}  ===> ",start);
		log.info("开始分页码 length{}  ===> ",length);
		QueryRes res=new QueryRes();
		res.setPageNo(start/length+1);
		res.setPageSize(length);
		Map<String, Object> params=Maps.newHashMap();
		params.put("name", name);
		res.setParams(params);
		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
		Result rest= authFeign.findPageRoles(CookieUtil.getHeader(loginUser.getUsername()), res);
			
		//int list_count = xxlJobUserDao.pageListCount(start, length, username, role);
		JSONObject jsono = JSONObject.parseObject(JSONObject.toJSON(rest.getData()).toString());
		int list_count=jsono.getInteger("total");
		String json_list=jsono.getJSONArray("list").toString();
		List<RolesDTO> list=JacksonUtil.jsonToList(json_list, RolesDTO.class);
	   
		log.info("分页数据 list{}  ===> "+list);
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
		// avoid opt login seft
		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
		authFeign.deleteRole(CookieUtil.getHeader(loginUser.getUsername()), id);
		return ReturnT.SUCCESS;
	}
	
	
	@RequestMapping("/add")
	@ResponseBody
	public ReturnT<String> add(RolesDTO roles,String resources,HttpServletRequest request) {
		log.info("RolesDTO{} ==> ",roles);
		if(resources!=null&& !"".equals(resources)) {
			roles.setResourceIds(JacksonUtil.stringToLongList(resources));
		}
		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
		authFeign.saveRole(CookieUtil.getHeader(loginUser.getUsername()),roles);
		return ReturnT.SUCCESS;
	}

	@RequestMapping("/update")
	@ResponseBody
	public ReturnT<String> update(HttpServletRequest request,RolesDTO roles,String resources) {

		log.info("RolesDTO{} ==> ",roles);
		if(resources!=null&& !"".equals(resources)) {
			roles.setResourceIds(JacksonUtil.stringToLongList(resources));
		}
		
		XxlJobUser loginUser = (XxlJobUser) request.getAttribute(LoginService.LOGIN_IDENTITY_KEY);
		authFeign.editRole(CookieUtil.getHeader(loginUser.getUsername()),roles);
		return ReturnT.SUCCESS;
	}

}
