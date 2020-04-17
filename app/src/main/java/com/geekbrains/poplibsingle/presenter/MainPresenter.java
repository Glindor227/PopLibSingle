package com.geekbrains.poplibsingle.presenter;

import android.util.Log;

import com.geekbrains.poplibsingle.model.MainModel;
import com.geekbrains.poplibsingle.view.MainView;

import java.util.Observable;
import java.util.Observer;

public class MainPresenter<T> {
    private MainModel<T> model;
    private MainView<T> view;
    private Spam spam;
    private Subscriber subscriber;

    public MainPresenter(MainView<T> view) {
        this.view = view;
        model = new MainModel<>();
        spam = new Spam();
        subscriber = new Subscriber();
    }

    public void presenterGo(T obj){
        Integer cod = (Integer) obj;
        switch (cod){
            case 0:spam.addObserver(subscriber);
                Log.d("Lesson2_2","Подписались");
                break;
            case 1:spam.deleteObserver(subscriber);
                Log.d("Lesson2_2","Отписались");
                break;
            case 2:spam.addSpam();break;
        }

//        model.setObj(obj);
  //      view.callbackGo(model.getObj());
    }
}
class Subscriber implements Observer{

    @Override
    public void update(Observable observable, Object o) {
        Log.d("Lesson2_2","Получили:" + o);
    }
}
class Spam extends Observable {

    void  addSpam(){
        setChanged();
        notifyObservers("Спам!");
    }

}