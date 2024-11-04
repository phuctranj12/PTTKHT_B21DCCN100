/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

public class Ban100 {
    private int id;
    private int sucChua;
    private String trangThai;

    public Ban100() {
    }

    public Ban100(int id, int sucChua, String trangThai) {
        this.id = id;
        this.sucChua = sucChua;
        this.trangThai = trangThai;
    }
    public Ban100(Ban100 b) {
        this.id = b.getId();
        this.sucChua = b.getSucChua();
        this.trangThai = b.getTrangThai();
    }

    public int getId() {
        return id;
    }

    public int getSucChua() {
        return sucChua;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

   
}

