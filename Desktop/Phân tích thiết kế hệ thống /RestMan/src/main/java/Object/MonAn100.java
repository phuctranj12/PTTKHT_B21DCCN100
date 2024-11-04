/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author anhphuc
 */
public class MonAn100 {
    private int id ; 
    private String ten , img ; 
    private float gia ; 

    public MonAn100() {
    }

    public MonAn100(int id, String ten, String img, float gia) {
        this.id = id;
        this.ten = ten;
        this.img = img;
        this.gia = gia;
    }
       public MonAn100( String ten, String img, float gia) {
        this.ten = ten;
        this.img = img;
        this.gia = gia;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public String getImg() {
        return img;
    }

    public float getGia() {
        return gia;
    }
    
}
