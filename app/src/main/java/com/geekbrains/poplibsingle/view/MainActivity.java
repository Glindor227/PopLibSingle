package com.geekbrains.poplibsingle.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.geekbrains.poplibsingle.R;
import com.geekbrains.poplibsingle.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView<Integer>{

    TextView textView1;
    MainPresenter<Integer> presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMVP();
        initUserView();
        presenter.presenterGo(null);

    }

    private void initMVP() {
        presenter = new MainPresenter<>(this);
    }

    private void initUserView() {
        textView1 = findViewById(R.id.text1);
        findViewById(R.id.btn_begin).setOnClickListener(view -> presenter.presenterSubscribe());
        findViewById(R.id.btn_end).setOnClickListener(view -> presenter.presenterUnSubscribe());
    }

    @Override
    public void callbackGo(Integer o) {
//        textView1.setText(o);
    }
}
