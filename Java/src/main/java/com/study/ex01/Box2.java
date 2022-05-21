package com.study.ex01;

public class Box2<T> {

    private T data;
    private T gender;

    public void setData(T dara, T gender) {
        this.data = data;
        this.gender = gender;
    }

    public T getData() {
        return data;
    }

    public T getGender () {
        return gender;
    }
}
