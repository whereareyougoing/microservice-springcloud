package com.demo.hello.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 宋艾衡
 * 2019/7/22 19:00
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String address;
}
