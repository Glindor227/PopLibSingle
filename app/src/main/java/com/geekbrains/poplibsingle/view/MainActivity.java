package com.geekbrains.poplibsingle.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.geekbrains.poplibsingle.R;
import com.geekbrains.poplibsingle.presenter.MainPresenter;
import com.squareup.picasso.Picasso;

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

    @BindView(R.id.img_out)
    ImageView imageView;

    @InjectPresenter
    MainPresenter<String> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void callbackGo(MainViewState<String> o) {

        textView1.setText(o.getResult());
        if(o.getOk())
            Picasso.get()
                .load(o.getResult())
                .into(imageView);
        else
            imageView.setImageResource(R.drawable.error);
    }

    @OnClick(R.id.btn_begin)
    public void onClickButtonSubscribe(View view){
        presenter.presenterSubscribe(et_input.getText().toString());
    }
    @OnClick(R.id.btn_end)
    public void onClickButtonUnSubscribe(View view){
        presenter.presenterUnSubscribe();
    }

}
