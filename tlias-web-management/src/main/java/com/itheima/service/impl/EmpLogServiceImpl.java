package com.itheima.service.impl;

import com.itheima.anno.Log;
import com.itheima.mapper.EmpLogMapper;
import com.itheima.pojo.EmpLoginLog;
import com.itheima.service.EmpLogService;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void Insert(EmpLoginLog empLoginLog) {
        empLogMapper.insert(empLoginLog);
    }
}
