package com.iotmars.single;

/**
 * 饿汉式单例
 *
 * @author: xsh
 * @date: 2021/3/17 13:30
 */
public class Hungry {

    private byte[] data1 = new byte[1024*1024];
    private byte[] data2 = new byte[1024*1024];
    private byte[] data3 = new byte[1024*1024];
    private byte[] data4 = new byte[1024*1024];


    private Hungry() {

    }


    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance() {
        return HUNGRY;
    }







}
