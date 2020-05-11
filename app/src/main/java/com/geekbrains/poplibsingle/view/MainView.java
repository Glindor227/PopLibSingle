package com.geekbrains.poplibsingle.view;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.alias.AddToEndSingle;

public interface MainView<T> extends MvpView {
    @AddToEndSingle
    void callbackGo(T o);

    @AddToEndSingle
    void callbackImage(List<Byte> list);

}
