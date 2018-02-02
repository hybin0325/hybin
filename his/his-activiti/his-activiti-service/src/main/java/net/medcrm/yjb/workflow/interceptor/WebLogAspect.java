package net.medcrm.yjb.workflow.interceptor;

/**
 * Created by Administrator on 2018/1/3.
 */

import com.alibaba.fastjson.JSONObject;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.AccessTokenLocal;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.feign.SysLogVO;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.feign.client.LogFeignClient;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * Web层日志切面
 */
@Aspect
@Order(5)
@Component
public class WebLogAspect {
    private Logger logger = Logger.getLogger(getClass());

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Autowired
    EmployeeServiceClient employeeServiceClient;

    @Autowired
    LogFeignClient logFeignClient;

    @Pointcut("execution(public * net.medcrm.yjb.workflow.controller.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        if(AccessTokenLocal.getCurrentLocalToken() != null){
            BaseResp<EmployeeVO> baseResp = employeeServiceClient.currentEmp();
            EmployeeVO vo;

            SysLogVO log = new SysLogVO();
            if(baseResp.getCode() == 0 && baseResp.getMessage().equals("success")){
                vo = (EmployeeVO)baseResp.getData();
                System.out.println(JSONObject.toJSONString(vo));
                log.setCreateUserId(vo.getId());
                log.setCreateUserName(vo.getAccountId());
            }
            log.setArgs(Arrays.toString(joinPoint.getArgs()).length()>200?"text类型数据":Arrays.toString(joinPoint.getArgs()));
            log.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            log.setContent("");
            log.setCreateDate(new Date());
            log.setHttpMethod(request.getMethod());
            log.setIp(request.getRemoteAddr());
            log.setUrl(request.getContextPath() +  request.getServletPath());
            log.setId(UUID.randomUUID().toString());

            logFeignClient.save(log);
        }


    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }

}
