/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

public class NhaCungCap100 {
    private int id;
    private String ten;
    private String diaChi;
    private String sdt;

    public NhaCungCap100() {
    }

    public NhaCungCap100(int id, String ten, String diaChi, String sdt) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "NhaCungCap{" + "ID=" + id + ", Ten=" + ten + ", DiaChi=" + diaChi + ", SDT=" + sdt + '}';
    }
}
