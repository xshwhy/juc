package com.iotmars.test;

/**
 * 基本卖票
 * 真正的多线程开发,公司开发
 * 线程就是一个单独的资源类,没有任何附属的操作
 * 属性  方法
 * @author xsh
 * @date 2020-08-12 10:08
 **/
public class SaleTicketDemo1 {

    public static void main(String[] args) {
        // 并发:多线程操作同一个资源类,把资源类丢入线程

        Ticket ticket = new Ticket();



        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
             },"A").start();

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
            ticket.sale();
        } },"B").start();

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
            ticket.sale();
        } },"C").start();


    }

}


/**
 * oop 资源类
 */
class Ticket{
    /**
     * 属性
     */
    private int number = 30;

    /**
     * 卖票的方式
     * synchronized 本质: 队列 锁
     */
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName()+"卖出"
                    + (number--)+"票,剩余:"+number);
        }
    }


}
