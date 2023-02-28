package com.sx.controller;

import com.sx.pojo.User;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {
    @RequestMapping("/simpleParam")
    //对应形参和请求参数名称不同的参数可以使用@RequestParam注解对形参进行声明
    //@RequestParam(required = true)，当required为true代表，请求的时候必须要有。否则会报400代码语法错误
    //如果参数是可选参数把required改为false即可
//    public String simpleParam(@RequestParam(value = "name",required = false
//    )String username, Integer age){
//        System.out.println(username + " " + age);
//        return "ok";
//    }
    public String simpleParam(User user){
        System.out.println(user);
        return "simpleParam";
    }
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "arrayParam";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "listParam";
    }

    //日期时间参数
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")LocalDateTime updateTime){
        System.out.println(updateTime);
        return "dateParam";
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "jsonParam";
    }

    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id + " " +name);
        return "pathParam";
    }
}
