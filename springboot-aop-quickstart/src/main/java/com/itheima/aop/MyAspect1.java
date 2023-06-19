package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
// @Aspect
@Slf4j
public class MyAspect1 {

    // 切入点方法(公共的切入点表达式)
    @Pointcut("execution(* com.itheima.service.*.*(..))")
    public void pt() {

    }

    // @Before("execution(* com.itheima.service.*.*(..))")
    @Before("pt()")
    public void before(JoinPoint joinPoint) {
        log.info("before...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before...");
        Object result = proceedingJoinPoint.proceed();
        log.info("around after...");
        return result;
    }

    @After("pt()")
    public void after(JoinPoint joinPoint) {
        log.info("after...");
    }

    @AfterReturning("pt()")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("afterReturning...");
    }

    @AfterThrowing("pt()")
    public void afterThrowing(JoinPoint joinPoint) {
        log.info("afterThrowing...");
    }
}
