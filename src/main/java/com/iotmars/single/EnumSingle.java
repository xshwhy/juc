package com.iotmars.single;

import org.springframework.http.ResponseEntity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * enum 是一个什么?本身也是一个class类
 *
 * @author: xsh
 * @date: 2021/3/17 15:20
 */
public enum EnumSingle {


    INSTANCE;

    public EnumSingle getInstance() {
        return INSTANCE;
    }
}

class Test {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        EnumSingle ins1 = EnumSingle.INSTANCE;
        EnumSingle ins2 = EnumSingle.INSTANCE;

        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);

        EnumSingle enumSingle = declaredConstructor.newInstance();




        System.out.println(ins1.hashCode());
        System.out.println(ins2.hashCode());
        System.out.println(enumSingle.hashCode());


    }

}