package com.demo.mysql_resources.annonation;

import com.demo.mysql_resources.config.MybatisConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 宋艾衡
 * @date 2019/6/24 14:37
 * @desc
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MybatisConfig.class)
public @interface EnableMybatis {
}
