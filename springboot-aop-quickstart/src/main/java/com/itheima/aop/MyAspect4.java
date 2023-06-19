package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
//@Aspect
@Order(1)
public class MyAspect4 {
    @Before("execution(* com.itheima.service.*.*(..))")
    public void Before(JoinPoint joinPoint) {
        log.info("MyAspect4 -> before...");
    }

    @After("execution(* com.itheima.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info("MyAspect4 -> after...");
    }
}
