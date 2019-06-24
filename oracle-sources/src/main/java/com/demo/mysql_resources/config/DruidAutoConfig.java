package com.demo.mysql_resources.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.WebStatFilter;
import com.demo.mysql_resources.common.DSConfig;
import com.demo.mysql_resources.common.properties.DruidMasterProperties;
import com.demo.mysql_resources.common.properties.DruidSlaveProperties;
import com.demo.mysql_resources.monitor.DruidStatViewServlet;
import com.sun.org.apache.regexp.internal.REUtil;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;


/**
 * @author 宋艾衡
 * @date 2019/6/24 14:49
 * @desc
 */

@Configuration
@Import({PropertiesConfig.class})
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnProperty(prefix = DSConfig.DS_PREFIX, value = DSConfig.DS_ACTIVE, havingValue = DSConfig.DRUID)
public class DruidAutoConfig implements DSConfig {


//    private Logger logger = LoggerUtils.getLogger(this);

//    @Bean(name = DB_MASTER, initMethod = "init", destroyMethod = "close")
    public DataSource dataSourceMaster(DruidMasterProperties masterProperties) throws SQLException {
//        logger.debug("master properties: {}", masterProperties.toString());
//        DruidDataSource dds = new DruidDataSource();
//        dds.setDriverClassName(masterProperties.getDriverClassName());
//        dds.setUrl(masterProperties.getUrl());
//        dds.setUsername(masterProperties.getUsername());
//        dds.setPassword(masterProperties.getPassword());
//        dds.setInitialSize(masterProperties.getInitialSize());
//        dds.setMinIdle(masterProperties.getMinIdle());
//        dds.setMaxActive(masterProperties.getMaxActive());
//        dds.setMaxWait(masterProperties.getMaxWait());
//        dds.setTimeBetweenEvictionRunsMillis(masterProperties.getTimeBetweenEvictionRunsMillis());
//        dds.setMinEvictableIdleTimeMillis(masterProperties.getMinEvictableIdleTimeMillis());
//        dds.setValidationQuery(masterProperties.getValidationQuery());
//        dds.setTestOnBorrow(masterProperties.isTestOnBorrow());
//        dds.setTestWhileIdle(masterProperties.isTestWhileIdle());
//        dds.setTestOnReturn(masterProperties.isTestOnReturn());
//        dds.setPoolPreparedStatements(masterProperties.isPoolPreparedStatements());
//        dds.setMaxPoolPreparedStatementPerConnectionSize(masterProperties.getMaxPoolPreparedStatementPerConnectionSize());
//        dds.setFilters(masterProperties.getFilters());
//        return dds;

        return null;

    }

//    @Bean(name = DB_SLAVE, initMethod = "init", destroyMethod = "close")
    public DataSource dataSourceSlave(DruidSlaveProperties slaveProperties) throws SQLException {
//        logger.debug("slave properties: {}", slaveProperties.toString());
//        DruidDataSource dds = new DruidDataSource();
//        dds.setDriverClassName(slaveProperties.getDriverClassName());
//        dds.setUrl(slaveProperties.getUrl());
//        dds.setUsername(slaveProperties.getUsername());
//        dds.setPassword(slaveProperties.getPassword());
//        dds.setInitialSize(slaveProperties.getInitialSize());
//        dds.setMinIdle(slaveProperties.getMinIdle());
//        dds.setMaxActive(slaveProperties.getMaxActive());
//        dds.setMaxWait(slaveProperties.getMaxWait());
//        dds.setTimeBetweenEvictionRunsMillis(slaveProperties.getTimeBetweenEvictionRunsMillis());
//        dds.setMinEvictableIdleTimeMillis(slaveProperties.getMinEvictableIdleTimeMillis());
//        dds.setValidationQuery(slaveProperties.getValidationQuery());
//        dds.setTestOnBorrow(slaveProperties.isTestOnBorrow());
//        dds.setTestWhileIdle(slaveProperties.isTestWhileIdle());
//        dds.setTestOnReturn(slaveProperties.isTestOnReturn());
//        dds.setPoolPreparedStatements(slaveProperties.isPoolPreparedStatements());
//        dds.setMaxPoolPreparedStatementPerConnectionSize(slaveProperties.getMaxPoolPreparedStatementPerConnectionSize());
//        dds.setFilters(slaveProperties.getFilters());
//        return dds;

        return null;

    }

//    @Bean
//    public ServletRegistrationBean druidServletRegistrationBean(EnvConfig env) {
//        String username = env.getStringValue(DSConfig.DRUID_MONITOR_USERNAME);
//        String password = env.getStringValue(DSConfig.DRUID_MONITOR_PASSWORD);
//        return new ServletRegistrationBean(new DruidStatViewServlet(username, password), DSConfig.DRUID_MONITOR_URL);
//    }

    @Bean
    public FilterRegistrationBean druidFilterRegistrationBean() {
        WebStatFilter wsf = new WebStatFilter();FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(wsf);
        filterRegistrationBean.setUrlPatterns(Arrays.asList(DSConfig.DRUID_FILTER_URL));
        filterRegistrationBean.setInitParameters(Collections.singletonMap("exclusions", DSConfig.DRUID_FILTER_EXCLUSIONS));
        return filterRegistrationBean;
    }
}
