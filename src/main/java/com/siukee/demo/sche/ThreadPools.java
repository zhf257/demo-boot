package com.siukee.demo.sche;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

import org.springframework.util.StringUtils;

public class ThreadPools {
	/**
     * 构造调度线程池
     * 
     * @param corePoolSize
     * @param poolName
     * @return
     */
    public static ScheduledThreadPoolExecutor newSchedulingPool(int corePoolSize, String poolName) {

        ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(corePoolSize);

        // 设置变量
        if (!StringUtils.isEmpty(poolName)) {
            threadPoolExecutor.setThreadFactory(new ThreadFactory() {
                
                @Override
                public Thread newThread(Runnable r) {
                    Thread tr = new Thread(r, poolName + r.hashCode());
                    return tr;
                }
            });
        }
        return threadPoolExecutor;
    }
}
