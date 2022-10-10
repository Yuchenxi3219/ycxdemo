package com.example.demo.annotion.InterfaceLogHandler;

import com.example.demo.annotion.InterfaceLog;
import com.example.demo.foundation.InterfaceLogEvent;
import com.example.demo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * @author YuChenXi
 * @date 2022/8/28 7:49 下午
 */
@Component
@Slf4j
@Aspect
public class InterfaceLogHandler {

    @Autowired
    private InterfaceLogEvent interfaceLogEvent;

    @Pointcut("execution(* com.example.demo.controller.TestController.*(..))")
    public void logConfig() {
    }

    // 获取注解
    public Optional<InterfaceLog> getAnnotationLog(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            Signature signature = proceedingJoinPoint.getSignature();
            if (signature instanceof MethodSignature) {
                MethodSignature methodSignature = (MethodSignature) signature;
                Method method = methodSignature.getMethod();
                if (method.isAnnotationPresent(InterfaceLog.class)) {
                    InterfaceLog annotation = method.getAnnotation(InterfaceLog.class);
                    return Optional.of(annotation);
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return Optional.empty();
    }

    @Around(value = "logConfig()")
    public Object interfaceLogHandler(ProceedingJoinPoint joinPoint) {
        try {
            Object proceed = joinPoint.proceed();
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            InterfaceLogDto interfaceLogDto = new InterfaceLogDto();
            long startTime = System.currentTimeMillis();
            joinPoint.proceed();
            if (getAnnotationLog(joinPoint).isPresent()) {
                InterfaceLog interfaceLog = getAnnotationLog(joinPoint).get();
                interfaceLogDto.setIp(request.getRequestURI().toString());
                interfaceLogDto.setCostTime((int) (System.currentTimeMillis() - startTime));
                interfaceLogDto.setRequestDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                boolean flag = interfaceLog.isInnerInterface();
                interfaceLogDto.setExtra(flag ? "inner interface" : "not inner interface");
                interfaceLogEvent.printLogV2(interfaceLogDto);
            }
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return new BaseResponse("0","error",throwable.getMessage());
        }
    }
}
