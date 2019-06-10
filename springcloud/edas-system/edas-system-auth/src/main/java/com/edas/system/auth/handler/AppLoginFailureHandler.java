package com.edas.system.auth.handler;

import com.edas.edascommon.model.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("appLoginFailureHandler")
public class AppLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String message = "";
        response.setContentType("application/json;charset=UTF-8");
        if(exception instanceof BadCredentialsException){
            message = "用户名或密码错误";
            response.getWriter().write(objectMapper.writeValueAsString(Result.fail("-1", message)));
        }
    }
}
