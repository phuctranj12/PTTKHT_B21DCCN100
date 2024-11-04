/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author anhphuc
 */

import Object.DatMonAn100;
import DB.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatMonAnDao100 extends Dao {

    // Lấy tất cả đơn đặt món ăn từ cơ sở dữ liệu
    public List<DatMonAn100> getAllDatMonAn() {
        List<DatMonAn100> datMonAnList = new ArrayList<>();
        String sql = "SELECT * FROM tblDatMonAn100"; // Đảm bảo tên bảng tblDatMonAn100 khớp với DB

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                Timestamp thoiGian = rs.getTimestamp("thoiGian");
                int soLuong = rs.getInt("soLuong");
                int tblMonAn100id = rs.getInt("tblMonAn100id");

                DatMonAn100 datMonAn = new DatMonAn100(id, thoiGian, soLuong, tblMonAn100id);
                datMonAnList.add(datMonAn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datMonAnList;
    }

    // Thêm một đơn đặt món ăn mới vào cơ sở dữ liệu
    public void addDatMonAn(DatMonAn100 datMonAn) {
        String sql = "INSERT INTO tblDatMonAn100 (thoiGian, soLuong, tblMonAn100id) VALUES (?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setTimestamp(1, datMonAn.getThoiGian());
            pstmt.setInt(2, datMonAn.getSoLuong());
            pstmt.setInt(3, datMonAn.getTblMonAn100id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa đơn đặt món ăn theo ID
    public void deleteDatMonAnById(int id) {
        String sql = "DELETE FROM tblDatMonAn100 WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật thông tin đơn đặt món ăn
    public void updateDatMonAn(DatMonAn100 datMonAn) {
        String sql = "UPDATE tblDatMonAn100 SET thoiGian = ?, soLuong = ?, tblMonAn100id = ? WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setTimestamp(1, datMonAn.getThoiGian());
            pstmt.setInt(2, datMonAn.getSoLuong());
            pstmt.setInt(3, datMonAn.getTblMonAn100id());
            pstmt.setInt(4, datMonAn.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy thông tin đơn đặt món ăn theo ID
    public DatMonAn100 getDatMonAnById(int id) {
        String sql = "SELECT * FROM tblDatMonAn100 WHERE id = ?";
        DatMonAn100 datMonAn = null;

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Timestamp thoiGian = rs.getTimestamp("thoiGian");
                    int soLuong = rs.getInt("soLuong");
                    int tblMonAn100id = rs.getInt("tblMonAn100id");

                    datMonAn = new DatMonAn100(id, thoiGian, soLuong, tblMonAn100id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datMonAn;
    }
}

