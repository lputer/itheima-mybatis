package com.itheima.service.impl;

import com.itheima.anno.Log;
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

@Service("DeptServiceImplA")
public class DeptServiceImpl implements DeptService {
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

    @Log
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) throws Exception {
            // 根据部门id删除部门信息
            deptMapper.deleteById(id);

            // 模拟：RuntimeException异常发生
            // int i = 1 / 0;

            if (true) {
                throw new Exception("A出现异常了~~~");
            }

            // 删除部门下的所有员工信息
            empService.deleteByDeptId(id);
    }

    @Log
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

    @Log
    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
