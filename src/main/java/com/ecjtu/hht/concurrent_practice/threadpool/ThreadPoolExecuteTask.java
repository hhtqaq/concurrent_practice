package com.ecjtu.hht.concurrent_practice.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


/**
 * @author hht
 * @date 2019/9/2 20:05
 */
@Slf4j
@Component
public class ThreadPoolExecuteTask {
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private List<Integer> list = new ArrayList<>();

    @PostConstruct
    public void showConfig() {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        log.error("线程池维护线程的最少数量:" + threadPoolTaskExecutor.getCorePoolSize());
        log.error("线程池维护线程的最大数量:" + threadPoolTaskExecutor.getMaxPoolSize());
        log.error("允许的空闲时间:" + threadPoolTaskExecutor.getKeepAliveSeconds());
        long startTime = System.currentTimeMillis();
        execute();
        long endTime = System.currentTimeMillis();
        System.out.println("花费时间:" + (endTime - startTime));
    }

    //执行任务
    public void execute() {

        list.forEach(a ->
        {
            threadPoolTaskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(a);
                }
            });
        });

    }
}
