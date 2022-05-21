package com.study.ex01;

public class BoxTest2 {

    public static void main(String[] args) {
        Box2<String> b1 = new Box2<String>();
        b1.setData("두벼리", "여자");

        String data = b1.getData();
        String gender = b1.getGender();

        System.out.println("이름 " + data + " , 성별 : " + gender);
    }
}