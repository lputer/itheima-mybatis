package com.itheima.aop;

import com.itheima.mapper.EmpLogMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpLoginLog;
import com.itheima.pojo.Result;
import com.itheima.service.EmpLogService;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.sql.RowSet;
import java.time.LocalDateTime;

@Component
@Aspect
@Slf4j
public class LoginLogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private EmpLogMapper empLogMapper;

    @Around("execution(* com.itheima.controller.LoginController.Login(..))")
    public Object recordLoginLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        EmpLoginLog loginLog = new EmpLoginLog();

        //获取方法参数
        Object[] args = proceedingJoinPoint.getArgs();
        Emp emp = (Emp) args[0];
        loginLog.setUsername(emp.getUsername());
        loginLog.setPassword(emp.getPassword());
        loginLog.setLoginTime(LocalDateTime.now());

        // 登录耗时
        long start = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        //获取登录结果,是否成功
        Result result = (Result) obj;
        Integer code = result.getCode();
        loginLog.setIsSuccess(code.shortValue());
        if(code == 1){
            loginLog.setJwt(result.getData().toString());
        }
        loginLog.setCostTime(end - start);

        //保存登录日志
        empLogMapper.insert(loginLog);

        return obj;
    }
}
