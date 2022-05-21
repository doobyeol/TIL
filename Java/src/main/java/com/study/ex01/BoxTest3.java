package com.study.ex01;

public class BoxTest3 {

    public static void main(String[] args) {
        Box3<String, Integer> b1 = new Box3();
        b1.setData("두벼리", 28);

        String data = b1.getData();
        Integer age = b1.getAge();

        System.out.println("이름 " + data + " , 나이 : " + age);
    }
}