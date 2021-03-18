package com.iotmars.pool;

import java.util.concurrent.*;

/**
 * 使用线程池,使用线程池创建线程
 *
 * new ThreadPoolExecutor.AbortPolicy() 银行满了,还有人进来,不处理这个人的,抛出异常
 * new ThreadPoolExecutor.CallerRunsPolicy()  哪来的去哪里
 * new ThreadPoolExecutor.DiscardPolicy() 队列满了,丢掉任务,不会抛出异常
 * new ThreadPoolExecutor.DiscardOldestPolicy() 队列满了,尝试跟最早的竞争,失败gg也不会抛出异常
 * @author xsh
 * @date 2020-08-14 13:34
 **/
public class Demo1 {

    public static void main(String[] args) {
        // 单个线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // 创建一个固定的线程池的大小
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // 可伸缩的,遇强则强,遇弱则弱
//        ExecutorService threadPool =Executors.newCachedThreadPool();


        ExecutorService threadPool =
                new ThreadPoolExecutor(2,
                        5,
                        3,
                        TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(3),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.DiscardOldestPolicy()
                );




        try {
            // 最大承载 Deque + max
            for (int i = 0; i <= 100; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"ok");
                });


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }





    }

}
