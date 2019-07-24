package com.demo.eureka.server1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 宋艾衡
 * 2019/7/24 15:39
 */
@RestController
public class ServerController {



    @GetMapping("/home")
    public String home(){
        return "hello world";
    }

}
