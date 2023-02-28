package com.sx.config;

import com.alibaba.fastjson.JSON;
import com.sx.common.R;
import com.sx.exception.MyAccessDeniedHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class securityConfigure extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("zhangsan")
                .password("{noop}123")
                .roles("ZS")
                .and()
                .withUser("admin")
                .password("{noop}666")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //允许直接访问的请求
                .antMatchers("/login.html").permitAll()
                //指定只有ADMIN才能访问的页面
                .antMatchers("/show01").hasRole("ADMIN")
                //指定只有ZS LS才能访问的页面
                .antMatchers("/show02").hasAnyRole("ZS","LS")
                // 其他请求只要通过认证即可访问
                .anyRequest().authenticated()
                .and()
                .formLogin();
        http.formLogin()
                .loginPage("/login.html")
                //用户名参数名称
                .usernameParameter("username")
                //密码参数名称
                .passwordParameter("password")
                //登录请求地址
                .loginProcessingUrl("/login")
                //登录成功后跳转的页面 设置为true 强制跳转到index.html
                .defaultSuccessUrl("/index.html",true)
                //登陆失败跳转到的页面
                .failureForwardUrl("/login.html")
                //禁用csrf请求
                .and().csrf().disable()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html");
        //方式一 创建AccessDenieHandler的实现类
//        AccessDeniedHandlerImpl accessDeniedHandler = new AccessDeniedHandlerImpl();
//        accessDeniedHandler.setErrorPage("/error.html");
//        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        //方式二 自己定义异常处理类
//        http.exceptionHandling().accessDeniedHandler(new MyAccessDeniedHandler());
        //方式三 匿名内部类
//          http.exceptionHandling().accessDeniedHandler(new AccessDeniedHandler() {
//              @Override
//              public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//                  response.setContentType("text/json;charset=utf-8");
//                  response.getWriter().write(JSON.toJSONString(R.error("权限不足!-3")));
//              }
//          });
        //方式四 Lambda表达式
        http.exceptionHandling().accessDeniedHandler((request,response,accessDeniedException) -> {
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().write(JSON.toJSONString(R.error("权限不足!-4")));
        });
    }
}
