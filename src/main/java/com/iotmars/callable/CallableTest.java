package com.iotmars.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xsh
 * @date 2020-08-13 14:19
 **/
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();

        FutureTask<String> futureTask = new FutureTask(myThread);


        new Thread(
                futureTask,"A")
                .start();
        String s = futureTask.get();
        System.out.println(s);


    }

}


class MyThread implements Callable<String>{

    @Override
    public String call() {
        return "123";
    }
}