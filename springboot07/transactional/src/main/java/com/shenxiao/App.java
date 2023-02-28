package com.shenxiao;

import com.example.EnableHeaderConfig;
import com.example.HeaderConfig;
import com.example.MyImportSelector;
import com.example.TokenParser;
import org.dom4j.io.SAXReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import javax.xml.parsers.SAXParser;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@ComponentScan({"com.shenxiao","com.example"})
//@Import(TokenParser.class)
//@Import(HeaderConfig.class)
//@Import(MyImportSelector.class)
@EnableHeaderConfig
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
//    @Bean("sxsxsxs")
//    public SAXReader sxReader(){
//        return new SAXReader();
//    }
}
