package com.vuthanh.truyenhay.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vuthanh.truyenhay.Adapter.TheloaiAdapter;
import com.vuthanh.truyenhay.Model.Theloai;
import com.vuthanh.truyenhay.R;


import java.util.ArrayList;

public class TheloaiActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Theloai> theloaiArrayList;
    TheloaiAdapter theloaiAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theloai);

        addTheloai();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                for (int i=0; i<=position; i++) {
//                    Intent intent = new Intent(TheloaiActivity.this, Theloai1Activity.class);
//                    intent.putExtra("theloai", theloaiArrayList.get(position).getTenTL());
//                    startActivity(intent);
//                    finish();
//                }

                switch (position) {
                    case 0:
                        Intent intent = new Intent(TheloaiActivity.this, Theloai1Activity.class);
                        intent.putExtra("theloai", theloaiArrayList.get(position).getTenTL());
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(TheloaiActivity.this, Theloai1Activity.class);
                        intent1.putExtra("theloai", theloaiArrayList.get(position).getTenTL());
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(TheloaiActivity.this, Theloai1Activity.class);
                        intent2.putExtra("theloai", theloaiArrayList.get(position).getTenTL());
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(TheloaiActivity.this, Theloai1Activity.class);
                        intent3.putExtra("theloai", theloaiArrayList.get(position).getTenTL());
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(TheloaiActivity.this, Theloai1Activity.class);
                        intent4.putExtra("theloai", theloaiArrayList.get(position).getTenTL());
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(TheloaiActivity.this, Theloai1Activity.class);
                        intent5.putExtra("theloai", theloaiArrayList.get(position).getTenTL());
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(TheloaiActivity.this, Theloai1Activity.class);
                        intent6.putExtra("theloai", theloaiArrayList.get(position).getTenTL());
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(TheloaiActivity.this, Theloai1Activity.class);
                        intent7.putExtra("theloai", theloaiArrayList.get(position).getTenTL());
                        startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(TheloaiActivity.this, Theloai1Activity.class);
                        intent8.putExtra("theloai", theloaiArrayList.get(position).getTenTL());
                        startActivity(intent8);
                        break;
                }
            }
        });
    }

    private void addTheloai() {
        listView = findViewById(R.id.list_theloai);
        theloaiArrayList = new ArrayList<>();
        theloaiArrayList.add(new Theloai("Ngôn tình", R.drawable.hinh1));
        theloaiArrayList.add(new Theloai("Kiếm hiệp", R.drawable.hinh2));
        theloaiArrayList.add(new Theloai("Tiên hiệp", R.drawable.hinh3));
        theloaiArrayList.add(new Theloai("Hài hước", R.drawable.hinh4));
        theloaiArrayList.add(new Theloai("Kinh dị", R.drawable.hinh5));
        theloaiArrayList.add(new Theloai("Viễn tưởng", R.drawable.hinh6));
        theloaiArrayList.add(new Theloai("Phương tây", R.drawable.hinh7));
        theloaiArrayList.add(new Theloai("Cổ trang", R.drawable.hinh8));
        theloaiArrayList.add(new Theloai("Thiếu nhi", R.drawable.hinh9));

        theloaiAdapter = new TheloaiAdapter(this, R.layout.list_theloai,theloaiArrayList);
        listView.setAdapter(theloaiAdapter);
    }
}
