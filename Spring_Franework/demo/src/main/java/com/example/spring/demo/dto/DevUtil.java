package com.example.spring.demo.dto;


import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass // static 메서드들에서 정적인 로직을 돌려줌. 날짜변환 ,숫자변환등
// 상속을 더 받을 수 없음.
public class DevUtil {

    public void printLog(){
        System.out.println(LocalDateTime.of(2021,7,21,12,1));
    }

    public void printNow(){
        System.out.println(LocalDateTime.now());
    }
}
