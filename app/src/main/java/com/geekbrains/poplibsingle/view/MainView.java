package com.geekbrains.poplibsingle.view;

import moxy.MvpView;
import moxy.viewstate.strategy.alias.AddToEndSingle;

public interface MainView<T> extends MvpView {
    @AddToEndSingle
    void callbackGo(MainViewState<T> o);
}
