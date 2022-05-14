package com.study;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Chapter03 - 조건문과 반복문
 * - if - else 문
 * - switch 문
 * - for 문
 * - while 문 / do-while 문
 * - break, continue
 */
public class Ch03 {
    public static void main(String[] args){
        String name = "leaf";
        if (name.equals("leaf")) {
            System.out.println("i love " + name);
        } else {
            System.out.println("where is leaf ?");
        }

        String[] happiness = {name,"doobyeol"};
        for (String happy : happiness) {
            System.out.println(happy + " is happy");
        }
    }
}
