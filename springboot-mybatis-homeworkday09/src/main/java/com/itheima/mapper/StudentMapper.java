package com.itheima.mapper;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    public void insertStudent(Student student);

    public Student selectById(Integer id);

    public void updateTrends(Student student);

    public List<Student> selectTrends(String name, String no, Short degree, Integer classId);
}
