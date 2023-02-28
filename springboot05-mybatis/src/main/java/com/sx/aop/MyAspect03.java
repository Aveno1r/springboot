package com.sx.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
@Order(3)
public class MyAspect03 {
    @Before("com.sx.aop.MyAspect01.pt()")
    public void before(){
        log.info("MyAspect03 -> before");
    }

    @After("com.sx.aop.MyAspect01.pt()")
    public void after(){
        log.info("MyAspect03 -> after");
    }
}