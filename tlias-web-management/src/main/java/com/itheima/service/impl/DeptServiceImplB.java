package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptLogService;
import com.itheima.service.DeptService;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service("DeptServiceImplB")
public class DeptServiceImplB implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpService empService;

    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {
        List<Dept> deptList = deptMapper.selectAll();
        return deptList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) throws Exception {
        try {
            // 根据部门id删除部门信息
            deptMapper.deleteById(id);

            // 模拟：RuntimeException异常发生
            // int i = 1 / 0;

            if (true) {
                throw new Exception("B出现异常了~~~");
            }

            // 删除部门下的所有员工信息
            empService.deleteByDeptId(id);

        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此时解散的是" + id + "号部门");
            //调用其他业务类中的方法
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void insert(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept selectById(Integer id) {
        Dept dept = deptMapper.selectById(id);
        return dept;
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
