package com.study.ex01;

public class Box<T> {

    private T data;
//    private Integer data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
