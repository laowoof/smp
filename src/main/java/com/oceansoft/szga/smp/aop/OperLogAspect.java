package com.oceansoft.szga.smp.aop;

import com.alibaba.fastjson.JSON;
import com.oceansoft.szga.smp.aop.DTO.OperLog;
import com.oceansoft.szga.smp.util.UserAgentUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author zhangxh
 */
@Aspect
@Component
public class OperLogAspect {
    private Logger logger = LoggerFactory.getLogger(OperLogAspect.class);
    ThreadLocal<OperLog> logThread = new ThreadLocal<>();

    @Pointcut("within(com.oceansoft.szga.smp.controller.*)")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        OperLog operLog=new OperLog();
        operLog.setStartTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:sss").format(new Date()));
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        operLog.setUrl(request.getRequestURL().toString());
        operLog.setHttpMethod(request.getMethod());
        operLog.setIp(request.getRemoteAddr());
        operLog.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        String params= JSON.toJSONString(request.getParameterMap());
        if(params.length()>1000){
            params=params.substring(0,1000).concat("....");
        }
        operLog.setParams(params);
        operLog.setUserAgent(UserAgentUtils.getUserAgent(request).toString());
        logThread.set(operLog);

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        String result=JSON.toJSONString(ret);
        if(result.length()>100){
            result=result.substring(0,100).concat("....");
        }
        logThread.get().setResult(result);
        logThread.get().setEndTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:sss").format(new Date()));

        logger.info("操作记录:{}",JSON.toJSONString(logThread.get()));
    }

    @AfterThrowing(throwing="ex", pointcut = "webLog()")
    public void doAfterThrowing(Throwable ex){
        String message=ex.getMessage();
        if(message!=null&&message.length()>100){
            message=message.substring(0,100).concat("....");
        }
        if(message==null){
            message=ex.toString();
        }
        logThread.get().setException(message);
        logThread.get().setEndTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:sss").format(new Date()));
    }
}
