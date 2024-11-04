/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Object.HoaDonNhap100;
import DB.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonNhapDao100 extends Dao {

    // Lấy tất cả hóa đơn nhập từ cơ sở dữ liệu
    public List<HoaDonNhap100> getAllHoaDonNhap() {
        List<HoaDonNhap100> hoaDonNhapList = new ArrayList<>();
        String sql = "SELECT * FROM tblHoaDonNhap100"; // Đảm bảo tên bảng tblHoaDonNhap100 khớp với DB

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                float tongTien = rs.getFloat("tongTien");
                Timestamp thoiGian = rs.getTimestamp("thoiGian");
                int tblNhaCungCap100id = rs.getInt("tblNhaCungCap100id");
                int tblNhanVienKho100stt = rs.getInt("tblNhanVienKho100stt");

                HoaDonNhap100 hoaDonNhap = new HoaDonNhap100(id, tongTien, thoiGian, tblNhaCungCap100id, tblNhanVienKho100stt);
                hoaDonNhapList.add(hoaDonNhap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDonNhapList;
    }

    // Thêm hóa đơn nhập mới vào cơ sở dữ liệu
    public void addHoaDonNhap(HoaDonNhap100 hoaDonNhap) {
        String sql = "INSERT INTO tblHoaDonNhap100 (tongTien, thoiGian, tblNhaCungCap100id, tblNhanVienKho100stt) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setFloat(1, hoaDonNhap.getTongTien());
            pstmt.setTimestamp(2, hoaDonNhap.getThoiGian());
            pstmt.setInt(3, hoaDonNhap.getTblNhaCungCap100id());
            pstmt.setInt(4, hoaDonNhap.getTblNhanVienKho100stt());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa hóa đơn nhập theo ID
    public void deleteHoaDonNhapById(int id) {
        String sql = "DELETE FROM tblHoaDonNhap100 WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật thông tin hóa đơn nhập
    public void updateHoaDonNhap(HoaDonNhap100 hoaDonNhap) {
        String sql = "UPDATE tblHoaDonNhap100 SET tongTien = ?, thoiGian = ?, tblNhaCungCap100id = ?, tblNhanVienKho100stt = ? WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setFloat(1, hoaDonNhap.getTongTien());
            pstmt.setTimestamp(2, hoaDonNhap.getThoiGian());
            pstmt.setInt(3, hoaDonNhap.getTblNhaCungCap100id());
            pstmt.setInt(4, hoaDonNhap.getTblNhanVienKho100stt());
            pstmt.setInt(5, hoaDonNhap.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy thông tin hóa đơn nhập theo ID
    public HoaDonNhap100 getHoaDonNhapById(int id) {
        String sql = "SELECT * FROM tblHoaDonNhap100 WHERE id = ?";
        HoaDonNhap100 hoaDonNhap = null;

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    float tongTien = rs.getFloat("tongTien");
                    Timestamp thoiGian = rs.getTimestamp("thoiGian");
                    int tblNhaCungCap100id = rs.getInt("tblNhaCungCap100id");
                    int tblNhanVienKho100stt = rs.getInt("tblNhanVienKho100stt");

                    hoaDonNhap = new HoaDonNhap100(id, tongTien, thoiGian, tblNhaCungCap100id, tblNhanVienKho100stt);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDonNhap;
    }
}

