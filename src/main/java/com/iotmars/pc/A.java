package com.iotmars.pc;

/**
 * 线程之间通信问题: 生产者和消费者问题  等待唤醒 , 通知唤醒
 * 线程交替执行 A B 操作统一变量
 *
 * @author xsh
 * @date 2020-08-12 13:08
 **/
public class A {

    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }


}

// 等待 业务 通知
class Data {


    private int number = 0;

    /**
     * +1
     */
    public synchronized void increment() throws InterruptedException {
        while (number != 0 ) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"number=>"+ number);
        //通知线程
        this.notifyAll();
    }

    /**
     * -1
     */
    public synchronized void decrement() throws InterruptedException {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"number=>"+ number);

        //通知线程
        this.notifyAll();
    }

}