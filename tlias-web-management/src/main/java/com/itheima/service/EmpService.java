package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void deleteByIds(List<Integer> ids);

    void insert(Emp emp);

    Emp selectById(Integer id);

    void update(Emp emp);

    Emp getByUsernameAndPassword(Emp emp);

    void deleteByDeptId(Integer id);

}
