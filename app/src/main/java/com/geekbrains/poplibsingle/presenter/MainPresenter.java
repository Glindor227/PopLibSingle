package com.geekbrains.poplibsingle.presenter;

import android.util.Log;

import com.geekbrains.poplibsingle.model.GsonDate;
import com.geekbrains.poplibsingle.model.MainModel;
import com.geekbrains.poplibsingle.view.MainView;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.MvpPresenter;

public class MainPresenter<Tin> extends MvpPresenter<MainView> {
    private MainModel<Tin, GsonDate> model;
    private Single<GsonDate> single;
    private Disposable disposable;

    public MainPresenter() {
        model = new MainModel<>();
        single = model.modelRXGo();
    }


    public void presenterSubscribe(Tin obj){
        if(disposable!=null && !disposable.isDisposed())
            return;
        model.setObj(obj);

        disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(
                s -> {
                    StringBuilder stringBuilder = new StringBuilder()
                            .append("первое поле: ")
                            .append(s.time_of_year)
                            .append("\nвторое поле: ")
                            .append(s.year.toString());
                    toLog(stringBuilder.toString());
                    getViewState().callbackGo(stringBuilder.toString());
                },
                e -> toLog("Ошибка:"+e.getMessage()));
    }

    public void presenterUnSubscribe(){
        if(disposable!=null)
            disposable.dispose();
    }

    private static void toLog(String s){
        Log.d("Lesson4_1","Поток["+Thread.currentThread().getName()+"] "+s);
    }

}
