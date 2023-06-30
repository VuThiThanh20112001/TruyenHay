package com.vuthanh.truyenhay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.vuthanh.truyenhay.Model.Admin;
import com.vuthanh.truyenhay.R;
import com.vuthanh.truyenhay.database.database_dangnhap;

public class AddTaiKhoanActivity extends AppCompatActivity {


    EditText editTaiKhoan, editEmail, editMatKhau, editPhanQuyen;
    Button btnThemTaiKhoan;

    ListView listViewAdmin;

    database_dangnhap database_dangnhap;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tai_khoan);

        database_dangnhap = new database_dangnhap(this);


        editTaiKhoan = findViewById(R.id.editTaiKhoan);
        editEmail = findViewById(R.id.editEmail);
        editMatKhau = findViewById(R.id.editMatKhau);
        editPhanQuyen = findViewById(R.id.editPhanQuyen);
        btnThemTaiKhoan = findViewById(R.id.btnThemTaiKhoan);



        btnThemTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAdd();
            }
        });


    }


    private void DialogAdd(){

        // tạo đối tượng của sổ
        Dialog dialog = new Dialog(this);

        // nạp layout vào dialog
        dialog.setContentView(R.layout.dialogadd);

        //tắt lick ngoài là thoát

        dialog.setCanceledOnTouchOutside(false);

        Button btnYes = dialog.findViewById(R.id.buttonYes);
        Button btnNo = dialog.findViewById(R.id.buttonNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenadmin = editTaiKhoan.getText().toString().trim();
                String emailadmin = editEmail.getText().toString().trim();
                String matkhauadmin = editMatKhau.getText().toString().trim();
                String phanquyenadmin = editPhanQuyen.getText().toString().trim();
            //    String phanquyenadmin = spnPhanQuyen.getSelectedItem().toString().trim();

                Admin admin1 = CreatAdmin();
                // nếu dữ liệu chưa nhập đủ
                if(tenadmin.equals("") || emailadmin.equals("") || matkhauadmin.equals("") || phanquyenadmin.equals("")){
                    Toast.makeText(AddTaiKhoanActivity.this, "Bạn chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    // gán cho đối tượng admin giá trị đc nhập vào


                    //thêm vào trong database
                    database_dangnhap.AddAdmin(admin1);
                    Toast.makeText(AddTaiKhoanActivity.this, "Thêm tài khoản thành công", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(AddTaiKhoanActivity.this, AdminActivity.class);
                    startActivity(intent);


                }
            }
        });

        // nếu không add nữa
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        // show dialog
        dialog.show();

    }



    private Admin CreatAdmin(){

        String tenadmin = editTaiKhoan.getText().toString().trim();
        String emailadmin = editEmail.getText().toString().trim();
        String matkhauadmin = editMatKhau.getText().toString().trim();
        String phanquyenadmin = editPhanQuyen.getText().toString().trim();


        Admin admin = new Admin(tenadmin,emailadmin,matkhauadmin,phanquyenadmin);

        return admin;
    }



}