//package com.shenxiao.Filter;
//
//
//import com.alibaba.fastjson.JSONObject;
//import com.shenxiao.pojo.Result;
//import com.shenxiao.utils.JwtUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//@Slf4j
//@WebFilter(urlPatterns = "/*")
//public class LoginCheckFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        //1.获取请求url
//        String url = request.getRequestURL().toString();
//        log.info("请求路径为{}:" + url);
//        //2.判断url中是否含有login，如果包含说明是登陆操作，放行
//        if (url.contains("/login")){
//            filterChain.doFilter(request,response);
//            return;
//        }
//
//        //3.获取请求头的token
//        String token = request.getHeader("token");
//        //4.判断token是否存在
//        if(!StringUtils.hasLength(token)){
//            Result result = Result.error("NOT_LOGIN");
//            String json = JSONObject.toJSONString(result);
//            response.getWriter().write(json);
//            return;
//        }
//
//
//        //5.解析token 如果解析失败，返回登陆失败
//        try {
//            JwtUtils.parseJWT(token);
//        } catch (Exception e) {
//            response.getWriter().write(JSONObject.toJSONString(Result.error("NOT_LOGIN")));
//            return;
//        }
//        filterChain.doFilter(request,response);
//    }
//}
