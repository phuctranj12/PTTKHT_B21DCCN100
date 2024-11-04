/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author anhphuc
 */

import Object.DatCombo100;
import DB.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatComboDao100 extends Dao {

    // Lấy tất cả các đơn đặt combo từ cơ sở dữ liệu
    public List<DatCombo100> getAllDatCombo() {
        List<DatCombo100> datComboList = new ArrayList<>();
        String sql = "SELECT * FROM tblDatCombo100"; // Đảm bảo tên bảng tblDatCombo100 khớp với tên bảng trong DB

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                Timestamp thoiGian = rs.getTimestamp("thoiGian");
                int soLuong = rs.getInt("soLuong");
                int tblCombo100id = rs.getInt("tblCombo100id");
                
                DatCombo100 datCombo = new DatCombo100(id, thoiGian, soLuong, tblCombo100id);
                datComboList.add(datCombo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datComboList;
    }

    // Thêm một đơn đặt combo mới vào cơ sở dữ liệu
    public void addDatCombo(DatCombo100 datCombo) {
        String sql = "INSERT INTO tblDatCombo100 (thoiGian, soLuong, tblCombo100id) VALUES (?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setTimestamp(1, datCombo.getThoiGian());
            pstmt.setInt(2, datCombo.getSoLuong());
            pstmt.setInt(3, datCombo.getTblCombo100id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa đơn đặt combo theo ID
    public void deleteDatCombo(int id) {
        String sql = "DELETE FROM tblDatCombo100 WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật thông tin đơn đặt combo
    public void updateDatCombo(DatCombo100 datCombo) {
        String sql = "UPDATE tblDatCombo100 SET thoiGian = ?, soLuong = ?, tblCombo100id = ? WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setTimestamp(1, datCombo.getThoiGian());
            pstmt.setInt(2, datCombo.getSoLuong());
            pstmt.setInt(3, datCombo.getTblCombo100id());
            pstmt.setInt(4, datCombo.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy đơn đặt combo theo ID
    public DatCombo100 getDatComboById(int id) {
        String sql = "SELECT * FROM tblDatCombo100 WHERE id = ?";
        DatCombo100 datCombo = null;

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Timestamp thoiGian = rs.getTimestamp("thoiGian");
                    int soLuong = rs.getInt("soLuong");
                    int tblCombo100id = rs.getInt("tblCombo100id");
                    
                    datCombo = new DatCombo100(id, thoiGian, soLuong, tblCombo100id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datCombo;
    }
}

