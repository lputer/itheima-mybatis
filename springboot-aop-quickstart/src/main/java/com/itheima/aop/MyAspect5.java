package com.itheima.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Slf4j
//@Aspect
public class MyAspect5 {

    // 省略方法的修饰符号
    // @Before("execution(void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    // 使用 * 代替返回值类型
    // @Before("execution(* com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    // 使用 * 省略包名, 一层包使用一个*
    // @Before("execution(* com.itheima.*.*.DeptServiceImpl.delete(java.lang.Integer))")
    // 使用 .. 省略包名
    // @Before("execution(* com..DeptServiceImpl.delete(java.lang.Integer))")
    // 使用 * 代替类名
    // @Before("execution(* com..*.delete(java.lang.Integer))")
    // 使用 * 代替方法名
    // @Before("execution(* com..*.*(java.lang.Integer))")
    // 使用 * 代替参数
    // @Before("execution(* com.itheima.service.impl.DeptServiceImpl.delete(*))")
    // 使用 .. 省略参数
    // @Before("execution(* com..*.*(..))")
    @Before("execution(* com.itheima.service.DeptService.list(..))||execution(* com.itheima.service.DeptService.delete(..)))")
    public void Before(JoinPoint joinPoint) {
        log.info("before...");
    }
}
