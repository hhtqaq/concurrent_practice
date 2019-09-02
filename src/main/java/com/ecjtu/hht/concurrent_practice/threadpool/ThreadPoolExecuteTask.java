package com.ecjtu.hht.concurrent_practice.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PostConstruct;


/**
 * @author hht
 * @date 2019/9/2 20:05
 */
@Slf4j
public class ThreadPoolExecuteTask {
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @PostConstruct
    public void showConfig() {
        log.error("线程池维护线程的最少数量:" + threadPoolTaskExecutor.getCorePoolSize());
        log.error("#线程池维护线程的最大数量:" + threadPoolTaskExecutor.getMaxPoolSize());
        log.error("允许的空闲时间:" + threadPoolTaskExecutor.getKeepAliveSeconds());
    }

    //执行任务
    public void execute() {
        threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
