/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Object.MonAn100;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DB.Dao;
public class MonAnDao100 extends Dao {

    public MonAnDao100() {
        super();
    }

    public boolean saveMonAn(MonAn100 monAn) {
        String query = "INSERT INTO tblMonAn100 (ten, img, gia) VALUES (?, ?, ?)";
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, monAn.getTen());
            stmt.setString(2, monAn.getImg());
            stmt.setFloat(3, monAn.getGia());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateMonAn(MonAn100 monAn) {
        String query = "UPDATE tblMonAn100 SET ten = ?, img = ?, gia = ? WHERE id = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, monAn.getTen());
            stmt.setString(2, monAn.getImg());
            stmt.setFloat(3, monAn.getGia());
            stmt.setInt(4, monAn.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteMonAn(int id) {
        String query = "DELETE FROM tblMonAn100 WHERE id = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<MonAn100> getMonAnList() {
        List<MonAn100> danhSachMonAn = new ArrayList<>();
        String query = "SELECT * FROM tblMonAn100";
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                MonAn100 monAn = new MonAn100();
                monAn.setId(rs.getInt("id"));
                monAn.setTen(rs.getString("ten"));
                monAn.setImg(rs.getString("img"));
                monAn.setGia(rs.getFloat("gia"));
                danhSachMonAn.add(monAn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachMonAn;
    }

    public MonAn100 getMonAn(int id) {
        String query = "SELECT * FROM tblMonAn100 WHERE id = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    MonAn100 monAn = new MonAn100();
                    monAn.setId(rs.getInt("id"));
                    monAn.setTen(rs.getString("ten"));
                    monAn.setImg(rs.getString("img"));
                    monAn.setGia(rs.getFloat("gia"));
                    return monAn;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

