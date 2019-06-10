package com.edas.system.common.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edas.system.common.model.ResultBody;
import com.edas.system.common.utils.WebUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义签名错误处理器
 *
 * @author liuyadu
 */
@Slf4j
public class OpenSignatureDeniedHandler implements SignatureDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       Exception exception) throws IOException, ServletException {
        ResultBody responseData = OpenExceptionHandler.resolveException(exception, request, response);
        WebUtils.writeJson(response, responseData);
    }
}