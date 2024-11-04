/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

public class HoaDon100 {
    private int id;
    private String thoiGian;
    private float tongTien;
    private float giamGia;
    private float tienThucNhan;
    private int khachHang100Id;
    private int nhanVienBanHang100Id;
    private int datBan100Id;

    public HoaDon100() {
    }

    public HoaDon100(int id, String thoiGian, float tongTien, float giamGia, float tienThucNhan, int khachHang100Id, int nhanVienBanHang100Id, int datBan100Id) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.tongTien = tongTien;
        this.giamGia = giamGia;
        this.tienThucNhan = tienThucNhan;
        this.khachHang100Id = khachHang100Id;
        this.nhanVienBanHang100Id = nhanVienBanHang100Id;
        this.datBan100Id = datBan100Id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(float giamGia) {
        this.giamGia = giamGia;
    }

    public float getTienThucNhan() {
        return tienThucNhan;
    }

    public void setTienThucNhan(float tienThucNhan) {
        this.tienThucNhan = tienThucNhan;
    }

    public int getKhachHang100Id() {
        return khachHang100Id;
    }

    public void setKhachHang100Id(int khachHang100Id) {
        this.khachHang100Id = khachHang100Id;
    }

    public int getNhanVienBanHang100Id() {
        return nhanVienBanHang100Id;
    }

    public void setNhanVienBanHang100Id(int nhanVienBanHang100Id) {
        this.nhanVienBanHang100Id = nhanVienBanHang100Id;
    }

    public int getDatBan100Id() {
        return datBan100Id;
    }

    public void setDatBan100Id(int datBan100Id) {
        this.datBan100Id = datBan100Id;
    }

    // Phương thức tính tiền thực nhận dựa trên mã giảm giá
    public void tinhTienThucNhan(float giamGiaPhanTram) {
        this.tienThucNhan = this.tongTien - (this.tongTien * giamGiaPhanTram / 100);
    }

    @Override
    public String toString() {
        return "HoaDon100{" +
                "id=" + id +
                ", thoiGian='" + thoiGian + '\'' +
                ", tongTien=" + tongTien +
                ", giamGia=" + giamGia +
                ", tienThucNhan=" + tienThucNhan +
                ", khachHang100Id=" + khachHang100Id +
                ", nhanVienBanHang100Id=" + nhanVienBanHang100Id +
                ", datBan100Id=" + datBan100Id +
                '}';
    }
}
