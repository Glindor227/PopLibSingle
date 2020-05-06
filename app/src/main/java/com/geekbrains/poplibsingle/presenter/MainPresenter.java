package com.geekbrains.poplibsingle.presenter;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.geekbrains.poplibsingle.App;
import com.geekbrains.poplibsingle.model.room.User;
import com.geekbrains.poplibsingle.model.room.UserDAO;
import com.geekbrains.poplibsingle.view.MainView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.MvpPresenter;

public class MainPresenter<Tin,Tout> extends MvpPresenter<MainView> {
    private UserDAO model;
    private List<Long> userIdList = new ArrayList<>();

    public MainPresenter() {
        model = App.getAppDatabase().userDAO();
    }

    private User gererate(){
        User user = new User();
        user.age = (int)(Math.random() * 100);
        user.name = "name"+user.age;
        user.surname = "surname"+user.age;
        return user;

    }
//вставть одну
    public void pressButton1(){
        Disposable disposable = model.addUser(gererate())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(id ->{
                        Log.d("Lesson5","добавили " + id);
                            userIdList.add(id);
                        },
                        e-> Log.e("Lesson5", Objects.requireNonNull(e.getMessage()))
                );
    }

//вставть три
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void pressButton2(){
        Disposable disposable = model.addUsers(new ArrayList<>(Arrays.asList(gererate(), gererate(), gererate())))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(idList ->{
                            Log.d("Lesson5","добавили "+ idList.size() +" элемента");
                            idList.forEach(id -> userIdList.add(id));
                        },
                        e-> Log.e("Lesson5", Objects.requireNonNull(e.getMessage()))
                );

    }

    //удалить последнюю
    public void pressButton4() {
        User user = new User();
        user.id = userIdList.get(userIdList.size()-1);
        userIdList.remove(user.id);
        Disposable disposable = model.deleteUser(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> Log.d("Lesson5","удалили " + id),
                        e-> Log.e("Lesson5", Objects.requireNonNull(e.getMessage()))
                );
    }

    //заменить последнюю
    public void pressButton3() {
        User user = gererate();
        user.id = userIdList.get(userIdList.size()-1);
        Disposable disposable = model.updateUser(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> Log.d("Lesson5","заменили " + id),
                        e-> Log.e("Lesson5", Objects.requireNonNull(e.getMessage()))
                );
    }

    //вернуть результат
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void pressButton5() {
        Disposable disposable = model.getAllUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(users ->{
                            userIdList.clear();
                           StringBuilder builder = new StringBuilder("Результат:").append("\n");
                            users.forEach(user-> {
                                userIdList.add(user.id);
                                builder.append(user.toString()).append("\n");
                            });
                            builder.append("\n");
                            getViewState().callbackGo(builder.toString());

                        },
                        e-> Log.e("Lesson5", Objects.requireNonNull(e.getMessage()))
                );
    }

}
