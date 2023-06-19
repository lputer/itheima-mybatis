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
@Order(2)
public class MyAspect2 {

    // 前置通知
    // 引用MyAspect1切面类中的切入点表达式
    // @Before("com.itheima.aop.MyAspect1.pt()")
    @Before("execution(* com.itheima.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("MyAspect2 -> before...");
    }


    // 后置通知
    @After("execution(* com.itheima.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info("MyAspect2 -> after...");
    }

}
