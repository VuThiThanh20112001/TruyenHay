package com.vuthanh.truyenhay.Model;

public class Truyen {
    private String masach,tieude,theloai,noidung,tacgia;

    public Truyen() {
    }

    public Truyen(String masach,String tieude,String theloai,String noidung,String tacgia) {
        this.masach=masach;
        this.tieude=tieude;
        this.theloai=theloai;
        this.noidung = noidung;
        this.tacgia=tacgia;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }
}
