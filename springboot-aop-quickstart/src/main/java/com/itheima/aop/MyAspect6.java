package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class MyAspect6 {

    @Before("@annotation(com.itheima.anno.MyLog)")
    public void before() {
        log.info("MyAspect6 -> before...");
    }

    @After("@annotation(com.itheima.anno.MyLog)")
    public void after() {
        log.info("MyAspect6 -> after...");
    }
}
