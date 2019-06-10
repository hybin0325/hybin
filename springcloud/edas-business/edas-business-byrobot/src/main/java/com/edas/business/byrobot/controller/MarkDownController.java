package com.edas.business.byrobot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;


/**
 * <p>
 * File Name: MarkDownController.java
 * </p>
 * <p>
 * Description
 * </p>
 * <p>
 * Date：2019年5月24日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@ApiIgnore
@Controller
@RequestMapping("markDown")
public class MarkDownController {
	
	@GetMapping(value = "/view")
    public String view() {
        return "view";
    }
}