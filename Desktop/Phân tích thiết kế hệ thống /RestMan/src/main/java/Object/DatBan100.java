/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.sql.Timestamp;

public class DatBan100 {
    private int id;
    private String trangThaiDon;
    private Timestamp thoiGian;
    private int tblNhanVienBanHang100stt;
    private int tblBan100id;
    private int tblKhachHang100id;

    public DatBan100() {
    }

    public DatBan100(int id, String trangThaiDon, Timestamp thoiGian, int tblNhanVienBanHang100stt, int tblBan100id, int tblKhachHang100id) {
        this.id = id;
        this.trangThaiDon = trangThaiDon;
        this.thoiGian = thoiGian;
        this.tblNhanVienBanHang100stt = tblNhanVienBanHang100stt;
        this.tblBan100id = tblBan100id;
        this.tblKhachHang100id = tblKhachHang100id;
    }
    public DatBan100(KhachHang100 kh , Ban100 ban , Timestamp thoiGian , int sttNhanVienBanHang , String trangThaiDon ){
        this.trangThaiDon = trangThaiDon;
        this.thoiGian = thoiGian;
        this.tblNhanVienBanHang100stt = sttNhanVienBanHang;
        this.tblBan100id = ban.getId();
        this.tblKhachHang100id = kh.getUserId();
    }

    public int getId() {
        return id;
    }

    public String getTrangThaiDon() {
        return trangThaiDon;
    }

    public Timestamp getThoiGian() {
        return thoiGian;
    }

    public int getTblNhanVienBanHang100stt() {
        return tblNhanVienBanHang100stt;
    }

    public int getTblBan100id() {
        return tblBan100id;
    }

    public int getTblKhachHang100id() {
        return tblKhachHang100id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTrangThaiDon(String trangThaiDon) {
        this.trangThaiDon = trangThaiDon;
    }

    public void setThoiGian(Timestamp thoiGian) {
        this.thoiGian = thoiGian;
    }

    public void setTblNhanVienBanHang100stt(int tblNhanVienBanHang100stt) {
        this.tblNhanVienBanHang100stt = tblNhanVienBanHang100stt;
    }

    public void setTblBan100id(int tblBan100id) {
        this.tblBan100id = tblBan100id;
    }

    public void setTblKhachHang100id(int tblKhachHang100id) {
        this.tblKhachHang100id = tblKhachHang100id;
    }

   
}

