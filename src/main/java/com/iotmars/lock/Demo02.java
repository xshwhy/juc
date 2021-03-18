package com.iotmars.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: xsh
 * @date: 2021/3/17 16:43
 */
public class Demo02 {

    public static void main(String[] args) {

        Phone2 phone = new Phone2();

        new Thread(()->{phone.sms();},"A").start();
        new Thread(()->{phone.sms();},"B").start();


    }


}


class Phone2 {

    Lock lock = new ReentrantLock();


    public void sms() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"sms");
            call();
        } finally {
            lock.unlock();
        }

    }

    public  void call() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"call");
        } finally {
            lock.unlock();
        }
    }


}
