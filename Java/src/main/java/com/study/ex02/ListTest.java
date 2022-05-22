package com.study.ex02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        // map보다 list가 많이 쓰임 
        // arrayList가 많이 쓰임

        // 순차적인 추가 삭제는 빠름
        List<String> arrayList = new ArrayList<>();
        
        // 비순차적인 수정 삭제는 빠름
        List<String> linkedList = new LinkedList<>();

        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("D");
        arrayList.add("C");
        arrayList.add("B");

        for (String x : arrayList) {
            // 정렬 x, 중복 o
            System.out.println(x);
        }

        Collections.sort(arrayList);
        System.out.println(arrayList);

        System.out.println("=========================");

        linkedList.add("B");
        linkedList.add("A");
        linkedList.add("D");
        linkedList.add("C");
        linkedList.add("B");

        for (String x : linkedList) {
            // 정렬 x, 중복 o
            System.out.println(x);
        }

    }
}
