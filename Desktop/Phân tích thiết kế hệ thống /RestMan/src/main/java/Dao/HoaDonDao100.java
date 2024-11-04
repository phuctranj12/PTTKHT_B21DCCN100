/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author anhphuc
 */

import Object.HoaDon100;
import DB.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDao100 extends Dao {

    // Lấy tất cả hóa đơn từ cơ sở dữ liệu
    public List<HoaDon100> getAllHoaDon() {
        List<HoaDon100> hoaDonList = new ArrayList<>();
        String sql = "SELECT * FROM tblHoaDon100"; // Đảm bảo tên bảng tblHoaDon100 khớp với DB

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String thoiGian = rs.getString("thoiGian");
                float tongTien = rs.getFloat("tongTien");
                float giamGia = rs.getFloat("giamGia");
                float tienThucNhan = rs.getFloat("tienThucNhan");
                int khachHang100Id = rs.getInt("khachHang100Id");
                int nhanVienBanHang100Id = rs.getInt("nhanVienBanHang100Id");
                int datBan100Id = rs.getInt("datBan100Id");

                HoaDon100 hoaDon = new HoaDon100(id, thoiGian, tongTien, giamGia, tienThucNhan, khachHang100Id, nhanVienBanHang100Id, datBan100Id);
                hoaDonList.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDonList;
    }

    // Thêm hóa đơn mới vào cơ sở dữ liệu
    public void addHoaDon(HoaDon100 hoaDon) {
        String sql = "INSERT INTO tblHoaDon100 (thoiGian, tongTien, giamGia, tienThucNhan, khachHang100Id, nhanVienBanHang100Id, datBan100Id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, hoaDon.getThoiGian());
            pstmt.setFloat(2, hoaDon.getTongTien());
            pstmt.setFloat(3, hoaDon.getGiamGia());
            pstmt.setFloat(4, hoaDon.getTienThucNhan());
            pstmt.setInt(5, hoaDon.getKhachHang100Id());
            pstmt.setInt(6, hoaDon.getNhanVienBanHang100Id());
            pstmt.setInt(7, hoaDon.getDatBan100Id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa hóa đơn theo ID
    public void deleteHoaDonById(int id) {
        String sql = "DELETE FROM tblHoaDon100 WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật thông tin hóa đơn
    public void updateHoaDon(HoaDon100 hoaDon) {
        String sql = "UPDATE tblHoaDon100 SET thoiGian = ?, tongTien = ?, giamGia = ?, tienThucNhan = ?, khachHang100Id = ?, nhanVienBanHang100Id = ?, datBan100Id = ? WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, hoaDon.getThoiGian());
            pstmt.setFloat(2, hoaDon.getTongTien());
            pstmt.setFloat(3, hoaDon.getGiamGia());
            pstmt.setFloat(4, hoaDon.getTienThucNhan());
            pstmt.setInt(5, hoaDon.getKhachHang100Id());
            pstmt.setInt(6, hoaDon.getNhanVienBanHang100Id());
            pstmt.setInt(7, hoaDon.getDatBan100Id());
            pstmt.setInt(8, hoaDon.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy thông tin hóa đơn theo ID
    public HoaDon100 getHoaDonById(int id) {
        String sql = "SELECT * FROM tblHoaDon100 WHERE id = ?";
        HoaDon100 hoaDon = null;

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String thoiGian = rs.getString("thoiGian");
                    float tongTien = rs.getFloat("tongTien");
                    float giamGia = rs.getFloat("giamGia");
                    float tienThucNhan = rs.getFloat("tienThucNhan");
                    int khachHang100Id = rs.getInt("khachHang100Id");
                    int nhanVienBanHang100Id = rs.getInt("nhanVienBanHang100Id");
                    int datBan100Id = rs.getInt("datBan100Id");

                    hoaDon = new HoaDon100(id, thoiGian, tongTien, giamGia, tienThucNhan, khachHang100Id, nhanVienBanHang100Id, datBan100Id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDon;
    }
}

