package com.study.generic;

import java.lang.reflect.Constructor;
import java.util.*;

// Class 를 입력받아 새 인스턴스 객체를 리턴하는 "create()" 라는 이름의 static 메소드를 작성하세요.
// 인스턴스 타입은 Leaf, Doobyeol, Home 만 가능하며, 그 외 값인 경우 IllegalArgumentException 을 발생 시키세요.
public class Practice02 {

    private static final List<String> supportedClass = List.of("Leaf", "Doobyeol", "Home");

    public static void main(String[] args) throws Exception {
//        Leaf leaf = create(String.class);
    }

    public static <T> T create(Class clazz) throws Exception {
        String name = clazz.getSimpleName();
        if (!supportedClass.contains(name)) {
            throw new IllegalArgumentException();
        }
        Constructor constructor = clazz.getConstructor();
        T object = (T) constructor.newInstance();
        return object;
    }
}

class Leaf {
    public Leaf () {
        System.out.println("나는 잘생긴 리프");
    }
}

class Doobyeol {
    public Doobyeol () {
        System.out.println("나는 두벼리");
    }
}

class Home {
    public Home () {
        System.out.println("Home!");
    }
}