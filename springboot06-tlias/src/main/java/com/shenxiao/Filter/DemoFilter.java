//package com.shenxiao.Filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = "/*")
//public class DemoFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("DemoFilter   放行前逻辑.....");
//
//        //放行请求
//        filterChain.doFilter(servletRequest,servletResponse);
//
//        System.out.println("DemoFilter   放行后逻辑.....");
//    }
//}