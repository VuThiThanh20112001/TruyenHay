package com.vuthanh.truyenhay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vuthanh.truyenhay.Model.Admin;
import com.vuthanh.truyenhay.R;
import com.vuthanh.truyenhay.database.database_dangnhap;

public class SuaThongTinTKActivity extends AppCompatActivity {

    TextView edtSuaTK, edtSuaEmail, edtSuaMatKhau, edtSuaPhanQuyen;

    Button btnSuaTK;

    database_dangnhap database_dangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_thong_tin_tk);

        edtSuaTK = findViewById(R.id.editSuaTaiKhoan);
        edtSuaEmail = findViewById(R.id.editSuaEmail);
        edtSuaMatKhau = findViewById(R.id.editSuaMatKhau);
        edtSuaPhanQuyen = findViewById(R.id.editSuaPhanQuyen);
        btnSuaTK = findViewById(R.id.btnSuaTaiKhoan);

        // lấy dữ liệu intent
        Intent intent = getIntent();

        int id = intent.getIntExtra("id", 0);
        String tenadmin = intent.getStringExtra("Tên tài khoản");
        String emailadmin = intent.getStringExtra("Email");
        String matkhauadmin = intent.getStringExtra("Mật khẩu");
        String phanquyenadmin = intent.getStringExtra("Phân quyền");

        edtSuaTK.setText(tenadmin);
        edtSuaEmail.setText(emailadmin);
        edtSuaMatKhau.setText(matkhauadmin);
        edtSuaPhanQuyen.setText(phanquyenadmin);

        database_dangnhap = new database_dangnhap(this);

        btnSuaTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUpdate(id);
            }
        });



    }

    private void DialogUpdate(int id){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogupdate);
        dialog.setCanceledOnTouchOutside(false);

        Button btnSuaYes = dialog.findViewById(R.id.buttonUpdateYes);
        Button btnSuaNo = dialog.findViewById(R.id.buttonUpdateNo);

        btnSuaYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenadmin = edtSuaTK.getText().toString().trim();
                String emailadmin = edtSuaEmail.getText().toString().trim();
                String matkhauadmin = edtSuaMatKhau.getText().toString().trim();
                String phanquyenadmin = edtSuaPhanQuyen.getText().toString().trim();

                Admin admin = UpdateAdmin();
                // nếu dữ liệu chưa nhập đủ
                if(tenadmin.equals("") || emailadmin.equals("") || matkhauadmin.equals("") || phanquyenadmin.equals("")){
                    Toast.makeText(SuaThongTinTKActivity.this, "Bạn chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    // gán cho đối tượng admin giá trị đc nhập vào


                    //thêm vào trong database
                    database_dangnhap.UpdateAdmin(admin, id);
                    Toast.makeText(SuaThongTinTKActivity.this, "Sửa thông tin tài khoản thành công", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SuaThongTinTKActivity.this, AdminActivity.class);
                    startActivity(intent);


                }
            }
        });

        btnSuaNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }


    private Admin UpdateAdmin(){

        String tenadmin = edtSuaTK.getText().toString().trim();
        String emailadmin = edtSuaEmail.getText().toString().trim();
        String matkhauadmin = edtSuaMatKhau.getText().toString().trim();
        String phanquyenadmin = edtSuaPhanQuyen.getText().toString().trim();
        //  String phanquyenadmin = spnPhanQuyen.getSelectedItem().toString().trim();

        Admin admin = new Admin(tenadmin,emailadmin,matkhauadmin,phanquyenadmin);

        return admin;
    }

}