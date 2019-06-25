package com.demo.mysql_sources.datasource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 宋艾衡
 * @date 2019/6/25 10:57
 * @desc
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType.DataBaseType dataBaseType = DataSourceType.getDataBaseType();
        return dataBaseType;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}

