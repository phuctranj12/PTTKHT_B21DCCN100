/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.sql.Timestamp;

public class HoaDonNhap100 {
    private int id;
    private float tongTien;
    private Timestamp thoiGian;
    private int tblNhaCungCap100id;
    private int tblNhanVienKho100stt;

    public HoaDonNhap100() {
    }

    public HoaDonNhap100(int id, float tongTien, Timestamp thoiGian, int tblNhaCungCap100id, int tblNhanVienKho100stt) {
        this.id = id;
        this.tongTien = tongTien;
        this.thoiGian = thoiGian;
        this.tblNhaCungCap100id = tblNhaCungCap100id;
        this.tblNhanVienKho100stt = tblNhanVienKho100stt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public void setThoiGian(Timestamp thoiGian) {
        this.thoiGian = thoiGian;
    }

    public void setTblNhaCungCap100id(int tblNhaCungCap100id) {
        this.tblNhaCungCap100id = tblNhaCungCap100id;
    }

    public void setTblNhanVienKho100stt(int tblNhanVienKho100stt) {
        this.tblNhanVienKho100stt = tblNhanVienKho100stt;
    }

    public int getId() {
        return id;
    }

    public float getTongTien() {
        return tongTien;
    }

    public Timestamp getThoiGian() {
        return thoiGian;
    }

    public int getTblNhaCungCap100id() {
        return tblNhaCungCap100id;
    }

    public int getTblNhanVienKho100stt() {
        return tblNhanVienKho100stt;
    }

   
}
