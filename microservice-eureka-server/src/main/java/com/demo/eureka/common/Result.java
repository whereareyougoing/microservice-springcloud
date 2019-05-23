package com.demo.eureka.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 宋艾衡
 * @date 2019/5/23 13:24
 * @desc
 */
public class Result<T> implements Serializable {

    @Getter
    @Setter
    private boolean success;
    @Getter
    @Setter
    private String code;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private T data;


    public Result() {
    }

    public Result(boolean success) {
        this.success = success;
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Result(boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }


}
