package com.demo.mysql_resources.common;

/**
 * @author 宋艾衡
 * @date 2019/6/24 14:39
 * @desc
 */
public interface DSConfig {

    String DS_PREFIX = "spring.datasource";

    String DS_ACTIVE = "active";

    String DB_MASTER = "db-master";

    String DB_SLAVE = "db-slave";

    String DRUID = "druid";

    String DRUID_MONITOR_USERNAME = "spring.druid.username";

    String DRUID_MONITOR_PASSWORD = "spring.druid.password";

    String DRUID_MONITOR_URL = "/druid/*";

    String DRUID_FILTER_EXCLUSIONS = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*";

    String DRUID_FILTER_URL = "/*";

    String BASE_PACKAGES = "com.example.**.mapper";

    String MAPPER_LOCATIONS = "mapper/**/*.xml";
}
