package com.shenxiao.exception;

import com.shenxiao.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //@ResquestBody + @ControllerAdvice 处理异常的返回值转换为json响应给前端
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)//指定能够处理的异常类型
    public Result ex(Exception e){
        e.printStackTrace();
        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
    }
}
