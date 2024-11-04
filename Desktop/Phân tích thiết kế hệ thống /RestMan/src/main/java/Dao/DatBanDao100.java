/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Object.DatBan100;
import Object.Ban100;
import Object.NguoiDung100;
import DB.Dao;
import Dao.KhachHangDao100;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatBanDao100 extends Dao {

    public DatBanDao100() {
    }
    
    
    public List<DatBan100> getAllDatBan() {
        List<DatBan100> datBanList = new ArrayList<>();
        String sql = "SELECT * FROM tblDatBan100"; 

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String trangThaiDon = rs.getString("trangThaiDon");
                Timestamp thoiGian = rs.getTimestamp("thoiGian");
                int tblNhanVienBanHang100stt = rs.getInt("tblNhanVienBanHang100stt");
                int tblBan100id = rs.getInt("tblBan100id");
                int tblKhachHang100id = rs.getInt("tblKhachHang100id");

                DatBan100 datBan = new DatBan100(id, trangThaiDon, thoiGian, tblNhanVienBanHang100stt, tblBan100id, tblKhachHang100id);
                datBanList.add(datBan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datBanList;
    }
    public boolean addDatBan2(DatBan100 datBan) {
    String sql = "INSERT INTO tblDatBan100 (trangThaiDon, thoiGian, tblNhanVienBanHang100stt, tblBan100id, tblKhachHang100id) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        System.out.println("Thời gian: " + datBan.getThoiGian());
        System.out.println("Trạng thái đơn: " + datBan.getTrangThaiDon());
        System.out.println("ID bàn: " + datBan.getTblBan100id());
        System.out.println("ID khách hàng: " + datBan.getTblKhachHang100id());

        pstmt.setString(1, datBan.getTrangThaiDon());
        pstmt.setTimestamp(2, datBan.getThoiGian());
        Integer nhanVienId = datBan.getTblNhanVienBanHang100stt();
        pstmt.setInt(3, datBan.getTblNhanVienBanHang100stt());
        pstmt.setInt(4, datBan.getTblBan100id());
        pstmt.setInt(5, datBan.getTblKhachHang100id());
        
        int affectedRows = pstmt.executeUpdate();
        
        // Nếu số hàng bị ảnh hưởng > 0, trả về true (thêm thành công)
        return affectedRows > 0;
        
    } catch (SQLException e) {
        System.err.println("Error inserting datBan: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}
        public boolean addDatBan(DatBan100 datBan) {
    
    String sql = "INSERT INTO tblDatBan100 (trangThaiDon, thoiGian,tblBan100id, tblKhachHang100id) VALUES (?, ?, ?, ?)";

    try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        System.out.println("Thời gian: " + datBan.getThoiGian());
        System.out.println("Trạng thái đơn: " + datBan.getTrangThaiDon());
        System.out.println("ID bàn: " + datBan.getTblBan100id());
        System.out.println("ID khách hàng: " + datBan.getTblKhachHang100id());

        pstmt.setString(1, datBan.getTrangThaiDon());
        pstmt.setTimestamp(2, datBan.getThoiGian());
        pstmt.setInt(3, datBan.getTblBan100id());
        pstmt.setInt(4, datBan.getTblKhachHang100id());
        int affectedRows = pstmt.executeUpdate();
        // Nếu số hàng bị ảnh hưởng > 0, trả về true (thêm thành công)
        return affectedRows > 0;
        
    } catch (SQLException e) {
        System.err.println("Error inserting datBan: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}


    public void deleteDatBan(int id) {
        String sql = "DELETE FROM tblDatBan100 WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDatBan(DatBan100 datBan) {
        String sql = "UPDATE tblDatBan100 SET trangThaiDon = ?, thoiGian = ?, tblNhanVienBanHang100stt = ?, tblBan100id = ?, tblKhachHang100id = ? WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, datBan.getTrangThaiDon());
            pstmt.setTimestamp(2, datBan.getThoiGian());
            pstmt.setInt(3, datBan.getTblNhanVienBanHang100stt());
            pstmt.setInt(4, datBan.getTblBan100id());
            pstmt.setInt(5, datBan.getTblKhachHang100id());
            pstmt.setInt(6, datBan.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DatBan100 getDatBanById(int id) {
        String sql = "SELECT * FROM tblDatBan100 WHERE id = ?";
        DatBan100 datBan = null;

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String trangThaiDon = rs.getString("trangThaiDon");
                    Timestamp thoiGian = rs.getTimestamp("thoiGian");
                    int tblNhanVienBanHang100stt = rs.getInt("tblNhanVienBanHang100stt");
                    int tblBan100id = rs.getInt("tblBan100id");
                    int tblKhachHang100id = rs.getInt("tblKhachHang100id");

                    datBan = new DatBan100(id, trangThaiDon, thoiGian, tblNhanVienBanHang100stt, tblBan100id, tblKhachHang100id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datBan;
    }

    public List<Ban100> getBanChuaDat(Timestamp thoiGian) {
        List<Ban100> availableBans = new ArrayList<>();

        boolean isMorning = thoiGian.toLocalDateTime().getHour() < 12;

        String sql = "SELECT b.id, b.sucChua, b.trangThai FROM tblBan100 b "
                + "LEFT JOIN tblDatBan100 db ON b.id = db.tblBan100id "
                + "AND DATE(db.thoiGian) = DATE(?) "
                + "AND ((HOUR(db.thoiGian) < 12 AND ?) OR (HOUR(db.thoiGian) >= 12 AND NOT ?)) "
                + 
                "WHERE db.tblBan100id IS NULL  AND b.trangThai = 'Trống'"; 

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setTimestamp(1, thoiGian);
            pstmt.setBoolean(2, isMorning); 
            pstmt.setBoolean(3, isMorning); 

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int sucChua = rs.getInt("sucChua");
                    String trangThai = rs.getString("trangThai");
                    Ban100 ban = new Ban100(id, sucChua, trangThai);
                    availableBans.add(ban); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return availableBans;
    }

}
