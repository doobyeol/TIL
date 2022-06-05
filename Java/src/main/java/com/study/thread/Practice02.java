package com.study.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

// 1번에서 Thread 대신 ExecutorService 를 사용해 구현하세요.
public class Practice02 {
    public static int number = 0;

//    @Override
//    public void run() {
//        Practice02.increase();
//    }

    public static void main(String[] args) throws Exception {
        // TODO
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            final int idx = i;
//            executor.submit(() -> {
//                increase();
//                Thread.sleep(1000);
//                return "끝났어! " + idx;
//            });

            tasks.add(() -> {
                increase();
                Thread.sleep(1000);
                return "끝났어! " + idx;
            });
        }

        List<Future<String>> futureList = executor.invokeAll(tasks);
        futureList.forEach((future) -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

//        executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
        System.out.println("number: " + number);
//        Thread.sleep(2000);
    }

    public static synchronized void increase() {
        number++;
    }
}
