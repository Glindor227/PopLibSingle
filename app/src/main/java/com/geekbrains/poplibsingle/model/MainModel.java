package com.geekbrains.poplibsingle.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class MainModel<Tin,Tout> {
    private Object obj = null;

    public void setObj(Tin obj) {
        this.obj = obj;
    }

    public Single<Tout> modelRXGo(){
        return Single.create((SingleOnSubscribe<Tout>) emitter -> {
            Gson gson = new GsonBuilder().create();
            GsonDate gsonDate = gson.fromJson((String) obj,GsonDate.class);
            emitter.onSuccess((Tout)gsonDate);
        }).subscribeOn(Schedulers.io());
    }

}
