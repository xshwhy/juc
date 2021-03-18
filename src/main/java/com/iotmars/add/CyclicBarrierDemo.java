package com.iotmars.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author xsh
 * @date 2020-08-13 17:16
 **/
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,
                ()->{
                    System.out.println("2222");
                });

        for (int i = 0; i <= 7; i++) {
            final int temp = i;
            new Thread(()->{
                System.out.println(111+temp);

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();



        }



    }
}
