/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author anhphuc
 */

import Object.ComboMonAn100;
import DB.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComboMonAnDao100 extends Dao {

    // Lấy tất cả Combo món ăn từ cơ sở dữ liệu
    public List<ComboMonAn100> getAllComboMonAn() {
        List<ComboMonAn100> comboMonAns = new ArrayList<>();
        String sql = "SELECT * FROM tblComboMonAn100"; // Thay tblComboMonAn100 bằng tên bảng chính xác trong DB

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int monAn100Id = rs.getInt("monAn100Id");
                int combo100Id = rs.getInt("combo100Id");
                int soLuong = rs.getInt("soLuong");
                float tongTien = rs.getFloat("tongTien");
                ComboMonAn100 comboMonAn = new ComboMonAn100(id, monAn100Id, combo100Id, soLuong, tongTien);
                comboMonAns.add(comboMonAn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comboMonAns;
    }

    // Thêm một Combo món ăn mới vào cơ sở dữ liệu
    public void addComboMonAn(ComboMonAn100 comboMonAn) {
        String sql = "INSERT INTO tblComboMonAn100 (monAn100Id, combo100Id, soLuong, tongTien) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, comboMonAn.getMonAn100Id());
            pstmt.setInt(2, comboMonAn.getCombo100Id());
            pstmt.setInt(3, comboMonAn.getSoLuong());
            pstmt.setFloat(4, comboMonAn.getTongTien());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa một Combo món ăn theo ID
    public void deleteComboMonAn(int id) {
        String sql = "DELETE FROM tblComboMonAn100 WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật thông tin Combo món ăn
    public void updateComboMonAn(ComboMonAn100 comboMonAn) {
        String sql = "UPDATE tblComboMonAn100 SET monAn100Id = ?, combo100Id = ?, soLuong = ?, tongTien = ? WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, comboMonAn.getMonAn100Id());
            pstmt.setInt(2, comboMonAn.getCombo100Id());
            pstmt.setInt(3, comboMonAn.getSoLuong());
            pstmt.setFloat(4, comboMonAn.getTongTien());
            pstmt.setInt(5, comboMonAn.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy Combo món ăn theo ID
    public ComboMonAn100 getComboMonAnById(int id) {
        String sql = "SELECT * FROM tblComboMonAn100 WHERE id = ?";
        ComboMonAn100 comboMonAn = null;

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int monAn100Id = rs.getInt("monAn100Id");
                    int combo100Id = rs.getInt("combo100Id");
                    int soLuong = rs.getInt("soLuong");
                    float tongTien = rs.getFloat("tongTien");
                    comboMonAn = new ComboMonAn100(id, monAn100Id, combo100Id, soLuong, tongTien);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comboMonAn;
    }
}

