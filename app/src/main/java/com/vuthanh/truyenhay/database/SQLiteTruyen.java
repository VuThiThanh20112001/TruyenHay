package com.vuthanh.truyenhay.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteTruyen extends SQLiteOpenHelper {
    private static String TABLE_NAME = "Truyen";
    private static String THELOAI = "theloai";


    //lệnh tạo bảng
    public static final String SQL_Truyen="CREATE TABLE Truyen (" +
            "masach TEXT PRIMARY KEY," +
            "tieude TEXT,"+
            "theloai TEXT," +
            "noidung TEXT," +
            "tacgia TEXT" +
            ");";
    private String SQLite1 = "INSERT INTO Truyen VALUES (1,'HẠ VI CHU MINH', 'Ngôn tình','Đêm Hạ.\n" +
            "\n" +
            "Tiếng ho khan đứt quãng từ bên trong màn truyền ra, kèm theo đó là tiếng thở dốc yếu ớt. Một lúc sau, tiếng ho khan mới dần dần ngừng lại, tiếp đó một bàn tay thon dài nhưng tái nhợt từ trong màn vươn ra, nhẹ nhàng vén tấm màn lên.\n" +
            "\n" +
            "Hiện tại đang là giữa mùa Hạ, không khí oi bức và nhớp nháp, nhưng trên giường lại được bao phủ bởi một lớp chăn dày tựa như những ngày trời đông lạnh lẽo. Người trên giường do dự một lúc, cuối cùng vẫn chọn tự mình xuống giường mà không đánh thức gã sai vặt đang nghỉ ngơi ở bên ngoài phòng.\n" +
            "\n" +
            "Tư Liên chậm rãi đi đến trước bàn, vươn tay rót cho mình một ly nước rồi uống một hơi cạn sạch, sau đó cảm thấy không đủ lại rót thêm ly nữa. Mới vừa rồi hắn vì ho mà tỉnh giấc, cổ họng ngứa vô cùng, uống cạn hai ly nước lập tức cảm thấy dễ chịu hơn rất nhiều.\n" +
            "\n" +
            "Đột nhiên cảm thấy bên tai thoáng qua một chút mát lạnh. Tư Liên nghiêng người, nhìn thấy trong phòng có một cánh cửa sổ còn chưa được khép chặt, gió đêm mang theo hơi nước mát lạnh khẽ lẻn vào phòng hắn qua khe hở đó. Mùi thuốc Đông y đắng ngắt trong phòng bỗng chốc nhạt đi không ít.','Khúc An Nhị Hào')";
    private String SQLite2 = "INSERT INTO Truyen VALUES (2,'Nguyên tôn', 'Kiếm hiệp','Bên trong nội điện đèn đuốc sáng trưng, xa hoa tráng lệ, khí thế uy nghiêm, bên trong điện có thắp trường minh đăng, bên trong đang đốt một viên đá xanh, khói xanh lượn lờ bay lên, vấn vít trong điện.\n" +
            "\n" +
            "Đó chính là thanh đàn thạch, khi đốt cháy sẽ tỏa ra một hương thơm lạ lùng, có hiệu quả ngưng thần tĩnh khí, là vật cần chuẩn bị cho những lúc tu luyện, bất quá giá cả của thứ này cũng không rẻ, có thể dùng nó như một loại hương liệu thế này, đủ để nói rõ chủ nhân của nơi đây có địa vị không tầm thường.\n" +
            "\n" +
            "Bên trong nội điện, một nam tử trung niên thân mặc y phục màu vàng sáng đang chắp tay đứng, hắn có gương mặt kiên nghị, trong mắt lộ ra vẻ uy nghiêm, rõ ràng có địa vị cao, mà sau lưng của hắn thì ẩn ẩn có khí tức bốc lên, tựa như lửa cháy lại như sấm dậy, phát ra tiếng nổ vang trầm thấp.\n" +
            "\n" +
            "Chẳng qua, nếu như nhìn về phía cánh tay phải của hắn thì sẽ phát hiện nó trống không, bởi vì đã cụt một tay.\n" +
            "\n" +
            "Còn có một mỹ phụ vận cung trang đứng bên cạnh hắn, nàng có thân hình mảnh mai, dung mạo xinh đẹp lại thong dong, bất quá trên mặt nàng vẫn lộ ra vẻ suy yếu nhợt nhạt.','Thiên Tằm Thổ Đậu')";
    private String SQLite3 = "INSERT INTO Truyen VALUES (3,'ĐỘC TÔN TAM GIỚI', 'Tiên hiệp','Giang Trần cảm giác dường như trong đầu mình loạn thành một đoàn bột nhão, cảm giác này giống như là đang nằm mơ, nhưng nằm mơ thì không thể nào chân thật đến mức này được. Mỗi một tấc da thịt quanh thân, mỗi một khối xương cốt, đều đau đớn không chịu nổi.\n" +
            "\n" +
            "- Ta đã chết rồi sao? Đang chịu nỗi khổ luyện thân trong mấy tầng địa ngục sao ?\n" +
            "\n" +
            "Trực giác đầu tiên của Giang Trần là cảm giác mình đã chết. Thế nhưng, Sinh Mệnh Khí Tức như có như không của thân thể, lại phảng phất đang nhắc nhở hắn, hắn còn sống.\n" +
            "\n" +
            "Cũng không biết cảm giác như vậy giằng co bao lâu. Trong giây lát, Giang Trần cố gắng mở mắt ra, lại phát hiện mình nằm ở trong một bộ quan tài.\n" +
            "\n" +
            "\n" +
            "Nằm ở trong quan tài? Nói như vậy, mình là thật đã chết? Giang Trần lòng tràn đầy bi thương.\n" +
            "\n" +
            "- Đáng tiếc đáng buồn, Giang Trần ta thân là Thiên Đế chi tử, lại trời sinh Thái Âm Chi Thể, không thể tu luyện võ đạo. Dù có phụ hoàng luyện chế Nhật Nguyệt Thần Đan cho ta, để cho ta thọ cùng trời đất, kết quả Thiên Đạo hạo kiếp buông xuống, lại thành vướng víu của phụ thân, cuối cùng tránh không được vận mệnh bỏ mình. . .\n" +
            "\n" +
            "- Ồ? Kinh mạch của ta là chuyện gì xảy ra? Thậm chí có chân khí chạy! Tuy rất nhỏ. . . Không đúng! Cái này. . . Đây không phải thân thể của ta, đây tuyệt đối không phải là nhục thể của ta! Ta trời sinh Thái Âm Chi Thể, trong cơ thể làm sao có thể có chân khí du động?','Lê Thiên')";
    private String SQLite4 = "INSERT INTO Truyen VALUES (4,'AI ĐÃ ĐỘNG TỚI CÂY XƯƠNG RỒNG CỦA TÔI', 'Hài hước','“Ai vặt hết gai cây xương rồng của tôi?”\n" +
            "\n" +
            "Hình ảnh đính kèm là một chậu xương rồng trụi gai.\n" +
            "\n" +
            "Sau khi tiện tay lướt tới “lệnh truy nã” trên diễn đàn trường, tôi như cá chép lộn người, từ kẻ đang hấp hối trên giường bệnh bật dậy.\n" +
            "\n" +
            "Hôm qua tôi vừa đi vừa chửi tên sở khanh khốn kiếp qua điện thoại. Lúc đi ngang ký túc xá nam thì tiện tay gây hại cho cây xanh ngoài ban công tầng một. Nhưng tôi đã để lại phương thức liên lạc nói mình sẽ bồi thường.\n" +
            "\n" +
            "Có lẽ tờ giấy bị gió cuốn bay mất, đệt mợ cũng may là bị thổi bay rồi, ai mà biết cây đó là của trùm trường Yến Tử An chứ!\n" +
            "\n" +
            "Tay run rẩy, bình luận dưới bài đăng: “Thuần túy là khách qua đường, hình như gai xương rồng sẽ tự nhiên rụng, nén bi thương, tôi là người qua đường thuần túy thôi nhé.”\n" +
            "\n" +
            "\n" +
            "Yến Tử An nhanh chóng trả lời: “Vậy cây sen đá bên cạnh nó cũng tự nhiên mọc gai lên à?”\n" +
            "\n" +
            "Hình ảnh đi kèm là một chậu sen đá đầy gai.\n" +
            "\n" +
            "Khu bình luận lập tức xuất hiện không ít quần chúng vây xem, sôi nổi bênh vực kẻ yếu:\n" +
            "\n" +
            "“Thế gian suy đồi, lòng người không đổi.”\n" +
            "\n" +
            "“Ha ha ha ha ha vừa tội vừa buồn cười.”','Zhihu')";
    private String SQLite5 = "INSERT INTO Truyen VALUES (5,'PHÁP SƯ MẠNH NHẤT', 'Phương tây','Đêm tối, trong một khu rừng nhiều quỷ thú, một cậu bé tầm 12 tuổi, dáng người nhỏ nhắn đang ôm một cánh tay chảy máu mà cố chạy.\n" +
            "\n" +
            "Phía sau cậu, một bọn áo đen đang phóng như bay đuổi theo.\n" +
            "\n" +
            "Cậu bé thở từng hơi đứt quoảng, máu từ cánh tay trái chảy ra ướt đẩm cả áo.Tên cậu là Mike John, đứa con của gia tộc pháp sư.','Lý Hồ Ân')";
    private String SQLite6 = "INSERT INTO Truyen VALUES (6,'Chó sói và cậu bé chăn cừu', 'Thiếu nhi','Truyện ngắn thiếu nhi hay này kể về cậu bé nọ sống cùng cha trong một ngôi làng. Công việc của cậu là chăn bầy cừu giúp cha mình. Hằng ngày, cậu đưa bầy cừu lên sườn đồi để chúng gặm cỏ, chiều đến lại lùa cừu về. Công việc cứ thế lặp đi lặp lại nên cậu không mấy vui vẻ.\n" +
            "\n" +
            "Một ngày nọ, cậu nảy ra ý tưởng trêu đùa mọi người và liền hét to:\n" +
            "\n" +
            "– Sói! Sói! Có chó sói…\n" +
            "\n" +
            "Tiếng la ấy làm kinh động đến những người trong làng và họ liền đổ xô chạy ra để đuổi bọn sói. Khi đến nơi, mọi người mới vỡ lẽ rằng chẳng có con sói nào cả. Biết mình bị lừa, mọi người ai nấy trở về nhà trong sự bực dọc.\n" +
            "\n" +
            "Nhưng rồi điều không may đã xảy ra với cậu bé kia khi bỗng một ngày, lũ sói từ đâu xuất hiện và tấn công đàn cừu. Cậu bé kêu cứu nhưng không một ai đáp lại. Bởi lẽ, mọi người nghĩ rằng, hẳn đây là một trò đùa tai quái của cậu nên chẳng ai bận tâm. Kết cuộc là cậu bé ấy đành bất lực chứng kiến bầy cừu trở thành bữa ăn của đàn sói hoang tàn độc.\n" +
            "\n" +
            "Bài học rút ra từ truyện ngắn thiếu nhi Chó sói và cậu bé chăn cừu: Được xếp là một trong những truyện ngắn thiếu nhi hay, chó sói và cậu bé chăn cừu mang đến cho bé một bài học: hãy luôn luôn trung thực trong mọi tình huống.','')";
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
        sqLiteDatabase.execSQL(SQLite3);
        sqLiteDatabase.execSQL(SQLite4);
        sqLiteDatabase.execSQL(SQLite5);
        sqLiteDatabase.execSQL(SQLite6);


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

    public Cursor getData1(String i) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM " + TABLE_NAME + " WHERE " + THELOAI + " ='"+i+"'", null);
        return cursor;
    }

}
