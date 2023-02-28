package com.sx.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class MyAspect06 {
    @Pointcut("@annotation(com.sx.annotation.MyLog)")
    private void pt(){}

    @Before("pt()")
    public void before(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().getName()+"MyAspect06 -> before...");
    }

    @After("pt()")
    public void after(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().getName()+"MyAspect06 -> after");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        String name = pjp.getTarget().getClass().getName();
        log.info("目标类名:" + name);
        String methodName = pjp.getSignature().getName();
        log.info("方法类名" + methodName);
        Object[] args = pjp.getArgs();
        log.info("方法参数:" + Arrays.toString(args));
        Object returnValue = pjp.proceed();
        return returnValue;
    }
}
