/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.sql.Timestamp;

public class DatMonAn100 {
    private int id;
    private Timestamp thoiGian;
    private int soLuong;
    private int tblMonAn100id;

    public DatMonAn100() {
    }

    public DatMonAn100(int id, Timestamp thoiGian, int soLuong, int tblMonAn100id) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.soLuong = soLuong;
        this.tblMonAn100id = tblMonAn100id;
    }

    public int getId() {
        return id;
    }

    public Timestamp getThoiGian() {
        return thoiGian;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getTblMonAn100id() {
        return tblMonAn100id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setThoiGian(Timestamp thoiGian) {
        this.thoiGian = thoiGian;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setTblMonAn100id(int tblMonAn100id) {
        this.tblMonAn100id = tblMonAn100id;
    }

    
}
