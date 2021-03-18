package com.iotmars.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author: xsh
 * @date: 2021/3/17 15:42
 */
public class CASDemo {


    public static void main(String[] args) {
       /* AtomicInteger atomicInteger = new AtomicInteger(2020);

        // 比较并交换
        // 如果我期望的值达到了,那么就更新,否则不更新
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());


        System.out.println(atomicInteger.compareAndSet(2020, 6666));
        System.out.println(atomicInteger.get());*/

        AtomicStampedReference<Integer> atomicStampedReference =
                new AtomicStampedReference<>(1,1);


        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();

            System.out.println("a1=>"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicStampedReference
                    .compareAndSet(1, 2,
                            atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));

            System.out.println("a2=>"+atomicStampedReference.getStamp());


            System.out.println(atomicStampedReference
                    .compareAndSet(2, 1,
                            atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));

            System.out.println("a3=>"+atomicStampedReference.getStamp());


        },"A").start();


        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("b1=>"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicStampedReference
                    .compareAndSet(1, 6,
                            atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));

            System.out.println("b2=>"+atomicStampedReference.getStamp());


        },"B").start();


    }




}
