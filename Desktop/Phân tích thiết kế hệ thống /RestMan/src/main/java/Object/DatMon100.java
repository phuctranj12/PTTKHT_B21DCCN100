/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

public class DatMon100 {
    private float tongTien;              
    private int tblDatBan100id;         
    private int tblDatCombo100id;       
    private int tblDatMonAn100id;       

    public DatMon100() {
    }

    public DatMon100(float tongTien, int tblDatBan100id, int tblDatCombo100id, int tblDatMonAn100id) {
        this.tongTien = tongTien;
        this.tblDatBan100id = tblDatBan100id;
        this.tblDatCombo100id = tblDatCombo100id;
        this.tblDatMonAn100id = tblDatMonAn100id;
    }

    // Getters and Setters
    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public int getTblDatBan100id() {
        return tblDatBan100id;
    }

    public void setTblDatBan100id(int tblDatBan100id) {
        this.tblDatBan100id = tblDatBan100id;
    }

    public int getTblDatCombo100id() {
        return tblDatCombo100id;
    }

    public void setTblDatCombo100id(int tblDatCombo100id) {
        this.tblDatCombo100id = tblDatCombo100id;
    }

    public int getTblDatMonAn100id() {
        return tblDatMonAn100id;
    }

    public void setTblDatMonAn100id(int tblDatMonAn100id) {
        this.tblDatMonAn100id = tblDatMonAn100id;
    }
}

