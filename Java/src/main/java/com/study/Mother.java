package com.study;

public class Mother {
    private String name;

    // 엄마의 슈퍼 유전자 요리솜씨, 학구열
    protected String cooking;
    protected String enthusiasm;

    public Mother(String name, String cooking, String enthusiasm ) {
        this.name = name;
        this.cooking = cooking;
        this.enthusiasm  = enthusiasm ;
    }

    protected String getName() {
        return this.name;
    }

    public void myInfo() {
        System.out.printf("%s가 만드는 %s 다 맛있어! 그리고 %s는 %s을 잘하고 싶어!! %n", name, cooking, name, enthusiasm);
    }

}

class HanByeol extends Mother implements SomethingDoIt {
    public HanByeol() {
        super("한벼리", "디저트", "디자인");
        super.myInfo();
        doCooking();
        doWorking();
    }

    @Override
    public void doCooking() {
        System.out.printf("%s가 남친을 위해 빼빼로를 만드는 중\n",getName());
    }

    @Override
    public void doWorking() {
        System.out.printf("%s는 게임 UI 디자인을 하면서 돈을 쓸어 담는 중\n", getName());
    }
}

class DooByeol extends Mother implements SomethingDoIt, NothingDoIt {
    public DooByeol() {
        super("두벼리","한식", "개발");
        super.myInfo();
        doCooking();
        doWorking();
        doNothing(getName());
    }

    @Override
    public void doCooking() {
        System.out.printf("%s는 식단을 위해 건강한 한식을 만드는 중\n", getName());
    }

    @Override
    public void doWorking() {
        System.out.printf("%s는 개발자가 상팔자라며 열심히 배우는 중\n", getName());
    }

    public static void main(String[] args) {
        HanByeol hanbyeol = new HanByeol();
        System.out.println("=======================================");
        DooByeol doobyeol = new DooByeol();

        NothingDoIt nothingDoIt = (NothingDoIt) doobyeol;
        Mother mother = (Mother) hanbyeol;
        // ㅋㅋㅋㅋㅋ
    }
}

interface SomethingDoIt {
    public void doCooking();
    public void doWorking();
}

interface NothingDoIt {
    default void doNothing(String name) {
        System.out.println(name + "는 가끔 아무것도 하고 싶지 않을 때가 있어!");
    }
}