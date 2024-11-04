/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.time.LocalDateTime;

/**
 *
 * @author anhphuc
 */
public class TheThanhVien100 extends KhachHang100{
    private int id;
    private LocalDateTime ngayTao;
    private int diemTichLuy;

    public TheThanhVien100() {
    }

    public TheThanhVien100(String ten, String sdt, NguoiDung100 user) {
        super(ten, sdt, user);
    }

    public TheThanhVien100(String ten, String sdt, int userId, String username, String email) {
        super(ten, sdt, userId, username, email);
    }

    public TheThanhVien100(String ten, String sdt, String username, String password, String email) {
        super(ten, sdt, username, password, email);
    }

    public TheThanhVien100(String ten, String sdt, int userId, String username, String password, String email) {
        super(ten, sdt, userId, username, password, email);
    }

    public TheThanhVien100(int id, LocalDateTime ngayTao, int diemTichLuy) {
        this.id = id;
        this.ngayTao = ngayTao;
        this.diemTichLuy = diemTichLuy;
    }

    public TheThanhVien100(int id, LocalDateTime ngayTao, int diemTichLuy, String ten, String sdt, NguoiDung100 user) {
        super(ten, sdt, user);
        this.id = id;
        this.ngayTao = ngayTao;
        this.diemTichLuy = diemTichLuy;
    }

    public TheThanhVien100(int id, LocalDateTime ngayTao, int diemTichLuy, String ten, String sdt, int userId, String username, String email) {
        super(ten, sdt, userId, username, email);
        this.id = id;
        this.ngayTao = ngayTao;
        this.diemTichLuy = diemTichLuy;
    }

    public TheThanhVien100(int id, LocalDateTime ngayTao, int diemTichLuy, String ten, String sdt, String username, String password, String email) {
        super(ten, sdt, username, password, email);
        this.id = id;
        this.ngayTao = ngayTao;
        this.diemTichLuy = diemTichLuy;
    }

    public TheThanhVien100(int id, LocalDateTime ngayTao, int diemTichLuy, String ten, String sdt, int userId, String username, String password, String email) {
        super(ten, sdt, userId, username, password, email);
        this.id = id;
        this.ngayTao = ngayTao;
        this.diemTichLuy = diemTichLuy;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }
    
}
