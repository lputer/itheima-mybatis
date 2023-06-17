package com.itheima;

import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class SpringbootMybatisHomeworkday09ApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    /* 新增学生信息 */
    @Test
    public void testInsertStudent() {
        Student student = new Student();
        student.setName("小明");
        student.setNo("2022000018");
        student.setGender((short) 2);
        student.setPhone("15100000000");
        student.setDegree((short) 4);
        student.setViolationCount((short) 0);
        student.setViolationScore((short) 0);
        student.setClassId(5);
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insertStudent(student);
    }

    /* 根据指定 ID 查询学生信息 */
    @Test
    public void testSelectById() {
        studentMapper.selectById(1);
    }

    /* 定义StudentMapper接口对应的XML映射配置文件，根据指定的ID 动态修改学生的信息 */
    @Test
    public void testUpdateById() {
        Student student = new Student();
        student.setId(19);
        student.setName("小红");
        student.setGender((short) 1);
        studentMapper.updateTrends(student);
    }

    /*4. 根据条件，动态查询学生信息，查询条件包括：学生姓名、学号、最高学历、班级 。 查询规则如下： 【动态SQL】
         - 姓名，支持模糊匹配
         - 学号、最高学历、班级都是精确匹配*/
    @Test
    public void testSelectTrends() {
        System.out.println("1.----------------------------------------------------");
        studentMapper.selectTrends(null, null, null, null);
        System.out.println("2.----------------------------------------------------");
        studentMapper.selectTrends("王", null, null, null);
        System.out.println("3.----------------------------------------------------");
        studentMapper.selectTrends("王", null, (short) 3, null);
    }
}
