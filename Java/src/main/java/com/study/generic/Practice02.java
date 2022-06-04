package com.study.generic;

// Class 를 입력받아 새 인스턴스 객체를 리턴하는 "create()" 라는 이름의 static 메소드를 작성하세요.
// 인스턴스 타입은 Leaf, Doobyeol, Home 만 가능하며, 그 외 값인 경우 IllegalArgumentException 을 발생 시키세요.
public class Practice02 {

    public static void main(String[] args) {
        Class<Leaf> leafClass = Leaf.class;
//        leafClass.getConstructor();
//        Class leaf = create(Leaf.class);

    }

//    public static <T> Class create(Class clazz) {
//
//    }
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