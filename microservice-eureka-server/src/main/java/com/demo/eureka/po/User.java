package com.demo.eureka.po;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 宋艾衡
 * @date 2019/5/23 10:16
 * @desc
 */

@ToString
public class User implements Serializable {


    private static final long serialVersionUID = -8934004877955335713L;

    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String address;


}
