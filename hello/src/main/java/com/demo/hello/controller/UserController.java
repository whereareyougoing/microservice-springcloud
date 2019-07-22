package com.demo.hello.controller;

import com.demo.hello.pojo.User;
import com.demo.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 宋艾衡
 * 2019/7/22 21:33
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userList")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping("/delete/{id}")
    public void delUser(@PathVariable Integer id){
        userService.delUser(id);
    }

}
