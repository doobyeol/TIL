package com.study.thread;

//1. 아래 항목을 구현하세요.
//        number 변수를 1 증가시키는 메소드를 만들고 동기화 처리하세요.
//        Thread 10개를 만들고 쓰레드가 위에서 만든 메소드를 실행하세요.
public class Practice01 extends Thread{
    public static int number = 0;

    @Override
    public void run() {
        Practice01.increase();
    }

    public static void main(String[] args) throws Exception {
        // TODO
        for (int i = 0 ; i < 10 ; i ++) {
            Practice01 thread = new Practice01();
            thread.start();
        }

        Thread.sleep(2000);
        System.out.println("number: " + number);
    }

    public static synchronized void increase() {
        number++;
    }
}