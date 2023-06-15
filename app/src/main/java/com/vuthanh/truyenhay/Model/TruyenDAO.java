package com.vuthanh.truyenhay.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vuthanh.truyenhay.database.SQLiteTruyen;

import java.util.ArrayList;
import java.util.List;

//lớp truy cập dữ liệu
public class TruyenDAO {
    private SQLiteDatabase db;
    private SQLiteTruyen dbTruyen;
    private Context context;

    public TruyenDAO(Context context) {
        this.context = context;
        dbTruyen = new SQLiteTruyen(context);//thực thi tạo database
        db=dbTruyen.getWritableDatabase();//cho phép ghi dữ liệu vào database
    }
    //1.Thêm dữ liệu
    public int InsertTruyen(Truyen t){
        ContentValues values = new ContentValues();//tạo đối tượng chứa dữ liệu
        //đưa dữ liệu vào đối tượng chứa
        values.put("masach",t.getMasach());
        values.put("tieude",t.getTieude());
        values.put("theloai",t.getTheloai());
        values.put("noidung",t.getNoidung());
        values.put("tacgia",t.getTacgia());
        //thực thi insert
        long kq=db.insert("Truyen",null,values);
        //Kiểm tra kết quả insert
        if(kq<=0){
            return -1;//insert thất bại
        }
        return 1;//thành công
    }
    //2.Hiển thị dữ liệu dạng string
    public List<String> getAllTruyenToString(){
        List<String> ls=new ArrayList<>();//Tạo danh sách rỗng
        //Tạo con trỏ đọc bảng dữ liệu Truyen
        Cursor c=db.query("Truyen",null,null,null,null,null,null);
        c.moveToFirst();//di chuyển con trỏ về bản ghi đầu tiên
        //doc
        while(c.isAfterLast()==false)//trong khi không phải dòng ghi cuối cùng thì vẫn đọc
        {
            Truyen t = new Truyen();//tạo đối tượng chưa dữ liệu
            t.setMasach(c.getString(0));
            t.setTieude(c.getString(1));//đọc dữ liệu trường tiêu đề và đưa vào dữ liệu
            t.setTheloai(c.getString(2));
            t.setNoidung(c.getString(3));
            t.setTacgia(c.getString(4));
            //chuyển đối tượng thành chuỗi
            String chuoi = t.getMasach()+" - "+t.getTieude()+"-"+t.getTacgia()+"-" + t.getTheloai()+"-"+t.getNoidung();
            ls.add(chuoi);
            c.moveToNext();//di chuyển đến bản ghi tiếp theo
        }
        c.close();//đóng con trỏ
        return ls;
    }
    //xóa
    public int DeleteTruyen(String masach){
        //thực thi xóa
        int kq=db.delete("Truyen","masach=?",new String[]{masach});
        if(kq<=0){
            return -1;//xóa thất bại
        }
        return 1;//thành công
        }
        //sửa
        public int UpdateTruyen(Truyen t){
            ContentValues values = new ContentValues();//tạo đối tượng chứa dữ liệu
            //đưa dữ liệu vào đối tượng chứa
            values.put("masach",t.getMasach());
            values.put("tieude",t.getTieude());
            values.put("theloai",t.getTheloai());
            values.put("noidung",t.getNoidung());
            values.put("tacgia",t.getTacgia());
            //thực thi update
            long kq=db.update("Truyen",values,"masach=?",new String[]{t.getMasach()});
            //Kiểm tra kết quả insert
            if(kq<=0){
                return -1;//insert thất bại
            }
            return 1;//thành công
        }

}
