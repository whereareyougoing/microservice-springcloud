package com.demo.mysql_resources;

import com.demo.mysql_resources.annonation.EnableMybatis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableMybatis
@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OracleSourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(OracleSourcesApplication.class, args);
    }

}
