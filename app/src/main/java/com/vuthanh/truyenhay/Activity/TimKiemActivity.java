package com.vuthanh.truyenhay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.vuthanh.truyenhay.Adapter.TruyenAdapter;
import com.vuthanh.truyenhay.Model.Truyen;
import com.vuthanh.truyenhay.R;
import com.vuthanh.truyenhay.database.SQLiteTruyen;

import java.util.ArrayList;

public class TimKiemActivity extends AppCompatActivity {
    ListView listView;
    EditText edtTimkiem;
    ArrayList<Truyen> truyenArrayList;
    ArrayList<Truyen> arrayList;
    TruyenAdapter truyenAdapter;
    SQLiteTruyen sqLiteTruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timkiem);

        listView = findViewById(R.id.lisv_truyen);
        edtTimkiem = findViewById(R.id.edt_timkiem);

        initList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TimKiemActivity.this, NoiDungActivity.class);
                String tentruyen = arrayList.get(position).getTieude();
                String noidung = arrayList.get(position).getNoidung();
                intent.putExtra("tentruyen",tentruyen);
                intent.putExtra("noidung",noidung);
                startActivity(intent);
            }
        });

        //editText search
        edtTimkiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }
    //search
    private void filter(String text) {
        //xóa dl mảng
        arrayList.clear();
        ArrayList<Truyen> filteredlist = new ArrayList<>();

        for (Truyen item : truyenArrayList) {
            if (item.getTieude().toLowerCase().contains(text.toLowerCase())) {
                //thêm item vào filteredlist
                filteredlist.add(item);
                //thêm vào mảng
                arrayList.add(item);
            }
        }
        truyenAdapter.filterList(filteredlist);
    }
    private void initList() {
        truyenArrayList = new ArrayList<>();
        arrayList = new ArrayList<>();
        sqLiteTruyen = new SQLiteTruyen(this);
        Cursor cursor = sqLiteTruyen.getData();
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String ten = cursor.getString(1);
            String theloai = cursor.getString(2);
            String noidung = cursor.getString(3);
            String tacgia = cursor.getString(4);

            truyenArrayList.add(new Truyen(id,ten,theloai,noidung,tacgia, R.drawable.sonhaicaotrung));
            arrayList.add(new Truyen(id,ten,theloai,noidung,tacgia, R.drawable.sonhaicaotrung));

            truyenAdapter = new TruyenAdapter(getApplicationContext(), truyenArrayList);
            listView.setAdapter(truyenAdapter);
        }
        cursor.moveToFirst();
        cursor.close();
    }
}