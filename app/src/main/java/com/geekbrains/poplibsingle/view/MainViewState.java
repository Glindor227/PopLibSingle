package com.geekbrains.poplibsingle.view;

public class MainViewState<T>{
    final private T result;
    final private Boolean ok;

    public MainViewState(T result, Boolean ok) {
        this.result = result;
        this.ok = ok;
    }

    T getResult() {
        return result;
    }

    Boolean getOk() {
        return ok;
    }
}
