package com.iotmars.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁,关于锁的八个问题
 * 1 标准情况下 两个线程先打印 发短信还是 打电话 ? 1/ 发短信 2/ 打电话
 * 2 sendSms 延迟4秒，两个线程先打印 发短信还是 打电话 ? 1/ 发短信 2/ 打电话
 * @author xsh
 * @date 2020-08-12 16:31
 **/
public class Test1 {

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()-> phone.sendSms(),"A").start();

        // 捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        },"B").start();


    }



}

class Phone{

    /**
     * synchronized 锁的对象是方法的调用者
     * 两个方法用的是同一个,谁先拿到谁执行
     */
    public synchronized void sendSms() {
        System.out.println("sendSms");
    }

    public synchronized void call() {
        System.out.println("call");
    }


}
