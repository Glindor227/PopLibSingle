package com.geekbrains.poplibsingle.model;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class MainModel<T> {
    private T obj = null;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public Observable<T> modelRXGo(){
        return Observable.create((ObservableOnSubscribe<T>) emitter -> {
            int num = 0;
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }
                    catch (InterruptedException e){
                        break;
                    }
                    String objStr = (String) obj;
                    objStr = objStr.concat("Сообщение " + num).concat("\n");
                    obj = (T) objStr;
                    emitter.onNext(obj);
                    num++;
                }
        }).subscribeOn(Schedulers.io());
    }

}
