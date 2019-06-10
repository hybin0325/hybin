package com.edas.job.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edas.job.admin.controller.annotation.PermissionLimit;
import com.edas.job.admin.core.conf.XxlJobScheduler;
import com.edas.job.core.biz.AdminBiz;

/**
 * Created by xuxueli on 17/5/10.
 */
@Controller
public class JobApiController implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @RequestMapping(AdminBiz.MAPPING)
    @PermissionLimit(limit=false)
    public void api(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        XxlJobScheduler.invokeAdminService(request, response);
    }


}
