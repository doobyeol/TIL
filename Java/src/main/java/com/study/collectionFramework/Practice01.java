package com.study.collectionFramework;

import java.util.ArrayList;
import java.util.List;

// 1. 다음 List 중 "abc" 의 index 를 출력하는 코드를 작성하세요.
public class Practice01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("person");
        list.add("dog");
        list.add("cat");
        list.add("abc");
        list.add("god");

        // TODO
        System.out.println(list.indexOf("abc"));
    }
}
