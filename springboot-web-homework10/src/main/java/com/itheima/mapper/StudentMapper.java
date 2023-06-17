package com.itheima.mapper;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from student")
    List<Student> list();

    void deleteById(Integer[] ids);

    @Insert("insert into student(name, no, gender, phone, degree, class_id, create_time, update_time) values (#{name},#{no},#{gender},#{phone},#{degree},#{classId},#{createTime},#{updateTime})")
    void insert(Student student);

    @Select("select * from student where id = #{id}")
    Student selectById(Integer id);

    @Update("update student set name=#{name},no=#{no},gender=#{gender},phone=#{phone},degree=#{degree},class_id=#{classId},violation_count=#{violationCount},violation_score=#{violationScore},update_time=#{updateTime} where id = #{id}")
    void update(Student student);
}
