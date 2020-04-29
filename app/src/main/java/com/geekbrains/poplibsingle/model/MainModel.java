package com.geekbrains.poplibsingle.model;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class MainModel<Tin,Tout> {
    private Object obj = null;

    public Tout getObj() {
        return (Tout) obj;
    }

    public void setObj(Tin obj) {
        this.obj = obj;
    }

    public Single<Tout> modelRXGo(){
        return Single.create((SingleOnSubscribe<Tout>) emitter -> {
            emitter.onSuccess((Tout) "Единственное сообщение");
        }).subscribeOn(Schedulers.io());
    }

}
