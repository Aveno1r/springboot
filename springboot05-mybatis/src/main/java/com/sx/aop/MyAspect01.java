package com.sx.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect01 {
    @Pointcut("execution(* com.sx.service.*.*(..))")
    public void pt(){};
    @Before("pt()")
    public void before(JoinPoint joinPoint){
        log.info("before..");
    }

    @Around("pt()")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before..");

        Object result = proceedingJoinPoint.proceed();

        log.info("around after..");
        return result;
    }

    @After("pt()")
    public void after(JoinPoint joinPoint){
        log.info("after");
    }

    @AfterReturning("pt()")
    public void afterReturning(JoinPoint joinPoint){
        log.info("afterReturning");
    }

    @AfterThrowing("pt()")
    public void afterThrowing(JoinPoint joinPoint){
        log.info("afterThrowing");
    }
}


