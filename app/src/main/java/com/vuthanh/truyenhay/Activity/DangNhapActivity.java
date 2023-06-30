package com.vuthanh.truyenhay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vuthanh.truyenhay.R;
import com.vuthanh.truyenhay.database.database_dangnhap;

public class DangNhapActivity extends AppCompatActivity {

    // Đăng nhập
    EditText edtTaiKhoan, edtEmail, edtMatKhau;
    private TextView dangky;
    Button btnDangNhap;

    // tạo đối thượng cho databasedangnhap
    database_dangnhap database_dangnhap;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        AnhXa();
        // đối tượng databasedangnhap
        database_dangnhap = new database_dangnhap(this);

        // tạo sự kiến click vào textview đăng ký chuyển sang màn hình đăng ký với Intent
        dangky = (TextView) findViewById(R.id.dangky);
        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhapActivity.this, DangKyActivity.class);
                startActivity(intent);
            }
        });

        // tạo sự kiến click vào button đăng nhập chuyển sang màn hình chính với Intent

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gán cho các biến là giá tr nhập từ EditText
                String tentaikhoan = edtTaiKhoan.getText().toString();
                String email = edtEmail.getText().toString();
                String matkhau = edtMatKhau.getText().toString();

                // Sử dụng con trỏ để lấy dữ liệu, gọi tới getData() để lấy dữ liệu tất cả tài khoản ở databse
                Cursor cursor = database_dangnhap.getData();

                // Thực hiện vòng lặp để lấy dữ liệu từ cursor với moveToNext() để di chuyển tiếp
                while (cursor.moveToNext()){

                    //Lấy dữ liệu và gán vào biến, dữ liệu tài khoản ở ô 1, email ở 2 và mật khẩu ở ô 3
                    // idtaikhoan là ô 0, phân quyền là ô 4
                    String datatentaikhoan = cursor.getString(1);
                    String dataemail = cursor.getString(2);
                    String datamatkhau = cursor.getString(3);

                    if(tentaikhoan.equals("") || email.equals("") || matkhau.equals("")){
                        // Log.e("Thông báo : ", "Chưa nhập đầy đủ thông tin");
                        Toast.makeText(DangNhapActivity.this, "Chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                        return;
                    }
//                    else if (!datatentaikhoan.equals(tentaikhoan)) {
//
//                        Toast.makeText(DangNhapActivity.this, "Tên tài khoản không đúng", Toast.LENGTH_SHORT).show();
//                        return;
//                    } else if (!dataemail.equals(email)) {
//                        Toast.makeText(DangNhapActivity.this, "Email không đúng", Toast.LENGTH_SHORT).show();
//                        return;
//                    } else if (!datamatkhau.equals(matkhau)) {
//                        Toast.makeText(DangNhapActivity.this, "Mật khẩu không đúng", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
                    else if (datatentaikhoan.equals(tentaikhoan) && dataemail.equals(email) && datamatkhau.equals(matkhau)) {
                        //Nếu tài khoản, email và mật khẩu vào từ bàn phím khớp với databse
                        //Lấy dữ liệu phân quyền và id
                        int phanquyen = cursor.getInt(4);
                        int idd = cursor.getInt(0);
                        String tentk = cursor.getString(1);
                        String emailtk = cursor.getString(2);

                        //Chuyển qua màn hình AdminActivity
                        Toast.makeText(getApplicationContext(), "Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DangNhapActivity.this, MainActivity.class);
                        startActivity(intent);
                        //gửi dữ liệu qua Activity là  MainActivity
                        intent.putExtra("phanq",phanquyen);
                        intent.putExtra("idd",idd);
                        intent.putExtra("email",emailtk);
                        intent.putExtra("tentaikhoan",tentk);



                    }
                    // nếu đầy đủ thông tin nhập vào thì add tài khoản vào database
                    else {
                        Toast.makeText(DangNhapActivity.this, "Đăng nhập không thành công",Toast.LENGTH_SHORT).show();

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
        edtTaiKhoan = findViewById(R.id.taikhoan);
        edtEmail = findViewById(R.id.email);
        edtMatKhau = findViewById(R.id.matkhau);
        btnDangNhap = findViewById(R.id.btn_dangnhap);
        dangky = findViewById(R.id.dangky);
    }
}