package com.vuthanh.truyenhay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.vuthanh.truyenhay.Model.Admin;
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
                Intent intent = new Intent(DangKyActivity.this,DangNhapActivity.class);
                startActivity(intent);
            }
        });

        // Click vào button đăng ký
//        btnDKDangKy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String taikhoan = edtDKTaiKhoan.getText().toString();
//                String email = edtDKEmail.getText().toString();
//                String matkhau = edtDKMatKhau.getText().toString();
//                String nhaplaimk = edtDKNhapLaiMK.getText().toString();
//
//                TaiKhoan taikhoan1 = CreateTaiKhoan();
//                if(taikhoan.equals("") || email.equals("") || matkhau.equals("")|| nhaplaimk.equals("")){
//                   // Log.e("Thông báo : ", "Chưa nhập đầy đủ thông tin");
//                    Toast.makeText(getApplicationContext(), "Chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//                } else if (!matkhau.equals(nhaplaimk)) {
//                  //  Log.e("Thông báo : ", "Mật khẩu không khớp");
//                    Toast.makeText(getApplicationContext(), "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
//                }
//                // nếu đầy đủ thông tin nhập vào thì add tài khoản vào database
//                else {
//                    database_dangnhap.AddTaiKhoan(taikhoan1);
//                    Toast.makeText(DangKyActivity.this, "Đăng ký thành công",Toast.LENGTH_LONG).show();
//
//                    Intent intent = new Intent(DangKyActivity.this, DangNhapActivity.class);
//                    startActivity(intent);
//                }
//
//            }
//        });

        btnDKDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gán cho các biến là giá tr nhập từ EditText
                String tentaikhoan = edtDKTaiKhoan.getText().toString();
                String email = edtDKEmail.getText().toString();
                String matkhau = edtDKMatKhau.getText().toString();
                String nhaplaimk = edtDKNhapLaiMK.getText().toString();

                TaiKhoan taikhoan = CreateTaiKhoan();

                // Sử dụng con trỏ để lấy dữ liệu, gọi tới getData() để lấy dữ liệu tất cả tài khoản ở databse
                Cursor cursor = database_dangnhap.getData();

                // Thực hiện vòng lặp để lấy dữ liệu từ cursor với moveToNext() để di chuyển tiếp
                while (cursor.moveToNext()){

                    //Lấy dữ liệu và gán vào biến, dữ liệu tài khoản ở ô 1, email ở 2 và mật khẩu ở ô 3
                    // idtaikhoan là ô 0, phân quyền là ô 4
                    String datatentaikhoan = cursor.getString(1);
                    String dataemail = cursor.getString(2);
                    String datamatkhau = cursor.getString(3);



                    if(tentaikhoan.equals("") || email.equals("") || matkhau.equals("") || nhaplaimk.equals("")){
                        // Log.e("Thông báo : ", "Chưa nhập đầy đủ thông tin");
                        Toast.makeText(DangKyActivity.this, "Chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if (datatentaikhoan.equals(tentaikhoan)) {

                        Toast.makeText(getApplicationContext(), "Tên tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (dataemail.equals(email)) {
                        Toast.makeText(DangKyActivity.this, "Email đã tồn tại", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (!matkhau.equals(nhaplaimk)) {
                  //  Log.e("Thông báo : ", "Mật khẩu không khớp");
                    Toast.makeText(getApplicationContext(), "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                    return;

                    }

                    // nếu đầy đủ thông tin nhập vào thì add tài khoản vào database
                    else {

                        database_dangnhap.AddTaiKhoan(taikhoan);
                    Toast.makeText(DangKyActivity.this, "Đăng ký thành công",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(DangKyActivity.this, DangNhapActivity.class);
                    startActivity(intent);
                    return;
                    }

                }
                //Thực hiện trả cursor về đầu
                cursor.moveToFirst();
                //đóng khi không dùng
                cursor.close();

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


    private TaiKhoan CreateTaiKhoan(){

        String taikhoanDK = edtDKTaiKhoan.getText().toString();
        String emailDK = edtDKEmail.getText().toString();
        String matkhauDK = edtDKMatKhau.getText().toString();
        String nhaplaimkDK = edtDKNhapLaiMK.getText().toString();
        int phanquyenDK = 2;


        TaiKhoan tk = new TaiKhoan(taikhoanDK,emailDK,matkhauDK,phanquyenDK);

        return tk;
    }
}