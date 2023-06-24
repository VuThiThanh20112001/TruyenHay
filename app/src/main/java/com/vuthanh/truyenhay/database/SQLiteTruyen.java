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
    private String SQLite2 = "INSERT INTO Truyen VALUES (3,'Nguyên tôn', 'Kiếm hiệp','Bên trong nội điện đèn đuốc sáng trưng, xa hoa tráng lệ, khí thế uy nghiêm, bên trong điện có thắp trường minh đăng, bên trong đang đốt một viên đá xanh, khói xanh lượn lờ bay lên, vấn vít trong điện.\n" +
            "\n" +
            "Đó chính là thanh đàn thạch, khi đốt cháy sẽ tỏa ra một hương thơm lạ lùng, có hiệu quả ngưng thần tĩnh khí, là vật cần chuẩn bị cho những lúc tu luyện, bất quá giá cả của thứ này cũng không rẻ, có thể dùng nó như một loại hương liệu thế này, đủ để nói rõ chủ nhân của nơi đây có địa vị không tầm thường.\n" +
            "\n" +
            "Bên trong nội điện, một nam tử trung niên thân mặc y phục màu vàng sáng đang chắp tay đứng, hắn có gương mặt kiên nghị, trong mắt lộ ra vẻ uy nghiêm, rõ ràng có địa vị cao, mà sau lưng của hắn thì ẩn ẩn có khí tức bốc lên, tựa như lửa cháy lại như sấm dậy, phát ra tiếng nổ vang trầm thấp.\n" +
            "\n" +
            "Chẳng qua, nếu như nhìn về phía cánh tay phải của hắn thì sẽ phát hiện nó trống không, bởi vì đã cụt một tay.\n" +
            "\n" +
            "Còn có một mỹ phụ vận cung trang đứng bên cạnh hắn, nàng có thân hình mảnh mai, dung mạo xinh đẹp lại thong dong, bất quá trên mặt nàng vẫn lộ ra vẻ suy yếu nhợt nhạt.','Thiên Tằm Thổ Đậu')";


    //1.Hàm tạo csdl
    public SQLiteTruyen(@Nullable Context context) {
        super(context, "QLTruyen.db", null, 1);
    }

    //2.tạo bảng dữ liệu
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_Truyen);//Lệnh tạo bảng truyện
        sqLiteDatabase.execSQL(SQLite1);
        sqLiteDatabase.execSQL(SQLite2);

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
