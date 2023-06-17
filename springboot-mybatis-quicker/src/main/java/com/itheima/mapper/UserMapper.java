package com.itheima.mapper;


import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // 底层通过动态代理给当前接口生成代理对象,把代理对象放到IOC容器中
public interface UserMapper {

    @Select("select * from user")
    public List<User> selectAll();
}
