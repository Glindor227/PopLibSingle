package com.geekbrains.poplibsingle.presenter;

import android.util.Log;

import com.geekbrains.poplibsingle.model.MainModel;
import com.geekbrains.poplibsingle.view.MainView;

public class MainPresenter<T> {
    private MainModel<T> model;
    private MainView<T> view;
    final static String LESSON_N = "Lesson1_1";
    public MainPresenter(MainView<T> view) {
        this.view = view;
        model = new MainModel<>();
    }

    public void presenterGo(T obj){
        MyTask myTask = new MyTask();
        myTask.execute();
        Log.d(LESSON_N,"Поток["+Thread.currentThread().getName()+"] Вызывающий метод завершен.");

//        model.setObj(obj);
//        view.callbackGo(model.getObj());
    }
}
