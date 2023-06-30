package com.vuthanh.truyenhay.Model;

public class Theloai {
    private String tenTL;
    private int hinhTL;

    public Theloai(String tenTL, int hinhTL) {
        this.tenTL = tenTL;
        this.hinhTL = hinhTL;
    }

    public String getTenTL() {
        return tenTL;
    }

    public void setTenTL(String tenTL) {
        this.tenTL = tenTL;
    }

    public int getHinhTL() {
        return hinhTL;
    }

    public void setHinhTL(int hinhTL) {
        this.hinhTL = hinhTL;
    }
}
