package com.xd.gateway.controller;

import com.xd.common.api.ApiResponse;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway/captcha")
public class CaptchaController {

    @PostMapping("/email/send")
    public ApiResponse<Map<String, Object>> sendEmailCaptcha(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String scene = payload.getOrDefault("scene", "login");
        // TODO: generate code, cache to Redis and send email.
        Map<String, Object> result = new HashMap<>();
        result.put("email", email);
        result.put("scene", scene);
        result.put("status", "SENT");
        return ApiResponse.ok(result);
    }
}
