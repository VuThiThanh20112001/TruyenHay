
package com.vuthanh.truyenhay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.vuthanh.truyenhay.Model.Truyen;
import com.vuthanh.truyenhay.Model.TruyenDAO;
import com.vuthanh.truyenhay.R;

import java.util.ArrayList;
import java.util.List;

public class TruyenActivity extends AppCompatActivity {

    EditText txtMa,txtTieuDe,txtTheLoai,txtNoiDung,txtTacGia;
    Button btnThem,btnSua,btnXoa,btnHienThi;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    TruyenDAO truyenDAO;
    List<String> list = new ArrayList<>();//tạo list rỗng
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen);
        txtMa=findViewById(R.id.editMaSach);
        txtTieuDe=findViewById(R.id.editTieuDe);
        txtTheLoai=findViewById(R.id.editTheLoai);
        txtNoiDung=findViewById(R.id.editNoiDung);
        txtTacGia=findViewById(R.id.editTacGia);
        btnThem=findViewById(R.id.btnThem);
        btnSua=findViewById(R.id.btnSua);
        btnXoa=findViewById(R.id.btnXoa);
        btnHienThi=findViewById(R.id.btnHienThi);
        listView = findViewById(R.id.lv);
        //khởi tạo các biến
        context = this;
        //hiển thị dữ liệu khi chạy chương trình
        list.clear();//xóa hết nội dung trong list
        truyenDAO = new TruyenDAO(context);//tạo csdl và bảng dl
        list=truyenDAO.getAllTruyenToString();
        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);



        //xử lý nút hiển thị
        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();//xóa hết nội dung trong list
                truyenDAO = new TruyenDAO(context);//tạo csdl và bảng dl
                list=truyenDAO.getAllTruyenToString();
                arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
                listView.setAdapter(arrayAdapter);
            }
        });
        //btn Them
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Truyen t = new Truyen();//tạo đối tượng chứa dữ liệu người dùng nhập
                //đưa dữ liệu vào đối tượng
                t.setMasach(txtMa.getText().toString());
                t.setTieude(txtTieuDe.getText().toString());
                t.setTheloai(txtTheLoai.getText().toString());
                t.setNoidung(txtNoiDung.getText().toString());
                t.setTacgia(txtTacGia.getText().toString());
                //gọi hàm insert
                int kq = truyenDAO.InsertTruyen(t);
                if(kq==-1){
                    Toast.makeText(context, "Thêm không thành công", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
               // arrayAdapter.notifyDataSetChanged();
                // Xóa dữ liệu trong các EditText
                txtMa.setText("");
                txtTieuDe.setText("");
                txtTacGia.setText("");
                txtTheLoai.setText("");
                txtNoiDung.setText("");
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masach = txtMa.getText().toString();
                int kq = truyenDAO.DeleteTruyen(masach);
                if(kq==-1){
                    Toast.makeText(context, "xóa không thành công", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, "xóa thành công", Toast.LENGTH_SHORT).show();
                }
                //arrayAdapter.notifyDataSetChanged();
                // Xóa dữ liệu trong các EditText
                txtMa.setText("");
                txtTieuDe.setText("");
                txtTacGia.setText("");
                txtTheLoai.setText("");
                txtNoiDung.setText("");
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Truyen t = new Truyen();//tạo đối tượng chứa dữ liệu người dùng nhập
                //đưa dữ liệu vào đối tượng
                t.setMasach(txtMa.getText().toString());
                t.setTieude(txtTieuDe.getText().toString());
                t.setTheloai(txtTheLoai.getText().toString());
                t.setNoidung(txtNoiDung.getText().toString());
                t.setTacgia(txtTacGia.getText().toString());
                //gọi hàm insert
                int kq = truyenDAO.UpdateTruyen(t);
                if(kq==-1){
                    Toast.makeText(context, "Sửa không thành công", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
                }
                //arrayAdapter.notifyDataSetChanged();
                // Xóa dữ liệu trong các EditText
                txtMa.setText("");
                txtTieuDe.setText("");
                txtTacGia.setText("");
                txtTheLoai.setText("");
                txtNoiDung.setText("");
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String chuoi = listView.getItemAtPosition(position).toString(); // Lấy chuỗi từ ListView tại vị trí được chọn
                String[] chuoiArr = chuoi.split("-"); // Phân tách chuỗi thành mảng các phần tử dựa trên dấu "-"

                // Gán các phần tử từ mảng chuoiArr vào các EditText để chỉnh sửa
                txtMa.setText(chuoiArr[0].trim()); // Mã sách
                txtTieuDe.setText(chuoiArr[1].trim()); // Tiêu đề
                txtTacGia.setText(chuoiArr[2].trim()); // Tác giả
                txtTheLoai.setText(chuoiArr[3].trim()); // Thể loại
                txtNoiDung.setText(chuoiArr[4].trim()); // Nội dung

            }
        });

    }
}