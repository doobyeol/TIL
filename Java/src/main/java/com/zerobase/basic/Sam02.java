package com.zerobase.basic;

public class Sam02 {
    public static void main(String[] args) {
        // 2진수 보수
        int i1      = 0b0000_0000_0000_0000_0000_0000_0000_1100;
        int i1_1    = 0b1111_1111_1111_1111_1111_1111_1111_0011; // i1에 대한 1의 보수
        int i1_2    = i1_1 + 1; // i1에 대한 2의 보수 => i1에 대한 1의 보수 + 1
        int i2      = 0b1111_1111_1111_1111_1111_1111_1111_0100; // -12, i1에 대한 2의 보수
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println(i1 + i2);
    }
}
