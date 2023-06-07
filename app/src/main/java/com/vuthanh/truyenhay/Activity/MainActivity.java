package com.vuthanh.truyenhay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vuthanh.truyenhay.R;
import com.vuthanh.truyenhay.database.database_dangnhap;

public class MainActivity extends AppCompatActivity {

    EditText edtTaiKhoan, edtEmail, edtMatKhau;
    private TextView dangky;
    Button btnDangNhap;

    // tạo đối thượng cho databasedangnhap
    database_dangnhap database_danhnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        // đối tượng databasedangnhap
        database_danhnhap = new database_dangnhap(this);

        // tạo sự kiến click vào textview đăng ký chuyển sang màn hình đăng ký với Intent
        dangky = (TextView) findViewById(R.id.dangky);
        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DangKyActivity.class);
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
                Cursor cursor = database_danhnhap.getData();

                // Thực hiện vòng lặp để lấy dữ liệu từ cursor với moveToNext() để di chuyển tiếp
                while (cursor.moveToNext()){

                    //Lấy dữ liệu và gán vào biến, dữ liệu tài khoản ở ô 1, email ở 2 và mật khẩu ở ô 3
                    // idtaikhoan là ô 0, phân quyền là ô 4
                    String datatentaikhoan = cursor.getString(1);
                    String dataemail = cursor.getString(2);
                    String datamatkhau = cursor.getString(3);

                    //Nếu tài khoản, email và mật khẩu vào từ bàn phím khớp với databse
                    if(datatentaikhoan.equals(tentaikhoan) && dataemail.equals(email) && datamatkhau.equals(matkhau)){
                        //Lấy dữ liệu phân quyền và id
                        int phanquyen = cursor.getInt(4);
                        int idd = cursor.getInt(0);
                        String tentk = cursor.getString(1);
                        String emailtk = cursor.getString(2);

                        //Chuyển qua màn hình AdminActivity
                        Intent intent = new Intent(MainActivity.this, AdminActivity.class );

                        //gửi dữ liệu qua Activitu là AdminActivity
                        intent.putExtra("phanq",phanquyen);
                        intent.putExtra("idd",idd);
                        intent.putExtra("email",emailtk);
                        intent.putExtra("tentaikhoan",tentk);

                        startActivity(intent);

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