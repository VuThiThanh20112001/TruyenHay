package com.vuthanh.truyenhay.Model;

public class Admin {
    private String tenadmin;
    private int HinhanhadminSua;

    private int HinhanhadminXoa;

    public Admin(String tenadmin, int hinhanhadminSua, int hinhanhadminXoa) {
        this.tenadmin = tenadmin;
        HinhanhadminSua = hinhanhadminSua;
        HinhanhadminXoa = hinhanhadminXoa;
    }

    public String getTenadmin() {
        return tenadmin;
    }

    public void setTenadmin(String tenadmin) {
        this.tenadmin = tenadmin;
    }

    public int getHinhanhadminSua() {
        return HinhanhadminSua;
    }

    public void setHinhanhadminSua(int hinhanhadminSua) {
        HinhanhadminSua = hinhanhadminSua;
    }

    public int getHinhanhadminXoa() {
        return HinhanhadminXoa;
    }

    public void setHinhanhadminXoa(int hinhanhadminXoa) {
        HinhanhadminXoa = hinhanhadminXoa;
    }
}
