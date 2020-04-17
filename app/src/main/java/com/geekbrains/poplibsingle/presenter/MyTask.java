package com.geekbrains.poplibsingle.presenter;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MyTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... voids) {
        for(int i = 0; i<5;i++){
            Log.d(MainPresenter.LESSON_N,"Поток["+Thread.currentThread().getName()+"] Сообщение "+i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
