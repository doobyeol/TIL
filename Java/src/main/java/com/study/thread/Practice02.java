package com.study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 1번에서 Thread 대신 ExecutorService 를 사용해 구현하세요.
public class Practice02 {
    public static int number = 0;

    public static void main(String[] args) throws Exception {
        // TODO
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0 ; i < 10 ; i ++) {
            executor.submit(() -> {
                System.out.println("current number: " + number);
                number ++;
                System.out.println(Thread.currentThread().getName());
            });
        }

        System.out.println("number: " + number);
    }
}
