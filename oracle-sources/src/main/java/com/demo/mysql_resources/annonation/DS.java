package com.demo.mysql_resources.annonation;

import com.demo.mysql_resources.common.DSConfig;

import java.lang.annotation.*;

/**
 * @author 宋艾衡
 * @date 2019/6/24 15:16
 * @desc
 */

@Target
        (
                ElementType
                        .
                        METHOD
        )
@Retention
        (
                RetentionPolicy
                        .
                        RUNTIME
        )
@Documented
public @interface DS {


    String
            value
            ()

            default

            DSConfig
                    .
                    DB_MASTER
            ;
}
