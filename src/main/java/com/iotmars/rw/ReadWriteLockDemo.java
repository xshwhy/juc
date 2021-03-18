package com.iotmars.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁 写锁 一次只能被一个线程占有
 * 共享锁 多个线程可以同时占有
 * 读读 共存
 * 读 写 不共存
 *  写写 不共存
 * @author xsh
 * @date 2020-08-14 10:38
 **/
public class ReadWriteLockDemo {

    public static void main(String[] args) {

        MyCacheLock myCache = new MyCacheLock();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();

        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();

        }
    }

}


/**
 * 自定义缓存
 */
class MyCache{

    private volatile Map<String,Object> map = new HashMap<>();

    // 存 写
    public void put(String key,Object value) {
        System.out.println(Thread.currentThread().getName()+"写入开始");
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入结束");
    };

    // 取 读
    public void get(String key) {
        System.out.println(Thread.currentThread().getName()+"读开始");
        Object o = map.get(key);

        System.out.println(Thread.currentThread().getName()+"读结束");
    }



}

class MyCacheLock{

    private volatile Map<String,Object> map = new HashMap<>();

    private ReadWriteLock readWriteLock =  new ReentrantReadWriteLock();

    // 存 写
    public void put(String key,Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入开始");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入结束");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    // 取 读
    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读开始");
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读结束");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }



}