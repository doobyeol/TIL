package com.study;

import java.util.Scanner;

/** 2. 카페에 필요한 속성과 기능을 만들어보세요.
 * 속성
     * 메뉴(String 타입의 배열, 배열 크기는 5)
     * 직원 상태(제조 중/대기중)
 * 생성자
     * 메뉴 속성에 커피이름 5개 세팅
 * 기능
     * 메뉴 모두 출력
     * 주문
         * 상태를 "제조 중"으로 변경
         * 상태가 "제조 중"일때는 "잠시 기다려주세요" 출력
     * 제조 완료
         * 상태를 "대기중"으로 변경
 */
public class Cafe {
    private String [] menuList = new String[5];
    private String status = "대기중";

    public Cafe() {
        menuList[0] = "아메리카노";
        menuList[1] = "카푸치노";
        menuList[2] = "바닐라라떼";
        menuList[3] = "콜드브루";
        menuList[4] = "마자그란";
    }

    public void showMenuList() {
        System.out.println("========= 메뉴판 =========");
        for (String menu : menuList) {
            System.out.println(menu);
        }
        System.out.println("=========================");
    }

    public void orderStart () {
        if (status.equals("제조중")) {
            System.out.println("잠시 기다려주세요");
        }
        status = "제조중";
    }

    public void orderEnd (String menu) {
        System.out.println(menu + " 나왔습니다~");
        status = "대기중";
    }

    public static void main(String[] args) {

        Cafe cafe = new Cafe();
        Scanner scanner = new Scanner(System.in);
        cafe.showMenuList();

        while (true) {
            System.out.println("메뉴를 선택해주세요.");
            String menu = scanner.next();

            cafe.orderStart();
            cafe.orderEnd(menu);
            System.out.println();
        }

    }
}
