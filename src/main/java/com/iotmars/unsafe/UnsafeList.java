package com.iotmars.unsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xsh
 * @date 2020-08-12 19:07
 **/
public class UnsafeList {
    public static void main(String[] args) {

        List<String> list = new CopyOnWriteArrayList<>();

//        List<Object> objects = Collections.synchronizedList(new ArrayList<>());

        // CopyOnWrite 写入时复制 COW 计算机程序设计领域的一种优化策略
        // 多个线程调用的时候，list，读取的时候，固定的，写入(覆盖)
        // 在写入的时候避免覆盖,造成数据问题
        // 读写分离


        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
//                System.out.println(list);
                list.forEach(System.out::println);
            },String.valueOf(i)).start();
        }





    }
}
