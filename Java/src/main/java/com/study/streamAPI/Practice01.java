package com.study.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice01 {
    static List<Person> personList;

    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("홍길동", 35),
                new Person("주몽", 25),
                new Person("이순신", 55),
                new Person("세종대왕", 40),
                new Person("권율", 45),
                new Person("이지은", 27),
                new Person("손흥민", 30)
        );

        // TODO: 40대인 사람들만 추출하세요.
        personList = list.stream().filter(person -> {
            int age = person.getAge();
            return age >= 40 && age <= 49;
        }).collect(Collectors.toList());

        System.out.println("======== 40대인 사람들만 추출하세요. ========");
        personList.forEach((person) -> {
            System.out.println(person.getName() + ", " + person.getAge());
        });
        
        // TODO: 성이 '이' 씨인 사람들만 추출하세요.
        personList = list.stream().filter(person -> {
            String firstName = person.getName().substring(0, 1);
            return firstName.equals("이");
        }).collect(Collectors.toList());

        System.out.println("======== 성이 '이' 씨인 사람들만 추출하세요. ========");
        personList.forEach((person) -> {
            System.out.println(person.getName() + ", " + person.getAge());
        });

        // TODO: 20대인 사람들만 추출해 "이름(나이)" 형태의 List<String> 를 만드세요.
        personList = list.stream().filter(person -> {
            int age = person.getAge();
            return age >= 20 && age <= 29;
        }).collect(Collectors.toList());

        System.out.println("======== 20대인 사람들만 추출해 \"이름(나이)\" 형태의 List<String> 를 만드세요. ========");
        personList.forEach((person) -> {
            System.out.println(person.getName() + "(" + person.getAge()+ ")");
        });

        // TODO: 30대가 몇 명인지 구하시오.
        long count = list.stream().filter(person -> {
            int age = person.getAge();
            return age >= 30 && age <= 39;
        }).count();

        System.out.println("======== 30대가 몇 명인지 구하시오. ========");
        System.out.println(count + "명");

        // TODO: 나이가 내림차순으로 정렬된 List 를 만드세요.
        personList = list.stream().sorted((p1, p2) -> {
            int p1Age = p1.getAge();
            int p2Age = p2.getAge();
            return p1Age > p2Age ? 1 : (p1Age == p2Age ? 0 : -1);
        }).collect(Collectors.toList());

        System.out.println("======== 나이가 내림차순으로 정렬된 List 를 만드세요. ========");
        personList.forEach((person) -> {
            System.out.println(person.getName() + "(" + person.getAge()+ ")");
        });


    }
}
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}