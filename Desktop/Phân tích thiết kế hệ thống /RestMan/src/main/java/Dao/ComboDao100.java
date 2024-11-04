/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Object.Combo100;
import DB.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComboDao100 extends Dao {

    // Lấy tất cả combo từ cơ sở dữ liệu
    public List<Combo100> getAllCombos() {
        List<Combo100> combos = new ArrayList<>();
        String sql = "SELECT * FROM tblCombo100"; // Thay tblCombo100 bằng tên bảng chính xác

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                String img = rs.getString("img");
                float gia = rs.getFloat("gia");
                Combo100 combo = new Combo100(id, ten, img, gia);
                combos.add(combo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return combos;
    }

    // Thêm một combo mới vào cơ sở dữ liệu
    public void addCombo(Combo100 combo) {
        String sql = "INSERT INTO tblCombo100 (ten, img, gia) VALUES (?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, combo.getTen());
            pstmt.setString(2, combo.getImg());
            pstmt.setFloat(3, combo.getGia());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa một combo theo ID
    public void deleteCombo(int id) {
        String sql = "DELETE FROM tblCombo100 WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy combo theo ID
    public Combo100 getComboById(int id) {
        String sql = "SELECT * FROM tblCombo100 WHERE id = ?";
        Combo100 combo = null;

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String ten = rs.getString("ten");
                    String img = rs.getString("img");
                    float gia = rs.getFloat("gia");
                    combo = new Combo100(id, ten, img, gia);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return combo;
    }
}
