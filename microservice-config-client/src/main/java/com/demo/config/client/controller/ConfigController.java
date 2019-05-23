package com.demo.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 宋艾衡
 * @date 2019/5/23 18:28
 * @desc
 */

@RestController
public class ConfigController {


    @Value("${clientParam}")
    private String clientParam;

    @RequestMapping("/clientParam")
    public String clientParam(){
        return this.clientParam;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }


}
