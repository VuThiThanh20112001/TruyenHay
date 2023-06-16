package com.vuthanh.truyenhay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.vuthanh.truyenhay.Model.TaiKhoan;
import com.vuthanh.truyenhay.R;
import com.vuthanh.truyenhay.database.database_dangnhap;

public class DangKyActivity extends AppCompatActivity {
    EditText edtDKTaiKhoan, edtDKEmail, edtDKMatKhau, edtDKNhapLaiMK;
    private Button btnDKDangKy, btnDKDangNhap;
    private ImageView back;

    database_dangnhap database_dangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        database_dangnhap = new database_dangnhap(this);
        AnhXa();

        btnDKDangKy = (Button) findViewById(R.id.btn_dangky);
        back = (ImageView) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangKyActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        // Click vào button đăng ký
        btnDKDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = edtDKTaiKhoan.getText().toString();
                String email = edtDKEmail.getText().toString();
                String matkhau = edtDKMatKhau.getText().toString();
                String nhaplaimk = edtDKNhapLaiMK.getText().toString();

                TaiKhoan taikhoan1 = CreateTaiKhoan();
                if(taikhoan.equals("") || email.equals("") || matkhau.equals("")|| nhaplaimk.equals("")){
                   // Log.e("Thông báo : ", "Chưa nhập đầy đủ thông tin");
                    Toast.makeText(getApplicationContext(), "Chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if (!matkhau.equals(nhaplaimk)) {
                  //  Log.e("Thông báo : ", "Mật khẩu không khớp");
                    Toast.makeText(getApplicationContext(), "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                }
                // nếu đầy đủ thông tin nhập vào thì add tài khoản vào database
                else {
                    database_dangnhap.AddTaiKhoan(taikhoan1);
                    Toast.makeText(DangKyActivity.this, "Đăng ký thành công",Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(DangKyActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });


    }
    private void AnhXa(){
        edtDKTaiKhoan = findViewById(R.id.taikhoan);
        edtDKEmail = findViewById(R.id.email);
        edtDKMatKhau = findViewById(R.id.matkhau);
        edtDKNhapLaiMK = findViewById(R.id.nhaplaimk);
        btnDKDangNhap = findViewById(R.id.btn_dangnhap);
        btnDKDangKy = findViewById(R.id.btn_dangky);
    }
    //  if(tentaikhoan != null && email != null && matkhau != null && nhaplaimk.equalsIgnoreCase(nhaplaimk)) {

    // Phương thức tạo tài khoản
    private  TaiKhoan CreateTaiKhoan(){
        String taikhoan = edtDKTaiKhoan.getText().toString();
        String email = edtDKEmail.getText().toString();
        String matkhau = edtDKMatKhau.getText().toString();
        String nhaplaimk = edtDKNhapLaiMK.getText().toString();
        int phanquyen = 2;

        TaiKhoan tk = new TaiKhoan(taikhoan);

        return tk;

    }
}