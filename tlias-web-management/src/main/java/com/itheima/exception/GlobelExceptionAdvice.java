package com.itheima.exception;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobelExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public Result ex(Exception e) {
        e.printStackTrace();
        return Result.error("项目正在维护,稍后再试");
    }
}
