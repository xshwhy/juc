package com.iotmars.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author xsh
 * @date 2020-08-12 17:08
 **/
public class Test4 {
    public static void main(String[] args) {
        // 两个对象的Class模板只有一个
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();

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

class Phone4{

    /**
     * synchronized 锁的对象是方法的调用者
     * 两个方法用的是同一个,谁先拿到谁执行
     * static 静态方法
     * 类一加载就有了！Class模板 锁的Class
     */
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    // 普通同步
    public synchronized void call() {
        System.out.println("call");
    }




}
