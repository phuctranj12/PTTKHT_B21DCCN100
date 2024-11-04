/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author anhphuc
 */
public class KhachHang100 extends NguoiDung100{
    private String ten ; 
    private  String sdt ;

    public KhachHang100() {
    }
    public KhachHang100(String ten, String sdt, NguoiDung100 user) {
        super(user);
        this.ten = ten;
        this.sdt = sdt;
    }

    public KhachHang100(String ten, String sdt, int userId, String username, String email) {
        super(userId, username, email);
        this.ten = ten;
        this.sdt = sdt;
    }

    public KhachHang100(String ten, String sdt, String username, String password, String email) {
        super(username, password, email);
        this.ten = ten;
        this.sdt = sdt;
    }

    public KhachHang100(String ten, String sdt, int userId, String username, String password, String email) {
        super(userId, username, password, email);
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
