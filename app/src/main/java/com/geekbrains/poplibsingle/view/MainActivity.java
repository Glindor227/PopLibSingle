package com.geekbrains.poplibsingle.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.geekbrains.poplibsingle.R;
import com.geekbrains.poplibsingle.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView<String>{

    TextView textView1;
    MainPresenter<String> presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUserView();
        initMVP();

    }

    private void initMVP() {
        presenter = new MainPresenter<>(this);
        presenter.presenterGo("Новый текст");
    }

    private void initUserView() {
        textView1 = findViewById(R.id.text1);
    }

    @Override
    public void callbackGo(String o) {
        textView1.setText(o);
    }
}
