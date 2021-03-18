package com.iotmars.lock;

/**
 * @author: xsh
 * @date: 2021/3/17 16:43
 */
public class Demo01 {

    public static void main(String[] args) {

        Phone phone = new Phone();

        new Thread(()->{phone.sms();},"A").start();
        new Thread(()->{phone.sms();},"B").start();


    }


}


class Phone {

    public synchronized void sms() {
        System.out.println(Thread.currentThread().getName()+"sms");
        call();
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName()+"call");
    }


}
