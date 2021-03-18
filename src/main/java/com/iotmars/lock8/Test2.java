package com.iotmars.lock8;

import java.util.concurrent.TimeUnit;

/**
 *
 *  1 sendSms 延迟4秒，两个线程先打印 发短信还是 hello ? 1/hello 2/ 发短信
 *  两个对象，两个同步方法 发短信还是打电话
 *
 *
 * @author xsh
 * @date 2020-08-12 16:53
 **/
public class Test2 {
    public static void main(String[] args) {
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();

        new Thread(()->{
            phone1.sendSms();
        },"A").start();

        // 捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone2.call();
        },"B").start();


    }



}

class Phone2{

    /**
     * synchronized 锁的对象是方法的调用者
     * 两个方法用的是同一个,谁先拿到谁执行
     */
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    public synchronized void call() {
        System.out.println("call");
    }

    /**
     * 没有锁
     */
    public void hello() {
        System.out.println("hello");
    }


}
