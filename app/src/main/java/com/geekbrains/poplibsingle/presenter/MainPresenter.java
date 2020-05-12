package com.geekbrains.poplibsingle.presenter;

import android.util.Log;

import com.geekbrains.poplibsingle.model.MainModel;
import com.geekbrains.poplibsingle.view.MainView;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.MvpPresenter;

public class MainPresenter<Tin,Tout> extends MvpPresenter<MainView> {
    private MainModel<Tin,Tout> model;
    private Single<Tout> single;
    private Disposable disposable;

    public MainPresenter() {
        model = new MainModel<>();
        single =model.modelRXGo();
    }

    public void sendToPresenter(Tin obj){
    }

    public void presenterSubscribe(){
        if(disposable!=null && !disposable.isDisposed())
            return;
        disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(
                s -> getViewState().callbackGo(s),
                e -> toLog("Ошибка:"+e.getMessage()));
    }

    public void presenterUnSubscribe(){
        if(disposable!=null)
            disposable.dispose();
    }

    private static void toLog(String s){
        Log.d("Lesson3_1","Поток["+Thread.currentThread().getName()+"] "+s);
    }

}
