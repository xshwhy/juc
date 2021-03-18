package com.iotmars.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author: xsh
 * @date: 2021/3/18 13:20
 */
public class DeadLockDemo {

    public static void main(String[] args) {
         String lockA = "lockA";

         String lockB = "lockB";


        new Thread(new MyThread(lockA,lockB),"A").start();
        new Thread(new MyThread(lockB,lockA),"A").start();

    }


}


class MyThread implements Runnable {

    private String lockA;

    private String lockB;

    public MyThread(String lockA,String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override

    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName()+"lock"
                    +lockA +"getB"+lockB);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName()+"lock"
                        +lockB +"getA"+lockA);
            }
        }
    }
}