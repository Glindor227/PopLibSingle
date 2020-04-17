package com.geekbrains.poplibsingle.model;

public class MainModel<T> {
    private T obj = null;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
