package com.geekbrains.poplibsingle.view;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.geekbrains.poplibsingle.R;
import com.geekbrains.poplibsingle.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView<String>{

    @BindView(R.id.text1)
    TextView textView1;

    @BindView(R.id.et_input)
    EditText et_input;

    @InjectPresenter
    MainPresenter<String,String> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    public void callbackGo(String o) {
        textView1.setText(o);
    }

    @OnClick(R.id.btn_begin)
    public void onClickButtonSubscribe(View view){
        presenter.pressButton1();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnClick(R.id.btn_end)
    public void onClickButtonUnSubscribe(View view){
        presenter.pressButton2();
    }

    @OnClick(R.id.btn_3)
    public void onClickButton3(View view){
        presenter.pressButton3();
    }

    @OnClick(R.id.btn_4)
    public void onClickButton4(View view){
        presenter.pressButton4();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnClick(R.id.btn_5)
    public void onClickButton5(View view){
        presenter.pressButton5();
    }

}
