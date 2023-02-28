package com.sx.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect05 {
    @Before("@annotation(com.sx.annotation.MyLog)")
    public void before(){
        log.info("MyAspect05 -> before...");
    }

    @After("@annotation(com.sx.annotation.MyLog)")
    public void after(){
        log.info("MyAspect05 -> after");
    }
}
