package com.edas.edascommon.exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hybin
 */
public interface SignatureDeniedHandler {
    void handle(HttpServletRequest var1, HttpServletResponse var2, Exception var3) throws IOException, ServletException;
}