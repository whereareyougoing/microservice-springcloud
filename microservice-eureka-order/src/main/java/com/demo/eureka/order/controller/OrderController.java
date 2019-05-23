package com.demo.eureka.order.controller;

import com.alibaba.fastjson.JSON;
import com.demo.eureka.order.po.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 宋艾衡
 * @date 2019/5/23 16:35
 * @desc
 */

@RestController
public class OrderController {


    @GetMapping("/order/{id}")
    public String findOrderById(@PathVariable Integer id){
        Order order = new Order();
        order.setId(123);
        order.setPrice(123d);
        order.setReceiverName("张三");
        order.setReceiverAddress("北京世井上");
        order.setReceiverPhone("13212345678");

        String json = JSON.toJSONString(order);
        return json;
    }


}
