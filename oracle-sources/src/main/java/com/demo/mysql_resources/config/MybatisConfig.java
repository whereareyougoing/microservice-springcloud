package com.demo.mysql_resources.config;

import com.demo.mysql_resources.common.DSConfig;
import com.demo.mysql_resources.resource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 宋艾衡
 * @date 2019/6/24 14:38
 * @desc
 */
@Configuration
@MapperScan(basePackages = DSConfig.BASE_PACKAGES)
public class MybatisConfig implements DSConfig {



    @Primary
    @Bean
    public DynamicDataSource dynamicDataSource(@Qualifier(DB_MASTER) DataSource master, @Qualifier(DB_SLAVE) DataSource slave) {

        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put(DB_MASTER, master);
        dsMap.put(DB_MASTER, slave);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(master);
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;

    }

    @Bean
    public PlatformTransactionManager transactionManager(DynamicDataSource dynamicDataSource) {

        return new DataSourceTransactionManager(dynamicDataSource);

    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dynamicDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dynamicDataSource);
        sessionFactory.setMapperLocations(((ResourcePatternResolver) new PathMatchingResourcePatternResolver()).getResources(DSConfig.MAPPER_LOCATIONS));

        return sessionFactory.getObject();

    }

}
