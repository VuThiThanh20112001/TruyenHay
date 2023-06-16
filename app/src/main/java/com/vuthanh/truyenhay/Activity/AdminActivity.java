package com.vuthanh.truyenhay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.vuthanh.truyenhay.Adapter.AdminAdapter;
import com.vuthanh.truyenhay.Adapter.ChuyenMucAdapter;
import com.vuthanh.truyenhay.Adapter.TaiKhoanAdapter;
import com.vuthanh.truyenhay.Model.Admin;
import com.vuthanh.truyenhay.Model.ChuyenMuc;
import com.vuthanh.truyenhay.Model.TaiKhoan;
import com.vuthanh.truyenhay.R;
import com.vuthanh.truyenhay.database.database_dangnhap;

import java.util.ArrayList;
import java.util.Collection;

public class AdminActivity extends AppCompatActivity {

    Button btnAddAdmin;

    ListView listViewAdmin;

    String tentaikhoan;


    database_dangnhap database_dangnhap;



    AdminAdapter AdminAdapter;


    ArrayList<Admin> adminArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        database_dangnhap = new database_dangnhap(this);

        // Nhận dữ liệu đăng nhập gửi
        Intent intentpq = getIntent();
        int i = intentpq.getIntExtra("phanq", 0);
        int idd = intentpq.getIntExtra("idd",0);
        tentaikhoan = intentpq.getStringExtra("tentaikhoan");
        
        AnhXa();
        
        btnAddAdmin = findViewById(R.id.btnAddAdmin);
        btnAddAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, TimKiemActivity.class);
                startActivity(intent);
            }
        });


        listViewAdmin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AdminActivity.this, UserActivity.class);

                String tentk = adminArrayList.get(position).getTenadmin();


                intent.putExtra("tentaikhoan", tentk);


                startActivity(intent);

            }
        });


    }

    private void AnhXa() {
        listViewAdmin = findViewById(R.id.listViewAdmin);

        adminArrayList = new ArrayList<>();
        Cursor cursor = database_dangnhap.getData();
        while (cursor.moveToNext()){

            int id = cursor.getInt(0);
            String tenadmin = cursor.getString(1);

            adminArrayList.add(new Admin(tenadmin, R.drawable.ic_edit,R.drawable.ic_delete));

            AdminAdapter = new AdminAdapter(getApplicationContext(), adminArrayList);
            listViewAdmin.setAdapter(AdminAdapter);



        }
        cursor.moveToFirst();
        cursor.close();



    }


}