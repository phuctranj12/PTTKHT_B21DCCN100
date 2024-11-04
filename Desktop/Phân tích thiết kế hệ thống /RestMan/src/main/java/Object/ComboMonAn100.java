/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

public class ComboMonAn100 {
    private int id;
    private int monAn100Id;
    private int combo100Id;
    private int soLuong;
    private float tongTien;

    public ComboMonAn100() {
    }

    public ComboMonAn100(int id, int monAn100Id, int combo100Id, int soLuong, float tongTien) {
        this.id = id;
        this.monAn100Id = monAn100Id;
        this.combo100Id = combo100Id;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonAn100Id() {
        return monAn100Id;
    }

    public void setMonAn100Id(int monAn100Id) {
        this.monAn100Id = monAn100Id;
    }

    public int getCombo100Id() {
        return combo100Id;
    }

    public void setCombo100Id(int combo100Id) {
        this.combo100Id = combo100Id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "ComBoMonAn100{" +
                "id=" + id +
                ", monAn100Id=" + monAn100Id +
                ", combo100Id=" + combo100Id +
                ", soLuong=" + soLuong +
                ", tongTien=" + tongTien +
                '}';
    }
}

