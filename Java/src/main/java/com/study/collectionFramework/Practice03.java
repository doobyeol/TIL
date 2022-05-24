package com.study.collectionFramework;

import java.util.LinkedHashMap;
import java.util.Map;

// 3. 주어진 map 의 key 와 value 를 모두 출력하세요.
public class Practice03 {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "홍길동");
        map.put("age", "30");
        map.put("address", "서울");

        // TODO: key=value 형태로 출력
        /*
         * 예)
         * name=홍길동
         * age=30
         * address=서울
         */
        map.forEach((key, value) -> {
            System.out.println(key + "=" + value);
        });
    }
}
