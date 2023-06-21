package com.vuthanh.truyenhay.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vuthanh.truyenhay.R;

public class ThongTinActivity extends AppCompatActivity {
    TextView txtthongtin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);
        txtthongtin = findViewById(R.id.txtthongtin);

    }
}
