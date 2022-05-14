package com.study;

import java.util.Scanner;

public class HomeWork0514 {
    static Scanner scanner = new Scanner(System.in);

    public static void homeWork1(){
        //  1. 1~10까지 홀수의 합을 출력
        System.out.println("#### 1. 1~10까지 홀수의 합 ####");
        int total = 0;
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                total += i;
            }
        }
        System.out.println("total : " + total);
    }

    public static void homeWork2(){
        //  2. 구구단 중 홀수단(3 5 7 9)만 출력
        System.out.println("#### 2. 구구단 중 홀수단(3 5 7 9)만 출력 ####");
        for (int i = 1; i <= 9; i++) {
            if (i % 2 != 0) {
                for (int j = 1; j < 10; j++ ) {
                    System.out.printf("%d * %d = %d %n", i, j, i * j);
                }
                System.out.println();
            }
        }
    }

    public static void homeWork3(){
        //  3. 별 그리기
        //            *
        //           **
        //          ***
        //         ****
        //        *****

        System.out.println("#### 3. 별 그리기 ####");
        for (int i = 0; i < 5; i++) {
            String star = "*";
            for (int j = 0; j < i; j++) {
                star += "*";
            }
            System.out.printf("%5s%n", star);
        }

    }

    public static void homeWork4(){
        //  4. 주어진 변수 kor, eng, mat 의 평균 값이
        //     95 이상이면 "장학생",
        //     94\~90이면 "A학점",
        //     89\~80 이면 "B학점",
        //     79\~70 이면 "C학점",
        //     69이하면 "F학점"을 출력

        System.out.print("kor: ");
        int kor = scanner.nextInt();
        System.out.println();

        System.out.print("eng: ");
        int eng = scanner.nextInt();
        System.out.println();

        System.out.print("mat: ");
        int mat = scanner.nextInt();
        System.out.println();

        int score = (kor + eng + mat) / 3;
        String grade = "";

        if (score >= 95) {
            grade = "장학생";
        } else if(score >= 90) {
            grade = "A학점";
        } else if(score >= 80) {
            grade = "B학점";
        } else if(score >= 70) {
            grade = "C학점";
        } else {
            grade = "F학점";
        }

        System.out.println("결과: " + grade);
    }

    public static void homeWork5(){
        //  5. 입력받은 String 타입 변수 operator의 연산 기호에 따라
        //     입력받은 num1, num2의 사칙연산 결과를 출력
        //     * operator는 "+", "-", "*", "/" 만 허용된다고 가정

        while (true) {
            System.out.print("num1: ");
            int num1 = scanner.nextInt();
            System.out.println();

            System.out.print("num2: ");
            int num2 = scanner.nextInt();
            System.out.println();

            System.out.print("operator: ");
            String operator = scanner.next();
            System.out.println();

            int result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if(num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    result = num1 / num2;
                    break;
                default :
                    System.out.println("연산자는 +, -, *, / 만 허용함");
                    continue;
            }

            System.out.println("결과: " + result);
            break;
        }
    }

    public static void main(String[] args){
        homeWork1();
        homeWork2();
        homeWork3();
        homeWork4();
        homeWork5();
    }

}
