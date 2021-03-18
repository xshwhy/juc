package com.iotmars.test;

import com.sun.scenario.effect.impl.prism.ps.PPSBlend_MULTIPLYPeer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: xsh
 * @date: 2021/3/17 11:26
 */
public class JMMDemo2 {
    
//    private  static int num = 0;
    private  static AtomicInteger num = new AtomicInteger();

    public static void add() {
        num.getAndIncrement();  // 不是一个原子性操作
    }
    

    public static void main(String[] args) {

        // 理论上两万
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }


        System.out.println(Thread.currentThread().getName()+":"+num);
        
        
    }
    
}
