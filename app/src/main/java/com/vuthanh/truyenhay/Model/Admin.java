package com.vuthanh.truyenhay.Model;

public class Admin {
    private int Id;
    private String tenadmin;

    private String emailadmin;

    private String matkhauadmin;

    private String phanquyenadmin;
//    private int HinhanhHienthi;
//    private int HinhanhadminSua;
//
//    private int HinhanhadminXoa;


    public Admin(int id, String tenadmin, String emailadmin, String matkhauadmin, String phanquyenadmin) {
        Id = id;
        this.tenadmin = tenadmin;
        this.emailadmin = emailadmin;
        this.matkhauadmin = matkhauadmin;
        this.phanquyenadmin = phanquyenadmin;
    }

    public Admin(String tenadmin, String emailadmin, String matkhauadmin, String phanquyenadmin) {
        this.tenadmin = tenadmin;
        this.emailadmin = emailadmin;
        this.matkhauadmin = matkhauadmin;
        this.phanquyenadmin = phanquyenadmin;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenadmin() {
        return tenadmin;
    }

    public void setTenadmin(String tenadmin) {
        this.tenadmin = tenadmin;
    }

    public String getEmailadmin() {
        return emailadmin;
    }

    public void setEmailadmin(String emailadmin) {
        this.emailadmin = emailadmin;
    }

    public String getMatkhauadmin() {
        return matkhauadmin;
    }

    public void setMatkhauadmin(String matkhauadmin) {
        this.matkhauadmin = matkhauadmin;
    }

    public String getPhanquyenadmin() {
        return phanquyenadmin;
    }

    public void setPhanquyenadmin(String phanquyenadmin) {
        this.phanquyenadmin = phanquyenadmin;
    }
}
