package com.xd.auth.controller;

import com.xd.auth.dto.EmailLoginRequest;
import com.xd.auth.dto.SocialLoginRequest;
import com.xd.common.api.ApiResponse;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/email/login")
    public ApiResponse<Map<String, String>> emailLogin(@RequestBody EmailLoginRequest request) {
        // TODO: verify email/password and captcha
        Map<String, String> token = new HashMap<>();
        token.put("access_token", "mock-access-token");
        token.put("refresh_token", "mock-refresh-token");
        token.put("userType", "APP_USER");
        return ApiResponse.ok(token);
    }

    @PostMapping("/social/login")
    public ApiResponse<Map<String, String>> socialLogin(@RequestBody SocialLoginRequest request) {
        // TODO: verify provider token and map/bind openid
        Map<String, String> token = new HashMap<>();
        token.put("provider", request.getProvider());
        token.put("openid", request.getOpenid());
        token.put("access_token", "mock-access-token");
        return ApiResponse.ok(token);
    }
}
