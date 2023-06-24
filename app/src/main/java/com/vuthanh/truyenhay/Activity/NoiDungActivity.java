package com.vuthanh.truyenhay.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.vuthanh.truyenhay.R;


public class NoiDungActivity extends AppCompatActivity {
    TextView txtTenTruyen, txtNoiDung;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noidung);

        txtTenTruyen = findViewById(R.id.txttentruyen);
        txtNoiDung = findViewById(R.id.txtnoidung);

        Intent intent = getIntent();
        String tentruyen = intent.getStringExtra("tentruyen");
        String noidung = intent.getStringExtra("noidung");

        txtTenTruyen.setText(tentruyen);
        txtNoiDung.setText(noidung);

        //cho phép cuộn dội dung truyện
        txtNoiDung.setMovementMethod(new ScrollingMovementMethod());

    }
}
