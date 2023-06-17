package com.itheima.service;

import com.github.pagehelper.Page;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface ClazzService {
    PageBean selectAll(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    void delete(List<Integer> ids);

    void insert(Clazz clazz);

}
