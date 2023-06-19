package com.itheima.aop;


import com.itheima.mapper.FileUploadLogMapper;
import com.itheima.pojo.FileUploadLog;
import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Component
@Aspect
@Slf4j
public class FileUploadLogAspect {

    @Autowired
    private FileUploadLogMapper fileUploadLogMapper;

    @Around("execution(* com.itheima.controller.UploadController.upload(..))")
    public Object recordFileUploadLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        FileUploadLog fileUploadLog = new FileUploadLog();

        Object[] args = proceedingJoinPoint.getArgs();
        MultipartFile file = (MultipartFile) args[0];
        // 原始文件名
        fileUploadLog.setFilename(file.getOriginalFilename());
        // 文件大小
        fileUploadLog.setSize(file.getSize());
        // 文件扩展名
        fileUploadLog.setExtname(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
        // 文件上传时间
        fileUploadLog.setUploadTime(LocalDateTime.now());
        // 阿里云OSS文件url
        Object obj = proceedingJoinPoint.proceed();

        Result result = (Result) obj;

        fileUploadLog.setUrl(result.getData().toString());
        fileUploadLogMapper.insert(fileUploadLog);
        return obj;
    }
}
