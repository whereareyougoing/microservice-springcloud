package com.demo.eureka.controller;

import com.demo.eureka.common.Result;
import com.demo.eureka.po.User;
import com.demo.eureka.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 宋艾衡
 * @date 2019/5/23 13:23
 * @desc
 */

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("getAllUser")
    @ResponseBody
    public Result<List<User>> getAllUser() {
        return iUserService.getAllUser();
    }


    @RequestMapping("delUser")
    @ResponseBody
    public Result<Integer> delUser(Integer id) {
        Result<Integer> result = new Result<>();
        iUserService.delUser(id);
        return result;
    }

}
