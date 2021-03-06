package com.study.ex03;

/**
 * Chapter02 - 연산자(Operator)
 * - 증감연산자: ++, --
 * - 부호연산자: +, -
 * - 비트 연산자: &, |, ~
 * - 논리부정 연산자: !
 * - 사칙 연산자: +, -, *, /
 * - 나머지 연산자: %
 * - 쉬프트 연산자: <<, >>, >>>
 * - 대소 비교연산자: <, >, <=, >=
 * - 등가비교 연산자: ==, !=
 * - 논리 연산자: &&, ||
 * - 삼항 연산자: ? :
 */
public class Ch02 {
    public static void main(String[] args){
        // 2 : 0000 0010
        System.out.println("2 << 3 = " + (2<<3)); // 0001 0000 : 16
        System.out.println("16 >> 3 = " + (16>>3)); // 0000 0010 : 2
        System.out.println("-16 >> 3 = " + (-16>>3)); // 1111 0000 : -16
        System.out.println("-16 >>> 3 = " + (-16>>>3)); // 1111 1110 : -2

        // 15 : 0000 1111
        // 25 : 0001 1001
        System.out.println("15 & 25 = " + (15 & 25)); // 0000 1001 : 9
        System.out.println("15 | 25 = " + (15 | 25)); // 0001 1111 : 31
        System.out.println("15 ^ 25 = " + (15 ^ 25)); // 0001 0110 : 22
        System.out.println("~25 = " + (~25)); // 1110 0110 : 0001 1001 : 0001 1010 : 2 + 8 + 16 : -26
    }
}
