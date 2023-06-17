package com.itheima.service;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.Student;

public interface StudentService {

    PageBean selectAll(Integer page, Integer pageSize);

    void deleteById(Integer[] id);

    void insert(Student student);

    Student selectById(Integer id);

    void update(Student student);

}
