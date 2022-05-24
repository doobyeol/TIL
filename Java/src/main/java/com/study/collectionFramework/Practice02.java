package com.study.collectionFramework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 2. 다음 String[] 의 값 중 Set 을 이용해 중복 제거한 후 모두 출력하세요.
public class Practice02 {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "c", "d", "b", "a"};

        // TODO
        Set hashSet = new HashSet(Arrays.asList(strings));

        // set은 정렬p, 중복x !
        System.out.println(hashSet);
    }
}
