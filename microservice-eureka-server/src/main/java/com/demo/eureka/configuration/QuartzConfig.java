package com.demo.eureka.configuration;

import com.demo.eureka.service.TestQuartz;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;

/**
 * @author 宋艾衡
 * @date 2019/4/4 17:27
 * @desc
 */

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail teatQuartzDetail() {

        return JobBuilder.newJob(TestQuartz.class).withIdentity("testQuartz").storeDurably().build();

    }

    @Bean
    public Trigger testQuartzTrigger() {

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10)  //设置时间周期单位秒
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())

                .withIdentity("testQuartz")
                .withSchedule(scheduleBuilder)
                .build();

    }
}
