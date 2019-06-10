package com.edas.edasusers.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;
import com.edas.edasusers.entity.User;
import com.edas.edasusers.utils.AuthUtils;
import com.edas.system.common.model.LoginUsers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "info/{string}",method = {RequestMethod.GET,RequestMethod.POST})
    public String getUserInfo(@PathVariable String string){
        System.out.print( " ======== user/info ===   " + string);
        return "edas-users   prot 18081 " + string;
    }

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name,HttpServletRequest request, HttpServletResponse response) {
        System.out.println(" 这里是坐过前面负载均衡过来。");
        String requestUrl = request.getRequestURL().toString();//得到请求的URL地址
        String requestUri = request.getRequestURI();//得到请求的资源
        String queryString = request.getQueryString();//得到请求的URL地址中附带的参数
        String remoteAddr = request.getRemoteAddr();//得到来访者的IP地址
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String remoteUser = request.getRemoteUser();
        String method = request.getMethod();//得到请求URL地址时使用的方法
        String pathInfo = request.getPathInfo();
        String localAddr = request.getLocalAddr();//获取WEB服务器的IP地址
        String localName = request.getLocalName();//获取WEB服务器的主机名

        System.out.println(" request requestUrl " + requestUri);
        System.out.println(" request queryString " + queryString);
        System.out.println(" request remoteAddr " + remoteAddr);
        System.out.println(" request remoteHost " + remoteHost);

        System.out.println(" request remotePort " + remotePort);
        System.out.println(" request remoteUser " + remoteUser);
        System.out.println(" request method " + method);

        System.out.println(" request pathInfo " + pathInfo);
        System.out.println(" request localAddr " + localAddr);
        System.out.println(" request localName " + localName);

        return " edas-users ====== 如果看到此页面已经有两个 user　 port 18082 ===== " + name;
    }

    @RequestMapping(value = "/detail/{string}",method = {RequestMethod.GET,RequestMethod.POST})
    public User detail(@PathVariable String string, HttpServletRequest request, HttpServletResponse response){
        System.out.println(" cookie : "+request.getCookies());
        System.out.print( " ======== user/detail ===   " + string);
        User user = new User();

        if (request.getCookies()!=null&&request.getCookies().length>0){
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName()+":"+cookie.getValue());
            }
        }
        Cookie cookie = new Cookie("cookie-info","test");
        response.addCookie(cookie);

        return user;
    }
    
    @PostMapping(value = "/getUser")
    public RetResult<Map> getUserInfo( HttpServletRequest req){
    	log.info("getUser: " );
    	return RetResponse.makeOKRsp(AuthUtils.getReqUser(req));
    }
    
    @RequestMapping(value = "/auth", method = RequestMethod.GET)
	public RetResult<LoginUsers> authDemo(OAuth2Authentication auth) {
		// 获取当前用户资源
    	LoginUsers user = (LoginUsers) auth.getPrincipal();
		return RetResponse.makeOKRsp(user);
	}
    
    @PreAuthorize("hasAuthority('sys:user:query')")
    @PostMapping(value = "/getUsers")
    public RetResult<User> getUserInfos(@RequestBody User u){
    	log.info("u: " +u);
    	User user=new User();
    	user.setId(22222);
    	user.setUsername("Tom111");
    	user.setSex("男");
    	
    	log.info("user: " +user);
    	return RetResponse.makeOKRsp(user);
    }
    
}
