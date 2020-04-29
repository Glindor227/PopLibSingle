package com.geekbrains.poplibsingle.presenter;

import android.util.Log;

import com.geekbrains.poplibsingle.model.GsonDate;
import com.geekbrains.poplibsingle.model.retrofit.GitHubApi;
import com.geekbrains.poplibsingle.view.MainView;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.MvpPresenter;

public class MainPresenter<Tin> extends MvpPresenter<MainView> {
//    private MainModel<Tin, GsonDate> model;
    private Single<GsonDate> single;
    private Disposable disposable;
    private GitHubApi gitHubApi;

    public MainPresenter() {
//        model = new MainModel<>();
        gitHubApi = new GitHubApi();
    }

    public void presenterSubscribe(Tin obj){
        if(disposable!=null && !disposable.isDisposed())
            return;
        single = gitHubApi.requestAvatarFromName((String) obj);

        disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(
                s -> {
                    toLog(s.avatar_url);
                    getViewState().callbackGo(s.avatar_url);
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
