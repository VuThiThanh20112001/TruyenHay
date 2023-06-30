package com.vuthanh.truyenhay.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vuthanh.truyenhay.Adapter.TruyenAdapter;
import com.vuthanh.truyenhay.Model.Truyen;
import com.vuthanh.truyenhay.R;
import com.vuthanh.truyenhay.database.SQLiteTruyen;

import java.util.ArrayList;

public class Theloai1Activity extends AppCompatActivity {
    SQLiteTruyen sqLiteTruyen;
    ArrayList<Truyen> truyenArrayList;
    TruyenAdapter truyenAdapter;
    ListView listView;
    TextView txtTheloai;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noidung_theloai);

        listView = findViewById(R.id.list_theloai_noidung);
        txtTheloai = (TextView) findViewById(R.id.txt_theloai);

        Intent intent = getIntent();
        String theloai = intent.getStringExtra("theloai");

        txtTheloai.setText(theloai);

        initList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Theloai1Activity.this, NoiDungActivity.class);
                String tentruyen = truyenArrayList.get(position).getTieude();
                String noidung = truyenArrayList.get(position).getNoidung();
                intent.putExtra("tentruyen",tentruyen);
                intent.putExtra("noidung",noidung);
                startActivity(intent);
            }
        });

    }

    private void initList() {
        Intent intent = getIntent();
        String tentheloai = intent.getStringExtra("theloai");
        truyenArrayList = new ArrayList<>();
        sqLiteTruyen = new SQLiteTruyen(this);
        Cursor cursor = sqLiteTruyen.getData1(tentheloai);
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String ten = cursor.getString(1);
            String theloai = cursor.getString(2);
            String noidung = cursor.getString(3);
            String tacgia = cursor.getString(4);

            truyenArrayList.add(new Truyen(id,ten,theloai,noidung,tacgia, R.drawable.sonhaicaotrung));

            truyenAdapter = new TruyenAdapter(getApplicationContext(), truyenArrayList);
            listView.setAdapter(truyenAdapter);
        }
        cursor.moveToFirst();
        cursor.close();
    }
}
