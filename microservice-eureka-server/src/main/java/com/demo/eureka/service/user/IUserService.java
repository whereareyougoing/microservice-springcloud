package com.demo.eureka.service.user;

import com.demo.eureka.common.Result;
import com.demo.eureka.po.User;

import java.util.List;

/**
 * @author 宋艾衡
 * @date 2019/5/23 13:22
 * @desc
 */
public interface IUserService {

    Result<List<User>> getAllUser();

    void delUser(Integer id);
}
