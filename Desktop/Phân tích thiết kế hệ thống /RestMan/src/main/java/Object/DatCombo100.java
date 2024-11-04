/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.sql.Timestamp;

public class DatCombo100 {
    private int id;
    private Timestamp thoiGian;
    private int soLuong;
    private int tblCombo100id;

    public DatCombo100() {
    }

    public DatCombo100(int id, Timestamp thoiGian, int soLuong, int tblCombo100id) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.soLuong = soLuong;
        this.tblCombo100id = tblCombo100id;
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

    public int getTblCombo100id() {
        return tblCombo100id;
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

    public void setTblCombo100id(int tblCombo100id) {
        this.tblCombo100id = tblCombo100id;
    }
    
   
}
