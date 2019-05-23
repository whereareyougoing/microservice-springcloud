package com.demo.eureka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 宋艾衡
 * @date 2019/4/4 16:26
 * @desc spring-task  实现定时任务
 */

@Slf4j
@Component
@Async
public class ScheduledService {


    /**
     * async  多线程支持，每次启动一个定时任务都会启动一个线程
     */


    @Scheduled(cron = "0/5 * * * * *")
    @Async
    public void scheduled() {
        log.info("=====>>>>>使用cron  {}", System.currentTimeMillis());
    }

    @Scheduled(fixedRate = 5000)
    public void scheduled1() {
        log.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
    }

    @Scheduled(fixedDelay = 5000)
    public void scheduled2() {
        log.info("=====>>>>>fixedDelay{}", System.currentTimeMillis());
    }


}
