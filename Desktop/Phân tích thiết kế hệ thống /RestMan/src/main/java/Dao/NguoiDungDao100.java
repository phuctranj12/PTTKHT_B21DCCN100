package Dao;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author anhphuc
 */
import Object.NguoiDung100;
import DB.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungDao100 extends Dao {

    // Lấy tất cả người dùng từ cơ sở dữ liệu
    public List<NguoiDung100> getAllUsers() {
        List<NguoiDung100> users = new ArrayList<>();
        String sql = "SELECT * FROM tblNguoiDung100";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                NguoiDung100 user = new NguoiDung100(id, username, email, password);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM tblNguoiDung100 WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(NguoiDung100 user) {
        String sql = "INSERT INTO tblNguoiDung100 (username, password, email) VALUES (?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public NguoiDung100 getUserById(int id) {
        String sql = "SELECT * FROM tblNguoiDung100 WHERE id = ?";
        NguoiDung100 user = null;

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String username = rs.getString("username");
                    String email = rs.getString("email");

                    user = new NguoiDung100(id, username, email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean checkRegister(NguoiDung100 user) throws SQLException {
        String sql = "SELECT * FROM tblNguoiDung100 WHERE username = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkLogin(NguoiDung100 user) throws SQLException {
        String sql = "SELECT * FROM tblNguoiDung100 WHERE username = ? and password = ? ";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getUserIdByUsername(String username) throws SQLException {
        String sql = "SELECT id FROM tblNguoiDung100 WHERE username = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        }
        return -1;
    }

}
