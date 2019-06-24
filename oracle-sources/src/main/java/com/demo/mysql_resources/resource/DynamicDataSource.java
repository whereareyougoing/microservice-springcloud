package com.demo.mysql_resources.resource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * @author 宋艾衡
 * @date 2019/6/24 15:18
 * @desc
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


//    private final Logger logger = LoggerUtils.getLogger(this);

    @Override
    protected Object determineCurrentLookupKey() {
//        logger.debug("当前数据源为{}", DataSourceContextHolder.getDS());
        return DataSourceContextHolder.getDS();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
