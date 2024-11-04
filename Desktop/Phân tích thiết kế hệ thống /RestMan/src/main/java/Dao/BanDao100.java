/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author anhphuc
 */
import Object.Ban100;
import DB.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BanDao100 extends Dao {

    // Lấy tất cả bàn từ cơ sở dữ liệu
    public List<Ban100> getAllBan() {
        List<Ban100> banList = new ArrayList<>();
        String sql = "SELECT * FROM tblBan100";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int sucChua = rs.getInt("sucChua");
                String trangThai = rs.getString("trangThai");
                Ban100 ban = new Ban100(id, sucChua, trangThai);
                banList.add(ban);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return banList;
    }

    // Thêm bàn mới vào cơ sở dữ liệu
    public void addBan(Ban100 ban) {
        String sql = "INSERT INTO tblBan100 (sucChua, trangThai) VALUES (?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ban.getSucChua());
            pstmt.setString(2, ban.getTrangThai());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa bàn theo ID
    public void deleteBan(int id) {
        String sql = "DELETE FROM tblBan100 WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy bàn theo ID
    public Ban100 getBanById(int id) {
        String sql = "SELECT * FROM tblBan100 WHERE id = ?";
        Ban100 ban = null;

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int sucChua = rs.getInt("sucChua");
                    String trangThai = rs.getString("trangThai");
                    ban = new Ban100(id, sucChua, trangThai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ban;
    }

    public void updateBan(Ban100 ban) {
        String sql = "UPDATE tblBan100 SET sucChua = ?, trangThai = ? WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ban.getSucChua());
            pstmt.setString(2, ban.getTrangThai());
            pstmt.setInt(3, ban.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
