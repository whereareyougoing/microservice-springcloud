package com.demo.mysql_sources.datasource;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author 宋艾衡
 * @date 2019/6/25 11:00
 * @desc
 */
@Aspect
@Component
public class DataSourceAop {
    @Before("execution(* com.mzd.multipledatasources.service..*.test01*(..))")
    public void setDataSource2test01() {
        System.err.println("test01业务");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.TEST01);
    }

    @Before("execution(* com.mzd.multipledatasources.service..*.test02*(..))")
    public void setDataSource2test02() {
        System.err.println("test02业务");
        DataSourceType.setDataBaseType(DataSourceType.DataBaseType.TEST02);
    }
}
