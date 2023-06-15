package com.vuthanh.truyenhay.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteTruyen extends SQLiteOpenHelper {
    //lệnh tạo bảng
    public static final String SQL_Truyen="CREATE TABLE Truyen (" +
            "masach TEXT PRIMARY KEY," +
            "tieude TEXT,"+
            "theloai TEXT," +
            "noidung TEXT," +
            "tacgia TEXT" +
            ");";
    //1.Hàm tạo csdl
    public SQLiteTruyen(@Nullable Context context) {
        super(context, "QLTruyen.db", null, 1);
    }

    //2.tạo bảng dữ liệu
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_Truyen);//Lệnh tạo bảng truyện
    }
    //3.Xoa bang dư liệu cũ, tạo bảng dữ liệu mới
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Truyen");
    }
}
