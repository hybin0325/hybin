package com.edas.job.admin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edas.job.admin.controller.annotation.PermissionLimit;
import com.edas.job.admin.core.model.XxlJobUser;
import com.edas.job.admin.service.LoginService;
import com.edas.job.admin.service.XxlJobService;
import com.edas.job.core.biz.model.ReturnT;

import lombok.extern.slf4j.Slf4j;

/**
 * index controller
 * @author xuxueli 2015-12-19 16:13:16
 */
@Slf4j
@Controller
public class IndexController {

	@Resource
	private XxlJobService xxlJobService;
	@Resource
	private LoginService loginService;


	@RequestMapping("/")
	public String index(Model model) {

		Map<String, Object> dashboardMap = xxlJobService.dashboardInfo();
		model.addAllAttributes(dashboardMap);

		return "index";
	}

    @RequestMapping("/chartInfo")
	@ResponseBody
	public ReturnT<Map<String, Object>> chartInfo(Date startDate, Date endDate) {
        ReturnT<Map<String, Object>> chartInfo = xxlJobService.chartInfo(startDate, endDate);
        return chartInfo;
    }
	
	@RequestMapping("/toLogin")
	@PermissionLimit(limit=false)
	public String toLogin(HttpServletRequest request, HttpServletResponse response) {
		if (loginService.ifLogin(request, response) != null) {
			return "redirect:/";
		}
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	@PermissionLimit(limit=false)
	public ReturnT<String> loginDo(HttpServletRequest request, HttpServletResponse response, String username, String password, String ifRemember){
		boolean ifRem = (ifRemember!=null && ifRemember.trim().length()>0 && "on".equals(ifRemember))?true:false;
		return loginService.login(request, response, username, password, ifRem);
	}
	
	@RequestMapping(value="logout", method=RequestMethod.POST)
	@ResponseBody
	@PermissionLimit(limit=false)
	public ReturnT<String> logout(HttpServletRequest request, HttpServletResponse response){
		return loginService.logout2(request, response);
	}
	
	@RequestMapping("/help")
	public String help() {

		/*if (!PermissionInterceptor.ifLogin(request)) {
			return "redirect:/toLogin";
		}*/

		return "help";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
}
