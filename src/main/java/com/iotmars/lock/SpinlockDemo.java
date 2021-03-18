package com.iotmars.lock;

import com.iotmars.pc.A;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 *
 * @author: xsh
 * @date: 2021/3/17 16:52
 */
public class SpinlockDemo {

    // int 0
    // Thread null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    // 加锁
    public void myLock() {

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "--=myLock");

        // 自旋锁
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }


    // 解锁
    public void myUnLock() {

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "--=myUnLock");
        atomicReference.compareAndSet(thread, null);
        }






}
