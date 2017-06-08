package com.jointsky.edps.aspect;

import com.jointsky.edps.model.HttpLogs;
import com.jointsky.edps.service.HttpLogsService;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Created by root on 2017/6/7.
 */
@Aspect
@Component
public class HttpLogAspect {

    @Autowired
    private HttpLogsService httpLogsService;
    private Logger logger = Logger.getLogger(getClass());
    HttpLogs httpLogs = new HttpLogs();
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.jointsky.edps.controller..*.*(..))")
    public void httplog(){}

    @Before("httplog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        httpLogs.setUrl(request.getRequestURL().toString());
        httpLogs.setHttpMethod(request.getMethod());
        httpLogs.setIp(request.getRemoteAddr());
        startTime.set(System.currentTimeMillis());
        httpLogs.setStartTime(new Timestamp(startTime.get()));
        httpLogs.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        httpLogs.setArgs(Arrays.toString(joinPoint.getArgs()));

    }

    @After("httplog()")
    public void doAfterReturning(){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        startTime.set(System.currentTimeMillis());
        httpLogs.setEndTime(new Timestamp(startTime.get()));
        httpLogs.setResponseStatus(String.valueOf(response.getStatus()));

        //logger.info(httpLogs);

        httpLogsService.saveHttpLogs(httpLogs);
    }


}
