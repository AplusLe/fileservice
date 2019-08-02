package com.aplus.fileservice.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 *  记录调用日志
 * @packae com.aplus.fileservice.config
 * @auther Kevin
 * @date 26/07/2019 14:06
 */
@Aspect
@Component
@Slf4j
public class ControllerInterceptor {
    @Around(value = "@annotation(org.springframework.web.bind.annotation.PostMapping)"
    +" || @annotation(org.springframework.web.bind.annotation.PostMapping)"
    +" || @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object log(ProceedingJoinPoint pjp) throws Throwable{
        long startTime = System.currentTimeMillis();
        String className=pjp.getTarget().getClass().getSimpleName();
        String methodName=pjp.getSignature().getName();
        Object[] args=pjp.getArgs();
        HttpServletRequest request =
                ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                        .getRequest();
        log.info("RequestURL : " + request.getRequestURI());
        log.info("RequestTarget : FILE-SERVICE." + className + "." + methodName);
        log.info("method startTime:-------------"+ startTime);
        Object result = null;
        try {
            result= pjp.proceed();
            if(args.length > 0 ){
                try {
                    log.info("RequestParam : {}", JSON.toJSON(args));
                }catch (Exception e){
                    for (Object param : args) {
                        try {
                            log.info("RequestParam : {}", JSON.toJSON(param));
                        } catch (Exception ig) {
                            log.info("RequestParam : {}", param.toString());
                        }
                    }
                }
            }
        } finally {
            log.info("result: {}", JSON.toJSONString(result));
            log.info("Internal Method Cost Time: {}ms", System.currentTimeMillis() - startTime);
        }
        return result;
    }
}
