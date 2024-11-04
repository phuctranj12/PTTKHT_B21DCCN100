/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author anhphuc
 */
public class Combo100 {
    private String ten , img ;
    private int id ; 
    private float gia ; 

    public Combo100() {
    }

    public Combo100(String ten, String img, int id, float gia) {
        this.ten = ten;
        this.img = img;
        this.id = id;
        this.gia = gia;
    }

    public Combo100(int id, String tenCombo, float gia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Combo100(int id, String ten, String img, float gia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getTen() {
        return ten;
    }

    public String getImg() {
        return img;
    }

    public int getId() {
        return id;
    }

    public float getGia() {
        return gia;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
    
}
