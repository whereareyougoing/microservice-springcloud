package com.demo.pagehelper.Config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author 宋艾衡
 * @date 2019/7/1 10:14
 * @desc
 *
 * 通过自定义配置进行导入
 *
 */

@Configuration
public class MybatisConfig {


//    PageInterceptor  这个是mybatis实现的多数据库分页类，拦截器
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("dialect", "Mysql");
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }


}
