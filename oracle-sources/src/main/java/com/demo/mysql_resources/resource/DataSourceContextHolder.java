package com.demo.mysql_resources.resource;

import com.demo.mysql_resources.common.DSConfig;

/**
 * @author 宋艾衡
 * @date 2019/6/24 15:21
 * @desc
 */
public class DataSourceContextHolder {
    public static final String DEFAULT_DS = DSConfig.DB_MASTER;

    private static final ThreadLocal<String> DS_HOLDER = new ThreadLocal<>();

    public static void setDS(String dbType) { DS_HOLDER.set(dbType); }

    public static String getDS() { return (DS_HOLDER.get()); }

    public static void clearDS() {
        DS_HOLDER.remove();
    }
}
