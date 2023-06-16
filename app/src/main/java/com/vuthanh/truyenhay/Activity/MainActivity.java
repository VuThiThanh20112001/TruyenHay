package com.vuthanh.truyenhay.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.vuthanh.truyenhay.Adapter.ChuyenMucAdapter;
import com.vuthanh.truyenhay.Adapter.TaiKhoanAdapter;
import com.vuthanh.truyenhay.Model.ChuyenMuc;
import com.vuthanh.truyenhay.Model.TaiKhoan;
import com.vuthanh.truyenhay.R;
import com.vuthanh.truyenhay.database.database_dangnhap;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ListView listView,listViewTaiKhoan, listViewNew;

    String tentaikhoan;


    database_dangnhap database_dangnhap;

    TaiKhoanAdapter TaiKhoanAdapter;
    ChuyenMucAdapter ChuyenMucAdapter;


    ArrayList<TaiKhoan> taiKhoanArrayList;

    ArrayList<ChuyenMuc> chuyenMucArrayList;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database_dangnhap = new database_dangnhap(this);

        // Nhận dữ liệu đăng nhập gửi
        Intent intentpq = getIntent();
        int i = intentpq.getIntExtra("phanq", 0);
        int idd = intentpq.getIntExtra("idd",0);
        tentaikhoan = intentpq.getStringExtra("tentaikhoan");

        AnhXa();
        ActionBar();

        //Bắt click item cho listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    if(i == 1){
                        Intent intent = new Intent(MainActivity.this, UserActivity.class);
                       // Gửi id tài khoản qua màn User
                        intent.putExtra("Id",idd);
                        startActivity(intent);

                    }else{
                        Toast.makeText(MainActivity.this, "Bạn không có quyền truy cập",Toast.LENGTH_SHORT).show();
                        Log.e("Người dùng : ", "Bạn không có quyền truy cập");
                    }
                } else if (position == 1) {
                    if(i == 1){
                        Intent intent = new Intent(MainActivity.this,TruyenActivity.class);
                        startActivity(intent);

                    }else {
                        Toast.makeText(MainActivity.this, "Bạn không có quyền truy cập",Toast.LENGTH_SHORT).show();
                        Log.e("Đăng bài : ", "Bạn không có quyền truy cập");
                    }

                } else if (position == 2) {
                    finish();

                }
            }
        });




    }
    //Thanh actionbar với toolbar
    @SuppressLint("RestrictedApi")
    private void ActionBar(){
        // Hàm hỗ trợ toolbar
        setSupportActionBar(toolbar);

        // set nút cho actionbar
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        // Tạo icon cho toolbar
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void AnhXa(){
        viewFlipper = findViewById(R.id.viewflipper);
        toolbar = findViewById(R.id.toolbartopthinhhanh);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nagigationView);
        listViewTaiKhoan = findViewById(R.id.listviewtaikhoan);
        listView = findViewById(R.id.listviewmanhinhchinh);

        listViewTaiKhoan = findViewById(R.id.listviewtaikhoan);
        listView = findViewById(R.id.listviewmanhinhchinh);

        // Thông tin tài khoản
        taiKhoanArrayList = new ArrayList<>();
        taiKhoanArrayList.add(new TaiKhoan(tentaikhoan));

        TaiKhoanAdapter = new TaiKhoanAdapter(this,R.layout.activity_personal,taiKhoanArrayList);
        listViewTaiKhoan.setAdapter(TaiKhoanAdapter);

        //Chuyên mục
        chuyenMucArrayList = new ArrayList<>();
        chuyenMucArrayList.add(new ChuyenMuc("Người dùng", R.drawable.person));
        chuyenMucArrayList.add(new ChuyenMuc("Đăng bài", R.drawable.post));
        chuyenMucArrayList.add(new ChuyenMuc("Đăng xuất", R.drawable.log_out));

        ChuyenMucAdapter = new ChuyenMucAdapter(this,R.layout.chuyenmuc,chuyenMucArrayList);
        listView.setAdapter(ChuyenMucAdapter);
    }

    // Nạp 1 tìm kiếm vào actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // Nếu click vaofg icon tìm kiếm chuển qua màn hình tìm kiem
        switch (item.getItemId()){
            case R.id.menu1:
                Intent intent = new Intent(MainActivity.this, TimKiemActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}