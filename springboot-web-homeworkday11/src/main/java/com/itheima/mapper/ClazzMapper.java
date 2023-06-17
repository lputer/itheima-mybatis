package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> selectAll(String name, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void insert(Clazz clazz);
}
