package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select * from emp")
    public List<Emp> selectAll();

    @Delete("delete from emp where id = #{id}")
    public void deleteById(Integer id);

    // 添加员工
    @Options(useGeneratedKeys = true, keyProperty = "id") // 返回主键id
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id = #{id}")
    public void update(Emp emp);

    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id AS deptId, create_time AS createTime, update_time AS updateTime from emp where id=#{id}")
    public Emp getById(Integer id);

    // @Select("select * from emp where name like concat('%',#{name},'%') and gender = #{gender} and entrydate between #{begin} and #{end} order by update_time desc")
    public List<Emp> selectByCondition(String name, Short gender, LocalDate begin, LocalDate end);

    // 插入数据
    public void update2(Emp emp);

    // 批量删除数据
    public void deleteByIds(List<Integer> ids);
}
