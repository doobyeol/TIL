package com.study;

import java.util.Scanner;

/** 객체와 클래스 연습
 * 1. 엘레베이터에 필요한 속성과 기능을 만들어보세요.
 * */
public class Elevator {
    static int thisFloor = 1;
    static boolean isOpen = true;

    public static void closeDoor() {
        if (isOpen) {
            System.out.println("문이 닫혔습니다");
            isOpen = false;
        }
    }

    public static void openDoor() {
        if (!isOpen) {
            System.out.println("문이 열렸습니다");
            isOpen = true;
        }
    }

    public static void movingFloor(int toFloor) {
        if (isOpen) {
            // 이 부분이 필요한 이유는 앨리베이터 문이 수동이라서 그런가 .. ?
            System.out.println("문이 열려있습니다");
            return;
        }
        if (thisFloor < toFloor) {
            System.out.println("올라갑니다");
        }else if (thisFloor > toFloor) {
            System.out.println("내려갑니다");
        }
        thisFloor = toFloor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("현재 층수 : " + thisFloor);
            System.out.print("목적지 층수 : ");
            int toFloor = scanner.nextInt();
            System.out.println("1. 문닫힘 | 2. 문열림");
            int num = scanner.nextInt();

            if (num == 1) {
                closeDoor();
            } else if (num == 2) {
                openDoor();
            }
            movingFloor(toFloor);
        }
    }

}
