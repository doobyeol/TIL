package com.zerobase.basic;

public class Sam01 {
    public static void main(String[] args) {
        // int -> 32bit
        // 2진수 -> 00000000_00000000_00000000_00000000
        // 16진수 -> ff_ff_ff_ff
        
        int i1 = 10;        // 10진수
        int i2 = 0b10;      // 2진수
        int i3 = 0x10;      // 16진수
        int i4 = 010;       // 8진수

        System.out.println("i1 = " + i1);
        System.out.println("i1 = " + i2);
        System.out.println("i1 = " + i3);
        System.out.println("i1 = " + i4);
        
    }
}
