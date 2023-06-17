package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        /*// 调用mapper层,将查询的总条数赋值给count
        Long count = empMapper.count();
        // 计算起始索引=(页码-1)*每页数量
        Integer start = (page-1)*pageSize;
        // 调用mapper层,将起始索引和每页数量传入mapper层,查询后将查询结果赋值到集合里
        List<Emp> empList = empMapper.page(start,pageSize);
        // 将总记录数count和empList查询结果封装到PageBean里,返回到Controller层
        PageBean pageBean = new PageBean(count,empList);*/

        // 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 执行分页查询, 将查询结果赋值到empList集合里, 但List类型不能调用Page对象的属性和方法, 需要强制转换
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        // 获取分页结果, 强制转换成Page<Emp>类型, 这样才能调用Page对象的方法和属性
        Page<Emp> p = (Page<Emp>) empList;
        // p.getTotal()获取总记录数, p.getResult()获取分页结果, 封装到pageBean中
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());

        return pageBean;
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
    }

    @Override
    public void insert(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp selectById(Integer id) {
        Emp emp = empMapper.selectById(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp getByUsernameAndPassword(Emp emp) {
        Emp emp1 = empMapper.getByUsernameAndPassword(emp);
        return emp1;
    }
}
