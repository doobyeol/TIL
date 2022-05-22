package com.study.ex02;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        hashSet.add("4");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add("1");
        hashSet.add("4");

        Iterator<String> hashIterator = hashSet.iterator();
        // for문 사용하므로 iterator는 잘 안쓰임
        while (hashIterator.hasNext()) {
            // 정렬 o, 중복 x
            System.out.println(hashIterator.next());
        }

        System.out.println("----------------------------");

        linkedHashSet.add("4");
        linkedHashSet.add("2");
        linkedHashSet.add("3");
        linkedHashSet.add("1");
        linkedHashSet.add("4");

        Iterator<String> linkedIterator = linkedHashSet.iterator();

        while (linkedIterator.hasNext()) {
            // 정렬 x 넣는 순서대로, 양방향의 데이터를 참조하는 형식, 중복 x
            System.out.println(linkedIterator.next());
        }

        System.out.println("----------------------------");

        treeSet.add("4");
        treeSet.add("2");
        treeSet.add("3");
        treeSet.add("1");
        treeSet.add("4");

        Iterator<String> treeIterator = treeSet.iterator();

        while (treeIterator.hasNext()) {
            // 정렬 o, 중복 x
            System.out.println(treeIterator.next());
        }

    }
}
