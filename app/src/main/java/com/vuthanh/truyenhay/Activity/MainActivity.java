package com.vuthanh.truyenhay.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;
import com.vuthanh.truyenhay.Adapter.ChuyenMucAdapter;
import com.vuthanh.truyenhay.Adapter.TaiKhoanAdapter;
import com.vuthanh.truyenhay.Adapter.TruyenAdapter;
import com.vuthanh.truyenhay.Model.ChuyenMuc;
import com.vuthanh.truyenhay.Model.TaiKhoan;
import com.vuthanh.truyenhay.Model.Truyen;
import com.vuthanh.truyenhay.Model.TruyenTC;
import com.vuthanh.truyenhay.R;
import com.vuthanh.truyenhay.database.SQLiteTruyen;
import com.vuthanh.truyenhay.database.database_dangnhap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    SQLiteTruyen sqLiteTruyen;
    TruyenAdapter truyenAdapter;
    ArrayList<TruyenTC> truyenArrayList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database_dangnhap = new database_dangnhap(this);
        sqLiteTruyen = new SQLiteTruyen(this);


        // Nhận dữ liệu đăng nhập gửi
        Intent intentpq = getIntent();
        int i = intentpq.getIntExtra("phanq", 0);
        int idd = intentpq.getIntExtra("idd",0);
        tentaikhoan = intentpq.getStringExtra("tentaikhoan");

        AnhXa();
        ActionBar();
        ActionViewFlipper();

        //noi dung
        listViewNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, NoiDungActivity.class);
                startActivity(intent);
            }
        });

        //Bắt click item cho listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    if(i == 1){
                        Intent intent = new Intent(MainActivity.this, AdminActivity.class);
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
    private void ActionViewFlipper() {
        //mảng chứa ảnh
//        ArrayList<String> arrayList = new ArrayList<>();
//        // add ảnh
//        arrayList.add("https://nettruyen.net.vn/manager/uploads/anhdaidien/doremon-truyen-dai.jpg");
//        arrayList.add("https://nettruyen.net.vn/manager/uploads/anhdaidien/dai-tien-tong-dung-khoa-hoc-ky-thuat.jpg");
//        arrayList.add("https://nettruyen.net.vn/manager/uploads/anhdaidien/nghich-thien-kiem-than_1554042567.jpggfhdfgdfgampmobile2");
//        arrayList.add("https://nettruyen.net.vn/truyen-chu/uploads/anhdaidien/doan-sung-tieu-tac-tinh-trong-sinh-thanh-man-cap-dai-lao.jpg");
//        arrayList.add("https://nettruyen.net.vn/manager/uploads/anhdaidien/lai-gap-duoc-em_1566101787.jpggfhdfgdfgampmobile2");

        List<String> img = Arrays.asList("https://nettruyen.net.vn/manager/uploads/anhdaidien/doremon-truyen-dai.jpg",
                "https://nettruyen.net.vn/manager/uploads/anhdaidien/dai-tien-tong-dung-khoa-hoc-ky-thuat.jpg",
                "https://nettruyen.net.vn/manager/uploads/anhdaidien/lai-gap-duoc-em_1566101787.jpggfhdfgdfgampmobile2"
         );
//        for (int i=0; i<img.size(); i++) {
        for (String im : img) {
//            ImageView imageView = new ImageView(getApplicationContext());
            ImageView imageView = new ImageView(this);
//            Picasso.get().load(arrayList.get(i)).into(imageView);
            Picasso.get().load(im).fit().centerCrop().into(imageView);
            // chỉnh ảnh vừa khung
            //imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            // thêm ảnh vào viewflipper
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        viewFlipper.startFlipping();
//        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
//        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
//        viewFlipper.setInAnimation(animation_slide_in);
//        viewFlipper.setInAnimation(animation_slide_out);
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
        listViewNew = findViewById(R.id.listviewNew);

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

        //add truyện
        Cursor cursor = sqLiteTruyen.getData();
        truyenArrayList = new ArrayList<>();
        while (cursor.moveToNext()) {
            String ten = cursor.getString(1);

            truyenArrayList.add(new TruyenTC(ten, R.drawable.sonhaicaotrung));
            truyenAdapter = new TruyenAdapter(getApplicationContext(), truyenArrayList);
            listViewNew.setAdapter(truyenAdapter);
        }
        cursor.moveToFirst();
        cursor.close();
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