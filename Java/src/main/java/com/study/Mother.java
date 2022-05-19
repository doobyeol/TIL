package com.study;

public class Mother {
    public static String name;

    // 엄마의 슈퍼 유전자 요리솜씨, 학구열
    public static String cooking;
    public static String enthusiasm;

    public Mother(String name, String cooking, String enthusiasm ) {
        this.name = name;
        this.cooking = cooking;
        this.enthusiasm  = enthusiasm ;
    }
    
    public static void myInfo() {
        System.out.printf("%s가 만드는 %s 다 맛있어! 그리고 %s는 %s을 잘하고 싶어!! %n", name, cooking, name, enthusiasm);
    }

}

class HanByeol extends Mother implements somethingDoIt {
    public static final String name = "한벼리";
    public static final String cooking = "디저트";
    public static final String enthusiasm = "디자인";

    public HanByeol() {
        super(name, cooking, enthusiasm);
        super.myInfo();
        doCooking();
        doWorking();
        doNothing(name);
    }

    @Override
    public void doCooking() {
        System.out.println("한벼리가 남친을 위해 빼빼로를 만드는 중");
    }

    @Override
    public void doWorking() {
        System.out.println("한벼리는 게임 UI 디자인을 하면서 돈을 쓸어 담는 중");
    }
}

class DooByeol extends Mother implements somethingDoIt {
    public static final String name = "두벼리";
    public static final String cooking = "한식";
    public static final String enthusiasm = "개발";

    public DooByeol() {
        super(name,cooking, enthusiasm);
        super.myInfo();
        doCooking();
        doWorking();
        doNothing(name);
    }

    @Override
    public void doCooking() {
        System.out.println("두벼리는 식단을 위해 건강한 한식을 만드는 중");
    }

    @Override
    public void doWorking() {
        System.out.println("두벼리는 개발자가 상팔자라며 열심히 배우는 중");
    }

    public static void main(String[] args) {
        HanByeol hanbyeol = new HanByeol();
        System.out.println("=======================================");
        DooByeol doobyeol = new DooByeol();
        // ㅋㅋㅋㅋㅋ
    }
}

interface somethingDoIt {
    public void doCooking();
    public void doWorking();
    
    default void doNothing(String name) {
        System.out.println(name + "는 가끔 아무것도 하고 싶지 않을 때가 있어!");
    }
}