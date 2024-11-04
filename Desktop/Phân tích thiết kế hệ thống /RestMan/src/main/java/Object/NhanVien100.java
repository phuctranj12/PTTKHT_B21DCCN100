/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author anhphuc
 */
public class NhanVien100 extends NguoiDung100{
    private int stt ;
    private int tblNguoiDung100id;
    private String vitri , ten , sdt ;

    public NhanVien100() {
    }

    public NhanVien100(int stt, int tblNguoiDung100id, String vitri, String ten, String sdt) {
        this.stt = stt;
        this.tblNguoiDung100id = tblNguoiDung100id;
        this.vitri = vitri;
        this.ten = ten;
        this.sdt = sdt;
    }

    public NhanVien100(int stt, int tblNguoiDung100id, String vitri, String ten, String sdt, NguoiDung100 user) {
        super(user);
        this.stt = stt;
        this.tblNguoiDung100id = tblNguoiDung100id;
        this.vitri = vitri;
        this.ten = ten;
        this.sdt = sdt;
    }

    public NhanVien100(int stt, int tblNguoiDung100id, String vitri, String ten, String sdt, int userId, String username, String email) {
        super(userId, username, email);
        this.stt = stt;
        this.tblNguoiDung100id = tblNguoiDung100id;
        this.vitri = vitri;
        this.ten = ten;
        this.sdt = sdt;
    }

    public NhanVien100(int stt, int tblNguoiDung100id, String vitri, String ten, String sdt, String username, String password, String email) {
        super(username, password, email);
        this.stt = stt;
        this.tblNguoiDung100id = tblNguoiDung100id;
        this.vitri = vitri;
        this.ten = ten;
        this.sdt = sdt;
    }

    public NhanVien100(int stt, int tblNguoiDung100id, String vitri, String ten, String sdt, int userId, String username, String password, String email) {
        super(userId, username, password, email);
        this.stt = stt;
        this.tblNguoiDung100id = tblNguoiDung100id;
        this.vitri = vitri;
        this.ten = ten;
        this.sdt = sdt;
    }

    public int getStt() {
        return stt;
    }

    public int getTblNguoiDung100id() {
        return tblNguoiDung100id;
    }

    public String getVitri() {
        return vitri;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public void setTblNguoiDung100id(int tblNguoiDung100id) {
        this.tblNguoiDung100id = tblNguoiDung100id;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
