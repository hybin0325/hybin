package net.medcrm.yjb.workflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*@author 原饼
*@version 创建时间2018年2月2日下午2:56:37
**/
@Controller
@RequestMapping(value = "/static")
public class IndexWebController {

	@GetMapping("/indexTest")
	public String getTest() {
		return "/upload";
	}
}
