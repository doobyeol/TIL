package com.study.generic;

//1. map() 이라는 메소드의 Parameter Type 과 Return Type 을 받는 Mapper 란 이름의 Generic class 를 생성하고 map() 메소드를 작성하세요.
public class Practice01 {
    public static void main(String[] args) {
        Mapper<Integer, String> mapper = new Mapper<>();
        String result = mapper.map(12345); // result = "12345"
        System.out.println(result);

        Mapper<String, Integer> mapper2 = new Mapper<>();
        Integer result2 = mapper2.map("12345"); // result2 = 12345
        System.out.println(result2);
    }
}

// TODO

class Mapper<T, R> {

    public R map (T param) {
        if (param instanceof String) {
            return (R) Integer.valueOf(String.valueOf(param));
        } else if (param instanceof Integer) {
            return (R) param.toString();
        } else {
            return null;
        }
    }

}