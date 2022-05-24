package com.study.ex03;

public class Ch01 {

    public static void main(String[] args){
        final int number = 0; // 상수

        String leaf = "love";
        // 약어 x , camel

        char[] chars = leaf.toCharArray();
        byte b = 1;
        char c = 'a';
        long l = 8L;
        float f = 0.1f;
        double d = 0.1;
        boolean bool = true;

        // 원시타입 : stack, 참조타입 : heap > gc
        // 형변환

        // 자바의 Primitive Data Type의 바이트 크기와 비트 크기를 출력하는 코드를 구현하시오.
        // byte 1, short 2, int 4, long 8, char 2
        System.out.println("byte \t: " + Byte.BYTES + "(byte) \t" + Byte.SIZE + "(bit) \t" + Byte.MIN_VALUE + "(MIN) \t" + Byte.MAX_VALUE + "(MAX)");

        System.out.println("short \t: " + Short.BYTES + "(byte) \t" + Short.SIZE + "(bit) \t" + Short.MIN_VALUE + "(MIN) \t" + Short.MAX_VALUE + "(MAX)");

        System.out.println("int \t: " + Integer.BYTES + "(byte) \t" + Integer.SIZE + "(bit) \t" + Integer.MIN_VALUE + "(MIN) \t" + Integer.MAX_VALUE + "(MAX)");

        System.out.println("long \t: " + Long.BYTES + "(byte) \t" + Long.SIZE + "(bit) \t" + Long.MIN_VALUE + "(MIN) \t" + Long.MAX_VALUE + "(MAX)");

        System.out.println("char \t: " + Character.BYTES + "(byte) \t" + Character.SIZE + "(bit) \t" + (int)Character.MIN_VALUE + "(MIN) \t" + (int)Character.MAX_VALUE + "(MAX)");

    }
}
