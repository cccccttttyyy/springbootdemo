package com.tsrain.learning.job.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

@Service
public class AsyncService {
    @Async
    public void sendA() throws Exception {
        System.out.println("send A");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(1000);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));
    }

    @Async
    public void sendB() throws Exception {
        System.out.println("send B");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));
    }

    public static Random random = new Random();

    @Async
    public Future<String> sendC() throws Exception {
        System.out.println("send C");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(2000);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));
        return new AsyncResult<String>("success");
    }

    @Async
    public Future<String> sendD() throws Exception {
        System.out.println("send D");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));
        return new AsyncResult<String>("success");
    }
}
