/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Object.KhachHang100;
import Object.NguoiDung100;
import Dao.NguoiDungDao100;
import DB.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDao100 extends Dao {

    public KhachHangDao100() {
        // Constructor mặc định
    }

    // Phương thức lấy tất cả khách hàng
    public List<KhachHang100> getAllKhachHang() {
        List<KhachHang100> khachHangList = new ArrayList<>();
        String sql = "SELECT * FROM tblKhachHang100";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int userId = rs.getInt("userId");
                String ten = rs.getString("ten");
                String sdt = rs.getString("sdt");
                String username = rs.getString("username");
                String email = rs.getString("email");

                KhachHang100 khachHang = new KhachHang100(ten, sdt, userId, username, email);
                khachHangList.add(khachHang);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching customers: " + e.getMessage());
            e.printStackTrace();
        }

        return khachHangList;
    }

    // Phương thức thêm mới khách hàng
    public void addKhachHang(NguoiDung100 nd) throws SQLException {
        NguoiDungDao100 ndd = new NguoiDungDao100();
        int id = ndd.getUserIdByUsername(nd.getUsername());
        String sql = "INSERT INTO tblKhachHang100 (id,ten, sdt) VALUES (?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2,"" );
            pstmt.setString(3, "");
             pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding customer: " + e.getMessage());
            
        }
    }

    // Phương thức cập nhật thông tin khách hàng
    public boolean updateKhachHang(KhachHang100 khachHang) {
        String sql = "UPDATE tblKhachHang100 SET ten = ?, sdt = ?, username = ?, email = ? WHERE userId = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, khachHang.getTen());
            pstmt.setString(2, khachHang.getSdt());
            pstmt.setString(3, khachHang.getUsername());
            pstmt.setString(4, khachHang.getEmail());
            pstmt.setInt(5, khachHang.getUserId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.err.println("Error updating customer: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Phương thức xóa khách hàng theo ID
    public boolean deleteKhachHang(int userId) {
        String sql = "DELETE FROM tblKhachHang100 WHERE userId = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting customer: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Phương thức lấy khách hàng theo ID
    public KhachHang100 getKhachHangById(int userId) {
        String sql = "SELECT * FROM tblKhachHang100 WHERE userId = ?";
        KhachHang100 khachHang = null;

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String ten = rs.getString("ten");
                    String sdt = rs.getString("sdt");
                    String username = rs.getString("username");
                    String email = rs.getString("email");

                    khachHang = new KhachHang100(ten, sdt, userId, username, email);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching customer by ID: " + e.getMessage());
            e.printStackTrace();
        }

        return khachHang;
    }
}

