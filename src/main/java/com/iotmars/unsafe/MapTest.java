package com.iotmars.unsafe;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xsh
 * @date 2020-08-13 9:44
 **/
public class MapTest {

    public static void main(String[] args) {

//        Map<String, Object> map = new HashMap<>(16);
//        Map<String, Object> map = Collections.synchronizedMap(new HashMap<>(16));
        Map<String, Object> map = new ConcurrentHashMap(16);


        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),
                        UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();


        }


    }

}
