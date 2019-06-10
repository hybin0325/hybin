package com.edas.system.common.exception;

import com.edas.system.common.exception.OpenExceptionHandler;
import com.edas.system.common.model.ResultBody;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 */
@Slf4j
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws ServletException {

//        Map map = new HashMap();
//        map.put("code", "401");
//        String msg="Invalid access token";
//        map.put("msg", authException.getMessage());
//        //map.put("path", request.getServletPath());
//        map.put("timestamp", String.valueOf(new Date().getTime()));
//        response.setContentType("application/json");
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.writeValue(response.getOutputStream(), map);
//        } catch (Exception e) {
//            throw new ServletException();
//        }
		ResultBody responseData = OpenExceptionHandler.resolveException(authException, request, response);
		log.info(responseData.getMsg() );
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(response.getOutputStream(), responseData);
		} catch (Exception e) {
			throw new ServletException();
		}
	}
}
