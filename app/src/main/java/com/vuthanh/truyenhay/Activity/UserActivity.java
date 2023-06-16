package com.vuthanh.truyenhay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.vuthanh.truyenhay.Adapter.SelectedAdapter;
import com.vuthanh.truyenhay.Model.Selected;
import com.vuthanh.truyenhay.Model.TaiKhoan;
import com.vuthanh.truyenhay.R;
import com.vuthanh.truyenhay.database.database_dangnhap;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    private Spinner spnPhanQuyen;
    private SelectedAdapter selectedAdapter;

    EditText editTaiKhoan, editEmail;
    Button btnThemUser, btnSuaUser, btnXoaUser, btnHienthiUser;

    ListView listViewUser;

    database_dangnhap database_dangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        database_dangnhap = new database_dangnhap(this);

//        editTaiKhoan = findViewById(R.id.editTaiKhoan);
//        editEmail = findViewById(R.id.editEmail);
//        spnPhanQuyen = findViewById(R.id.spn_phanquyen);
//        btnThemUser = findViewById(R.id.btnThemUser);
//        btnSuaUser = findViewById(R.id.btnSuaUser);
//        btnXoaUser = findViewById(R.id.btnXoaUser);
//        btnHienthiUser = findViewById(R.id.btnHienThiUser);

        selectedAdapter = new SelectedAdapter(this, R.layout.item_selected, getListSelected());
        spnPhanQuyen.setAdapter(selectedAdapter);


        spnPhanQuyen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(UserActivity.this, selectedAdapter.getItem(position).getPhanquyen(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //button Thêm
//        btnThemUser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String tentaikhoan = editTaiKhoan.getText().toString();
//                String email = editEmail.getText().toString();
//                String phanquyen = spnPhanQuyen.getSelectedItem().toString();
//
//                TaiKhoan taiKhoan = CreateTaiKhoan();
//
//                if(taiKhoan.equals("") || email.equals("") || phanquyen.equals("")){
//                    Toast.makeText(UserActivity.this, "Yêu cầu nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
//                    Log.e("ERR : ", "Nhập đầy đủ thông tin");
//                }
//                // Nếu nhậpầy đủ thông tin thì thực hiện thêm dữ liệu
//                else {
//                    database_dangnhap.AddTaiKhoan(taiKhoan);
//
//                    //Chuyển qua màn User và cập nhật lại dữ liệu
//
//                    Intent intent = new Intent(UserActivity.this, MainActivity.class);
//                    finish();
//                    startActivity(intent);
//                }
//
//            }
//        });

    }



    private List<Selected> getListSelected(){
        List<Selected> list = new ArrayList<>();

        list.add(new Selected("1"));
        list.add(new Selected("2"));

        return list;

    }

//    private TaiKhoan CreateTaiKhoan(){
//
//        String tentaikhoan = editTaiKhoan.getText().toString();
//        String email = editEmail.getText().toString();
//        String phanquyen = spnPhanQuyen.getSelectedItem().toString();
//
//        Intent intent = getIntent();
//
//        int id = intent.getIntExtra("Id", 0);
//
//        TaiKhoan taiKhoan = new TaiKhoan(tentaikhoan);
//        return taiKhoan;
//    }


}