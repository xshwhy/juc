package com.iotmars.add;

import java.util.concurrent.CountDownLatch;

/**
 * @author xsh
 * @date 2020-08-13 17:08
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        // 倒计时 总数是6
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        // 等待计数器规0
        countDownLatch.await();

        // -1
        System.out.println("111");


    }


}
