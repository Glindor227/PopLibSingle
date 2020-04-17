package com.geekbrains.poplibsingle.presenter;

import com.geekbrains.poplibsingle.model.MainModel;
import com.geekbrains.poplibsingle.view.MainView;

public class MainPresenter<T> {
    private MainModel<T> model;
    private MainView<T> view;

    public MainPresenter(MainView<T> view) {
        this.view = view;
        model = new MainModel<>();
    }

    public void presenterGo(T obj){
        //test
        model.setObj(obj);
        view.callbackGo(model.getObj());
    }
}
