package com.demo.eureka.service.user.impl;

import com.demo.eureka.common.Result;
import com.demo.eureka.mapper.UserMapper;
import com.demo.eureka.po.User;
import com.demo.eureka.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 宋艾衡
 * @date 2019/5/23 13:29
 * @desc
 */

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;


    @Override
    @Cacheable(value = "UserCache", key = "'user.getAllUsers'")
    public Result<List<User>> getAllUser() {

        Result<List<User>> result = new Result<>();

        List<User> list = userMapper.getAllUsers();

        result.setData(list);
        result.setSuccess(true);
        result.setCode("1");
        result.setMessage("成功");

        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = "UserCache", key = "'user.getAllUser'")
    public void delUser(Integer id) {

        userMapper.delUser(id);

    }
}
