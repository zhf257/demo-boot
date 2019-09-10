package com.siukee.demo.annot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {

    private static final Logger logger = LoggerFactory.getLogger(AsyncTask.class);

    @Async
    public void doAsyncWork() {
        long t1 = System.currentTimeMillis();

        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e) {
        }

        long t2 = System.currentTimeMillis();
        logger.info("async task execute in {} ms", t2 - t1);
    }
}