package com.iotmars.single;

/**
 * 静态内部类
 *
 * @author: xsh
 * @date: 2021/3/17 15:07
 */
public class Holder {

    private Holder() {

    }

    public static Holder getInstance() {
        return InnerClass.HOLDER;
    }

    private static class InnerClass {
        private static final Holder HOLDER = new Holder();
    }


}
