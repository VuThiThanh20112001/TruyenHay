package com.vuthanh.truyenhay.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.vuthanh.truyenhay.Model.TaiKhoan;

public class database_dangnhap extends SQLiteOpenHelper {

    // Cơ sở dữ liệu

    // Tên database
    private static String DATABASE_NAME = "truyenhay";

    // Biến bảng tài khoản
    private static String TABLE_TAIKHOAN = "taikhoan";
    private static String ID_TAIKHOAN = "idtaikhoan";
    private static String TEN_TAIKHOAN = "tentaikhoan";
    private static String MAT_KHAU = "matkhau";
    private static String PHAN_QUYEN = "phanquyen";
    private static String EMAIL = "email";
    private  static String NHAP_LAI_MK = "nhaplaimk";


    // vesion
    private static int VERSION = 1;

    //context
    private Context context;

    // Biến lưu câu lệnh bảng tài khoản
    private String SQLQuery = " CREATE TABLE " + TABLE_TAIKHOAN + "(" +ID_TAIKHOAN+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +TEN_TAIKHOAN+" TEXT UNIQUE,"
            +EMAIL+" TEXT UNIQUE,"
            +MAT_KHAU+" TEXT,"
            +PHAN_QUYEN+" INTEGER)";

    //Insert dữ liệu vào bảng tài khoản
    // Chú ý:  1.admin  và  2.người dùng
    private String SQLQuery2 = "INSERT INTO TaiKhoan VALUES (null,'vuthithanh','vuthithanh@gmail.com','250702',1)";
    private String SQLQuery3 = "INSERT INTO TaiKhoan VALUES (null,'nguyenngocyennhi','nguyenngocyennhi@gmail.com','250702',1)";
    private String SQLQuery4 = "INSERT INTO TaiKhoan VALUES (null,'nguyenthituoi','nguyenthituoi@gmail.com','250702',1)";
    private String SQLQuery5 = "INSERT INTO TaiKhoan VALUES (null,'nguyenvankhanh','khanh01@gmail.com','12345',2)";
    private String SQLQuery6 = "INSERT INTO TaiKhoan VALUES (null,'nguyenthihoa','nguyenthihoa@gmail.com','56789',2)";

    // Tạo bảng tại phương thức này
    public database_dangnhap(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Thực hiện các câu lệnh không trả về kết quả
        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery2);
        db.execSQL(SQLQuery3);
        db.execSQL(SQLQuery4);
        db.execSQL(SQLQuery5);
        db.execSQL(SQLQuery6);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Phương thức lấy tất cả các tài khoản
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(" SELECT * FROM "+TABLE_TAIKHOAN, null);
        return res;
    }

    // phương thức thêm tài khoản vào database
    public void AddTaiKhoan(TaiKhoan taiKhoan){
        SQLiteDatabase db = this.getWritableDatabase();

        // Thực hiện insert thông qua ContenValues
        ContentValues values = new ContentValues();
        values.put(TEN_TAIKHOAN,taiKhoan.getmTenTaiKhoan());
        values.put(EMAIL,taiKhoan.getmEmail());
        values.put(MAT_KHAU,taiKhoan.getmMatKhau());
        values.put(PHAN_QUYEN,taiKhoan.getmPhanQuyen());

        db.insert(TABLE_TAIKHOAN, null,values);

        // đóng lại khi không dùng
        db.close();
        Log.e("ADD TK", "TC");

    }

}
