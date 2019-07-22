package com.demo.hello.service;

import com.demo.hello.pojo.User;

import java.util.List;

/**
 * 宋艾衡
 * 2019/7/22 21:30
 */
public interface UserService {

    List<User> getAllUser();
    void delUser(Integer id);

}
