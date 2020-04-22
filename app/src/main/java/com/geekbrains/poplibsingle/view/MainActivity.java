package com.geekbrains.poplibsingle.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.geekbrains.poplibsingle.R;
import com.geekbrains.poplibsingle.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView<String>{

    @BindView(R.id.text1)
    TextView textView1;

    MainPresenter<String> presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initMVP();
        presenter.presenterGo(null);

    }

    private void initMVP() {
        presenter = new MainPresenter<>(this);
    }


    @Override
    public void callbackGo(String o) {
        textView1.setText(o);
    }

    @OnClick(R.id.btn_begin)
    public void onClickButtonSubscribe(View view){
        presenter.presenterSubscribe();
    }
    @OnClick(R.id.btn_end)
    public void onClickButtonUnSubscribe(View view){
        presenter.presenterUnSubscribe();
    }

}
