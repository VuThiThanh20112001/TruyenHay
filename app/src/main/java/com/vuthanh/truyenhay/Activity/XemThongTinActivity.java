package com.vuthanh.truyenhay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vuthanh.truyenhay.R;

public class XemThongTinActivity extends AppCompatActivity {

    TextView edtTaiKhoan, edtEmail, edtPhanQuyen;
    TextView edtMatKhau;
    Button btnQuayLai;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_thong_tin);

        edtTaiKhoan = findViewById(R.id.tt_tentaikhoan);
        edtEmail = findViewById(R.id.tt_email);
      //  edtMatKhau = findViewById(R.id.tt_matkhau);
        edtPhanQuyen = findViewById(R.id.tt_phanquyen);
        btnQuayLai = findViewById(R.id.btnQuayLai);

        // Lấy dữ liệu
        Intent intent = getIntent();
        String tentaikhoan1 = intent.getStringExtra("Tên tài khoản");
        String email1 = intent.getStringExtra("Email");
    //    String matkhau1 = intent.getStringExtra("Mật khẩu");
        String phanquyen1 = intent.getStringExtra("Phân quyền");

        // Gán giá trị lên
        edtTaiKhoan.setText(tentaikhoan1);
        edtEmail.setText(email1);
      //  edtMatKhau.setText(matkhau1);

        edtPhanQuyen.setText(phanquyen1);


        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XemThongTinActivity.this, AdminActivity.class);
                startActivity(intent);
            }
        });
    }
}