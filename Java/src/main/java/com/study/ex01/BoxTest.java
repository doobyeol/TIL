package com.study.ex01;

public class BoxTest {

    public static void main(String[] args) {
//        Box b1 = new Box();
//        b1.setBox("두벼리");
//
//        String name = (String) b1.getData();
//        System.out.println(name);
//
//        BoxIntegger b2 = new BoxIntegger();
//        b2.setBox(26);
//        Integer age = b2.getData();
//        System.out.println(age);

        //Integer count = b1.getData();
        //System.out.println(count);

//        double weight = 75.12;
        // 형을 새로 만들꺼야 계속 ? ..

        Box<String> b1 = new Box<String>();
        b1.setData("두벼리");

        String name = b1.getData();
        System.out.println(name);

        Box<Integer> b2 = new Box<Integer>();
        b2.setData(26);
        Integer age = b2.getData();
        System.out.println(age);

    }
}