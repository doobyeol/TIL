package com.study.ex01;

public class Box3<K, V> {

    private K data;
    private V age;

    public void setData(K name, V age) {
        this.data = name;
        this.age = age;
    }

    public K getData() {
        return data;
    }

    public V getAge () {
        return age;
    }
}
