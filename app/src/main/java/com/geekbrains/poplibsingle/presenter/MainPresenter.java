package com.geekbrains.poplibsingle.presenter;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.geekbrains.poplibsingle.model.retrofit.RetrofitApi;
import com.geekbrains.poplibsingle.model.retrofit.date.ConfigFile;
import com.geekbrains.poplibsingle.model.retrofit.date.GsonDate;
import com.geekbrains.poplibsingle.view.MainView;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.MvpPresenter;

public class MainPresenter<Tin> extends MvpPresenter<MainView> {
//    private MainModel<Tin, GsonDate> model;
    private Single<GsonDate> single;
    private Single<ConfigFile> oneFile;
    private Disposable disposable;
    private RetrofitApi myApi;

    public MainPresenter() {
        myApi = new RetrofitApi();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void presenterSubscribe(Tin obj){
        if(disposable!=null && !disposable.isDisposed())
            return;
//        single = myApi.requestFilesList();
        oneFile = myApi.requestFileByName("tessss");

        disposable = oneFile.observeOn(AndroidSchedulers.mainThread()).subscribe(
                s -> {
                    getViewState().callbackGo(s.name+" "+s.size);
                    getViewState().callbackImage(s.file);
                },
                e -> {
                    toLog("Ошибка:"+e.getMessage());
                    getViewState().callbackGo(e.getMessage());
                });
    }

    public void presenterUnSubscribe(){
        if(disposable!=null)
            disposable.dispose();
    }

    private static void toLog(String s){
        Log.d("Lesson4_2","Поток["+Thread.currentThread().getName()+"] "+s);
    }

}
