package com.study;

import java.util.Scanner;

/** 객체와 클래스 연습
 * 1. 엘레베이터에 필요한 속성과 기능을 만들어보세요.
 * 속성
     * 현재층수
     * 문 닫힘 여부
 * 기능
 * 문 닫힘
    * 문이 열려있을때만 "닫혔습니다" 출력
 * 문 열림
     * 문이 닫혀있을때만 "열렸습니다" 출력
 * 이동 기능
     * 문이 열려있으면 "문이 열려있습니다"를 출력하고 아무 것도 하지 않는다.
     * 목적지 층수를 매개변수로 받는다.
     * 목적지 층수가 현재 층수보다 높은 층이면 "올라갑니다" 출력
     * 목적지 층수가 현재 층수보다 낮은 층이면 "내려갑니다" 출력
     * 현재 층수를 목적지 층수로 변경
 * */
public class Elevator {
    private int thisFloor = 1;
    private boolean isOpen = true;

    public int getThisFloor() {
        return this.thisFloor;
    }

    public void closeDoor() {
        if (isOpen) {
            System.out.println("문이 닫혔습니다");
            isOpen = false;
        }
    }

    public void openDoor() {
        if (!isOpen) {
            System.out.println("문이 열렸습니다");
            isOpen = true;
        }
    }

    public void moveFloor(int toFloor) {
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

        Elevator elevator = new Elevator();

        while (true) {
            System.out.println("현재 층수 : " + elevator.getThisFloor());
            System.out.print("목적지 층수 : ");
            int toFloor = scanner.nextInt();
            System.out.println("1. 문닫힘 | 2. 문열림");
            int num = scanner.nextInt();

            if (num == 1) {
                elevator.closeDoor();
            } else if (num == 2) {
                elevator.openDoor();
            }
            elevator.moveFloor(toFloor);
        }
    }

}
