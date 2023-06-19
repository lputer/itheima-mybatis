package com.itheima.service.impl;

import com.itheima.mapper.FileUploadLogMapper;
import com.itheima.pojo.FileUploadLog;
import com.itheima.service.FileUploadLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUploadServiceImpl implements FileUploadLogService {

    @Autowired
    private FileUploadLogMapper fileUploadLogMapper;

    @Override
    public void insert(FileUploadLog fileUploadLog) {
        fileUploadLogMapper.insert(fileUploadLog);
    }
}
