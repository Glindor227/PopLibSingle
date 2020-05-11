package com.geekbrains.poplibsingle.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.geekbrains.poplibsingle.R;
import com.geekbrains.poplibsingle.presenter.MainPresenter;

import java.io.ByteArrayOutputStream;
import java.util.List;

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

    @BindView(R.id.imageRez)
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
    public void callbackGo(String o) {
        textView1.setText(o);
    }

    @Override
    public void callbackImage(List<Byte> list) {
        byte[] byteArray = new byte[list.size()];
        for (int index = 0; index < list.size(); index++) {
            byteArray[index] = list.get(index);
        }
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, list.size());
        imageView.setImageBitmap(bitmap);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnClick(R.id.btn_begin)
    public void onClickButtonSubscribe(View view){
        presenter.presenterSubscribe(et_input.getText().toString());
    }
    @OnClick(R.id.btn_end)
    public void onClickButtonUnSubscribe(View view){
        presenter.presenterUnSubscribe();
    }

}
