package com.shenxiao.aspect;

import com.alibaba.fastjson.JSONObject;
import com.shenxiao.mapper.OperateLogMapper;
import com.shenxiao.pojo.OperateLog;
import com.shenxiao.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.sasl.SaslServer;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class aspect {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Autowired
    private HttpServletRequest request;
    @Around("@annotation(com.shenxiao.annotation.Log)")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        /*
        *       private Integer id; //ID
                private Integer operateUser; //操作人ID
                private LocalDateTime operateTime; //操作时间
                private String className; //操作类名
                private String methodName; //操作方法名
                private String methodParams; //操作方法参数
                private String returnValue; //操作方法返回值
                private Long costTime; //操作耗时
        * */

        String token = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(token);
        Integer operateUser = (Integer) claims.get("id");//操作人ID
        LocalDateTime operationTime = LocalDateTime.now();//操作时间
        String name = pjp.getTarget().getClass().getName();//操作类名
        String mname = pjp.getSignature().getName();//操作方法名
        Object[] args = pjp.getArgs();
        String params = Arrays.toString(args);//方法参数
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        String returnValue = JSONObject.toJSONString(result);
        OperateLog operateLog = new OperateLog(null,operateUser,operationTime,name,mname,params,returnValue,end - start);
        operateLogMapper.insert(operateLog);
        return result;

    }
}
