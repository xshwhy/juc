package com.iotmars.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: xsh
 * @date: 2021/3/18 8:51
 */
public class SpinlockTest {


    public static void main(String[] args) {
        /*ReentrantLock lock = new ReentrantLock();

        lock.lock();

        lock.unlock();*/

        // 底层使用cas
        SpinlockDemo lock = new SpinlockDemo();

        new Thread(() -> {
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        }, "A").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        }, "B").start();



      /*  lock.myLock();
        lock.myUnLock();*/


    }

}
