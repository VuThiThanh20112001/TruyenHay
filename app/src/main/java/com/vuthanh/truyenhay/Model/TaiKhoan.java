package com.vuthanh.truyenhay.Model;

public class TaiKhoan {

    //Các biến
    private int mId;
    private String mTenTaiKhoan;
    private String mEmail;
    private String mMatKhau;

    private int mPhanQuyen;

    // Hàm khởi tạo
    public TaiKhoan(String mTenTaiKhoan) {
        this.mTenTaiKhoan = mTenTaiKhoan;
        this.mEmail = mEmail;
        this.mMatKhau = mMatKhau;
        this.mPhanQuyen = mPhanQuyen;
    }




    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTenTaiKhoan() {
        return mTenTaiKhoan;
    }

    public void setmTenTaiKhoan(String mTenTaiKhoan) {
        this.mTenTaiKhoan = mTenTaiKhoan;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmMatKhau() {
        return mMatKhau;
    }

    public void setmMatKhau(String mMatKhau) {
        this.mMatKhau = mMatKhau;
    }


    public int getmPhanQuyen() {
        return mPhanQuyen;
    }

    public void setmPhanQuyen(int mPhanQuyen) {
        this.mPhanQuyen = mPhanQuyen;
    }


}
