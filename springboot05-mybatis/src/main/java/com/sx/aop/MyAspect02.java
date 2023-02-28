package com.sx.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
@Order(2)
public class MyAspect02 {
    @Before("com.sx.aop.MyAspect01.pt()")
    public void before(){
        log.info("MyAspect02 -> before");
    }

    @After("com.sx.aop.MyAspect01.pt()")
    public void after(){
        log.info("MyAspect02 -> after");
    }
}
