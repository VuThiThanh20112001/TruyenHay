package com.vuthanh.truyenhay.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.vuthanh.truyenhay.Adapter.AdminAdapter;
import com.vuthanh.truyenhay.Adapter.ChuyenMucAdapter;
import com.vuthanh.truyenhay.Adapter.TaiKhoanAdapter;
import com.vuthanh.truyenhay.Model.Admin;
import com.vuthanh.truyenhay.Model.TaiKhoan;
import com.vuthanh.truyenhay.R;
import com.vuthanh.truyenhay.database.database_dangnhap;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    Button btnAddAdmin;

    ListView listViewAdmin;

   ArrayList<Admin> adminArrayList;

   AdminAdapter AdminAdapter;

    database_dangnhap database_dangnhap;

    int count = 0;

    String tentaikhoan;
    TaiKhoanAdapter TaiKhoanAdapter;

    ArrayList<TaiKhoan> taiKhoanArrayList;

    ImageButton imgQuayLai;
    DrawerLayout drawerLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        database_dangnhap = new database_dangnhap(this);

        listViewAdmin = findViewById(R.id.listViewAdmin);

        btnAddAdmin = findViewById(R.id.btnAddAdmin);
        imgQuayLai = findViewById(R.id.imgQuayLai);


        // Nhận dữ liệu đăng nhập gửi
        Intent intentpq = getIntent();
        int i = intentpq.getIntExtra("phanq", 0);
        int idd = intentpq.getIntExtra("idd",0);
        tentaikhoan = intentpq.getStringExtra("tentaikhoan");

        btnAddAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, AddTaiKhoanActivity.class);
                startActivity(intent);
            }
        });

        adminArrayList = new ArrayList<>();

        Cursor cursor = database_dangnhap.getData();
        while (cursor.moveToNext()){

            int id = cursor.getInt(0);
            String tentaikhoan = cursor.getString(1);
            String email = cursor.getString(2);
            String matkhau = cursor.getString(3);
            String phanquyen = cursor.getString(4);

            adminArrayList.add(new Admin(id, tentaikhoan,email,matkhau,phanquyen));
        }

        AdminAdapter = new AdminAdapter(AdminActivity.this, adminArrayList);
        listViewAdmin.setAdapter(AdminAdapter);
        cursor.moveToFirst();
        cursor.close();

        imgQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }

    public void information(final int pos){
        Cursor cursor = database_dangnhap.getData();

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            if(id == pos){
                Intent intent = new Intent(AdminActivity.this, XemThongTinActivity.class);

                intent.putExtra("id", id);
                String tenadmin = cursor.getString(1);
                String emailadmin = cursor.getString(2);
             //   String matkhauadmin = cursor.getString(3);

                String phanquyenadmin = cursor.getString(4);


                intent.putExtra("Tên tài khoản", tenadmin);
                intent.putExtra("Email", emailadmin);
             //   intent.putExtra("Mật khẩu", matkhauadmin);
                intent.putExtra("Phân quyền", phanquyenadmin);

                startActivity(intent);
            }
        }
    }

    //Phương thức xóa
    public void delete(final int position){
        Dialog dialog = new Dialog(this);
        // nạp layout vào dialog
        dialog.setContentView(R.layout.dialogdelete);

        dialog.setCanceledOnTouchOutside(false);

        Button btnDeleteYes = dialog.findViewById(R.id.buttonDeleteYes);
        Button btnDeleteNo = dialog.findViewById(R.id.buttonDeleteNo);

        btnDeleteYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  database_dangnhap = new database_dangnhap(AdminActivity.this);

                // Xóa tài khoản trong csdl
                database_dangnhap.DeleteAdmin(position);

                // cập nhật lại trong AdminActivity

                Intent intent =  new Intent(AdminActivity.this, AdminActivity.class);
                startActivity(intent);
            }
        });
        // Đóng dialog
        btnDeleteNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        // show dialog
        dialog.show();

    }

    // Sửa thông tin tài khoản

    public void update(final int pos){
        Cursor cursor = database_dangnhap.getData();

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);

            if(id == pos){
                Intent intent = new Intent(AdminActivity.this, SuaThongTinTKActivity.class);
                intent.putExtra("id", id);

                String tenadmin = cursor.getString(1);
                String emailadmin = cursor.getString(2);
                String matkhauadmin = cursor.getString(3);
                String phanquyenadmin = cursor.getString(4);

                // Gửi dữ liệu qua Activity update
                intent.putExtra("Tên tài khoản", tenadmin);
                intent.putExtra("Email", emailadmin);
                intent.putExtra("Mật khẩu", matkhauadmin);
                intent.putExtra("Phân quyền", phanquyenadmin);

                startActivity(intent);

            }

        }
    }



}