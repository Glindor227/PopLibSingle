package com.geekbrains.poplibsingle.presenter;

import android.util.Log;

import com.geekbrains.poplibsingle.model.MainModel;
import com.geekbrains.poplibsingle.view.MainView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter<T> {
    private MainModel<T> model;
    private MainView<T> view;
    private Observable<String> observable;
    private List<Disposable> disposable;

    public MainPresenter(MainView<T> view) {
        this.view = view;
        model = new MainModel<>();
    }

    public void presenterGo(T obj){
        disposable = new ArrayList<>();
        observable = Observable.create((ObservableOnSubscribe<String>) emitter -> {
            int num = 0;
            try {

                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }
                    catch (InterruptedException e){
                        toLog("Exception1:" + e.getMessage());
                    }
                    emitter.onNext("Сообщение " + num);
                    num++;
                }
            }
            catch (UndeliverableException e){
                toLog("Exception2:" + e.getMessage());
            }
        }).subscribeOn(Schedulers.io());
//        model.setObj(obj);
//        view.callbackGo(model.getObj());
    }
    public void presenterSubscribe(){

        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                toLog("подписались");
                disposable.add(d);
            }

            @Override
            public void onNext(String s) {
                toLog("пришло:"+s);
            }

            @Override
            public void onError(Throwable e) {
                toLog("Ошибка:"+e.getMessage());

            }

            @Override
            public void onComplete() {
                toLog("onComplete");

            }
        });
    }
    public void presenterUnSubscribe(){
        if (!disposable.isEmpty()){
            Disposable dis = disposable.get(disposable.size()-1);
            disposable.remove(dis);
            dis.dispose();
        }
    }

    private void toLog(String s){
        Log.d("Lesson2_3","Поток["+Thread.currentThread().getName()+"] "+s);
    }

}
