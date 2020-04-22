package com.geekbrains.poplibsingle.model;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class MainModel<T> {
    private T obj = null;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public Single<T> modelRXGo(){
        return Single.create((SingleOnSubscribe<T>) emitter -> {
            emitter.onSuccess((T) "Единственное сообщение");
        }).subscribeOn(Schedulers.io());
    }

}
