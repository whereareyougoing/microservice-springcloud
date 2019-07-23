package com.demo.hello.service.impl;

import com.demo.hello.pojo.User;
import com.demo.hello.repository.UserMapper;
import com.demo.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 宋艾衡
 * 2019/7/22 21:30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "UserCache", key = "'user.getAllUsers'")
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    @CacheEvict(value="UserCache",key="'user.getAllUsers'")
    public void delUser(Integer id) {
        userMapper.delUser(id);
    }
}
