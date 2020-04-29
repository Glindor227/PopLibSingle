package com.geekbrains.poplibsingle.view;

public class MainViewState<T>{
    T result;
    Boolean ok;

    public MainViewState(T result, Boolean ok) {
        this.result = result;
        this.ok = ok;
    }

    public T getResult() {
        return result;
    }

    public Boolean getOk() {
        return ok;
    }
}
