package com.iotmars.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 懒汉式单例
 * 道高一尺魔高一丈
 * @author: xsh
 * @date: 2021/3/17 13:33
 */
public class LazyMan {

    private static boolean qingjiang = false;

    private LazyMan () {
        synchronized (LazyMan.class) {

            if (qingjiang == false) {
                qingjiang = true;
            } else {
                throw new RuntimeException("不要试图使用反射");
            }
        }

        System.out.println(Thread.currentThread().getName()+"ok");
    }


    private volatile static LazyMan lazyMan;

    // 双重检测锁模式的 懒汉式单例 DCL 懒汉式
    public static LazyMan getInstance() {
        // 加锁
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();  // 不是一个原子性操作
                    /**
                     * 1、 分配内存空间
                     * 2、 执行构造方法，初始化对象
                     * 3、 把这个对象指向这个空间
                     */

                }
            }
        }
        return lazyMan;
    }


   /* // 单线程并发
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->LazyMan.getInstance()).start();
        }
    }*/

    // 反射
    public static void main(String[] args) throws Exception {

        Field qingjiang = LazyMan.class.getDeclaredField("qingjiang");

        qingjiang.setAccessible(true);


//        LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan instance1 = declaredConstructor.newInstance();
        qingjiang.set(instance1,false);

        LazyMan instance2 = declaredConstructor.newInstance();

//        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());


    }




}
