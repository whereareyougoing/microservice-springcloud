package com.demo.hello.repository;

import com.demo.hello.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 宋艾衡
 * 2019/7/22 21:27
 */
@Mapper
public interface UserMapper {


    @Select("select * from tb_user")
    List<User> getAllUser();

    @Delete("delete from tb_user where id = #{id}")
    void delUser(Integer id);

}
