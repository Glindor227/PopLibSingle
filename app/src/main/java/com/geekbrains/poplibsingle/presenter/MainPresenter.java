package com.geekbrains.poplibsingle.presenter;

import android.util.Log;

import com.geekbrains.poplibsingle.model.MainModel;
import com.geekbrains.poplibsingle.view.MainView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainPresenter<T> {
    private MainModel<T> model;
    private MainView<T> view;
    private Observable<String> observable;
    private Disposable disposable;

    public MainPresenter(MainView<T> view) {
        this.view = view;
        model = new MainModel<>();
        model.modelRXGo();
    }

    public void presenterGo(T obj){
        observable = (Observable<String>) model.modelRXGo();
    }

    public void presenterSubscribe(){
        if(disposable!=null && !disposable.isDisposed())
            return;
        model.setObj((T) "");
        disposable = observable.observeOn(AndroidSchedulers.mainThread()).subscribe(s -> {
                    view.callbackGo((T) s);
                },
                e -> toLog("Ошибка:"+e.getMessage()),
                () -> toLog("onComplete"));
    }

    public void presenterUnSubscribe(){
        if(disposable!=null)
            disposable.dispose();
    }

    private static void toLog(String s){
        Log.d("Lesson3_1","Поток["+Thread.currentThread().getName()+"] "+s);
    }

}
