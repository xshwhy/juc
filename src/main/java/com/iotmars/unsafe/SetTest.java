package com.iotmars.unsafe;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author xsh
 * @date 2020-08-13 9:20
 **/
public class SetTest {


    public static void main(String[] args) {

//        Set<Object> set = new HashSet<>();
//        Set<Object> set = Collections.synchronizedSet(new HashSet<>());
        Set<Object> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 30; i++) {

            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();


        }


    }


}
