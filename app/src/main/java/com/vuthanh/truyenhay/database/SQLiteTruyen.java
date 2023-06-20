package com.vuthanh.truyenhay.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteTruyen extends SQLiteOpenHelper {
    private static String TABLE_NAME = "Truyen";

    //lệnh tạo bảng
    public static final String SQL_Truyen="CREATE TABLE Truyen (" +
            "masach TEXT PRIMARY KEY," +
            "tieude TEXT,"+
            "theloai TEXT," +
            "noidung TEXT," +
            "tacgia TEXT" +
            ");";
    private String SQLite1 = "INSERT INTO Truyen VALUES (1,'Sơn hải cao trung', 'Ngôn tình','Ngày xửa ngày xưa','Gotouge Koyoharu')";

    //1.Hàm tạo csdl
    public SQLiteTruyen(@Nullable Context context) {
        super(context, "QLTruyen.db", null, 1);
    }

    //2.tạo bảng dữ liệu
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_Truyen);//Lệnh tạo bảng truyện
        sqLiteDatabase.execSQL(SQLite1);
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }
    //3.Xoa bang dư liệu cũ, tạo bảng dữ liệu mới
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Truyen");
    }

}
