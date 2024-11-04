/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Object.NguyenLieu100;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DB.Dao;
public class NguyenLieuDao100 extends Dao {

    public NguyenLieuDao100() {
        super();
    }

    // Thêm nguyên liệu mới vào cơ sở dữ liệu
    public boolean themNguyenLieu(NguyenLieu100 nguyenLieu) {
        String query = "INSERT INTO tblNguyenLieu100 (ten, gia, soLuongTon) VALUES (?, ?, ?)";
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nguyenLieu.getTen());
            stmt.setFloat(2, nguyenLieu.getGia());
            stmt.setInt(3, nguyenLieu.getSoLuongTon());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật thông tin nguyên liệu
    public boolean capNhatNguyenLieu(NguyenLieu100 nguyenLieu) {
        String query = "UPDATE tblNguyenLieu100 SET ten = ?, gia = ?, soLuongTon = ? WHERE id = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nguyenLieu.getTen());
            stmt.setFloat(2, nguyenLieu.getGia());
            stmt.setInt(3, nguyenLieu.getSoLuongTon());
            stmt.setInt(4, nguyenLieu.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa nguyên liệu theo id
    public boolean xoaNguyenLieu(int id) {
        String query = "DELETE FROM tblNguyenLieu100 WHERE id = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy danh sách tất cả nguyên liệu
    public List<NguyenLieu100> layTatCaNguyenLieu() {
        List<NguyenLieu100> danhSachNguyenLieu = new ArrayList<>();
        String query = "SELECT * FROM tblNguyenLieu100";
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                NguyenLieu100 nguyenLieu = new NguyenLieu100();
                nguyenLieu.setId(rs.getInt("id"));
                nguyenLieu.setTen(rs.getString("ten"));
                nguyenLieu.setGia(rs.getFloat("gia"));
                nguyenLieu.setSoLuongTon(rs.getInt("soLuongTon"));
                danhSachNguyenLieu.add(nguyenLieu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachNguyenLieu;
    }

    // Tìm nguyên liệu theo id
    public NguyenLieu100 timNguyenLieuTheoId(int id) {
        String query = "SELECT * FROM tblNguyenLieu100 WHERE id = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    NguyenLieu100 nguyenLieu = new NguyenLieu100();
                    nguyenLieu.setId(rs.getInt("id"));
                    nguyenLieu.setTen(rs.getString("ten"));
                    nguyenLieu.setGia(rs.getFloat("gia"));
                    nguyenLieu.setSoLuongTon(rs.getInt("soLuongTon"));
                    return nguyenLieu;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
