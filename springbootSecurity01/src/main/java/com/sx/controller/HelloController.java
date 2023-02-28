package com.sx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        System.out.println("hello..");
        return "Hello SpringSecurity";
    }
    @GetMapping("/show01")
    public String show01(){
        System.out.println("show01..");
        return "Hello show01";
    }
    @GetMapping("/show02")
    public String show02(){
        System.out.println("show02..");
        return "Hello show02";
    }
}
