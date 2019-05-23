package com.demo.eureka.mapper;

import com.demo.eureka.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 宋艾衡
 * @date 2019/5/23 10:28
 * @desc
 */

@Mapper
public interface UserMapper {

    /**
     * @return
     */
    List<User> getAllUsers();

    /**
     * @param id
     */
    void delUser(Integer id);
}
