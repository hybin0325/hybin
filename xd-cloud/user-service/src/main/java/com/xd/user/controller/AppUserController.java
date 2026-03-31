package com.xd.user.controller;

import com.xd.common.api.ApiResponse;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/app")
public class AppUserController {

    @GetMapping("/{userId}/profile")
    public ApiResponse<Map<String, String>> profile(@PathVariable String userId) {
        Map<String, String> profile = new HashMap<>();
        profile.put("userId", userId);
        profile.put("nickname", "demo-user");
        profile.put("email", "user@example.com");
        profile.put("userType", "APP_USER");
        return ApiResponse.ok(profile);
    }
}
