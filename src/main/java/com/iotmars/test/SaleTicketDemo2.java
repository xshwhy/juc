package com.iotmars.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基本卖票
 * 真正的多线程开发,公司开发
 * 线程就是一个单独的资源类,没有任何附属的操作
 * 属性  方法
 * @author xsh
 * @date 2020-08-12 10:08
 **/
public class SaleTicketDemo2 {

    public static void main(String[] args) {
        // 并发:多线程操作同一个资源类,把资源类丢入线程

        Ticket2 ticket = new Ticket2();



        new Thread(()->{ for (int i = 0; i < 40; i++)  ticket.sale();},"A").start();

        new Thread(()->{ for (int i = 0; i < 40; i++)  ticket.sale(); },"B").start();

        new Thread(()->{ for (int i = 0; i < 40; i++)  ticket.sale(); },"C").start();


    }

}


/**
 * oop 资源类
 * lock 三步
 * new
 * 加锁
 * 解锁
 */
class Ticket2{
    /**
     * 属性
     */
    private int number = 30;

    Lock lock = new ReentrantLock();

    /**
     * 卖票的方式
     *
     */
    public  void sale() {
        // 加锁
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName()+"卖出"
                        + (number--)+"票,剩余:"+number);
            }
        } finally {
            lock.unlock();
        }
    }


}
