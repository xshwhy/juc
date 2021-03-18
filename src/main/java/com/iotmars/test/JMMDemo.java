package com.iotmars.test;

import java.util.concurrent.TimeUnit;

/**
 * @author: xsh
 * @date: 2021/3/17 11:14
 */
public class JMMDemo {

    private static volatile int num = 0;

    public static void main(String[] args) {


        new Thread(()->{
            while (num == 0) {

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        num = 1;
        System.out.println(num);


    }


}
