package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickerApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testSelectAll() {
        List<User> userList = userMapper.selectAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void testEmpSelectAll() {
        List<Emp> empList = empMapper.selectAll();
        empList.forEach(System.out::println);
    }

    @Test
    public void testDeleteById() {
        empMapper.deleteById(16);
    }

    @Test
    public void testInsert() {
        Emp emp = new Emp();
        emp.setUsername("tom");
        emp.setName("汤姆");
        emp.setGender((short) 1);
        emp.setImage("1.png");
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setDeptId(1);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
        System.out.println(emp.getDeptId());
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(21);
        emp.setUsername("tom21");
        emp.setName("汤姆21");
        emp.setGender((short) 1);
        emp.setImage("1.png");
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setDeptId(1);
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testSelectById() {
        empMapper.getById(21);
    }

    @Test
    public void testSelectByCondition() {
        List<Emp> empList = empMapper.selectByCondition("张", (short) 1, LocalDate.of(2000, 01, 01), LocalDate.of(2020, 01, 01));
        empList.forEach(System.out::println);
        System.out.println("------------------------------------");
        System.out.println(empMapper.selectByCondition(null, (short) 1, null, null));
        System.out.println("------------------------------------");
        System.out.println(empMapper.selectByCondition(null, null, null, null));
    }

    @Test
    public void testUpdate2() {
        //要修改的员工信息
        Emp emp = new Emp();
        emp.setId(22);
        emp.setUsername("Tom111");
        emp.setName("汤姆111");
        emp.setGender((short) 1);

        emp.setUpdateTime(LocalDateTime.now());

        //调用方法，修改员工数据
        empMapper.update(emp);
    }

    @Test
    public void testBatchDelete() {
        empMapper.deleteByIds(List.of(1, 2, 3));
    }

}
