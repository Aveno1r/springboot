package com.shenxiao.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.shenxiao.pojo.Result;
import com.shenxiao.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...");

        //3.获取请求头中的令牌（token）
        String token = request.getHeader("token");
        //4.判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if (!StringUtils.hasLength(token)){
            Result result = Result.error("NOT_LOGIN");
            String json = JSONObject.toJSONString(result);
            response.getWriter().write(json);
            return false;
        }
        //5.解析token，如果解析失败，返回错误结果（未登录）
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("token解析失败");
            Result result = Result.error("NOT_LOGIN");
            String json = JSONObject.toJSONString(result);
            response.getWriter().write(json);
            return false;
        }
        return true;//true放行
    }
}
