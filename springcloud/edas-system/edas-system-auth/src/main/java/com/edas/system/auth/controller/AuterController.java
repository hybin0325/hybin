package com.edas.system.auth.controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edas.system.auth.utils.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AuterController {
	
	@GetMapping("/userJwt")
    public Object getCurrentUserJwt(Authentication authentication, HttpServletRequest request) throws UnsupportedEncodingException {
        return authentication;
    }

    @GetMapping("/userRedis")
    public Object getCurrentUserRedis(Authentication authentication) {
        log.info("【SecurityOauth2Application】 getCurrentUserRedis authentication={}", JsonUtil.toJson(authentication));

        return authentication;
    }

    @GetMapping("/user/me")
    public Principal user(Principal user){
        return user;
    }

}
