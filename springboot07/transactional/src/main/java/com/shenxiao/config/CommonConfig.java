package com.shenxiao.config;

import com.shenxiao.service.DeptService;
import com.shenxiao.service.EmpService;
import com.shenxiao.service.impl.EmpServiceImpl;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Bean
    public SAXReader reader(EmpServiceImpl empService){
        System.out.println(empService);
        return new SAXReader();
    }
}
