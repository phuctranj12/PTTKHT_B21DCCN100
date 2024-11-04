/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author anhphuc
 */
import Object.DatMon100;
import DB.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatMonDao100 extends Dao {

    // Lấy tất cả đơn đặt món từ cơ sở dữ liệu
    public List<DatMon100> getAllDatMon() {
        List<DatMon100> datMonList = new ArrayList<>();
        String sql = "SELECT * FROM tblDatMon100"; // Đảm bảo tên bảng tblDatMon100 khớp với DB

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                float tongTien = rs.getFloat("tongTien");
                int tblDatBan100id = rs.getInt("tblDatBan100id");
                int tblDatCombo100id = rs.getInt("tblDatCombo100id");
                int tblDatMonAn100id = rs.getInt("tblDatMonAn100id");

                DatMon100 datMon = new DatMon100(tongTien, tblDatBan100id, tblDatCombo100id, tblDatMonAn100id);
                datMonList.add(datMon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datMonList;
    }

    // Thêm một đơn đặt món mới vào cơ sở dữ liệu
    public void addDatMon(DatMon100 datMon) {
        String sql = "INSERT INTO tblDatMon100 (tongTien, tblDatBan100id, tblDatCombo100id, tblDatMonAn100id) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setFloat(1, datMon.getTongTien());
            pstmt.setInt(2, datMon.getTblDatBan100id());
            pstmt.setInt(3, datMon.getTblDatCombo100id());
            pstmt.setInt(4, datMon.getTblDatMonAn100id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa đơn đặt món theo ID của đơn đặt bàn
    public void deleteDatMonByDatBanId(int tblDatBan100id) {
        String sql = "DELETE FROM tblDatMon100 WHERE tblDatBan100id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tblDatBan100id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật thông tin đơn đặt món
    public void updateDatMon(DatMon100 datMon) {
        String sql = "UPDATE tblDatMon100 SET tongTien = ?, tblDatCombo100id = ?, tblDatMonAn100id = ? WHERE tblDatBan100id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setFloat(1, datMon.getTongTien());
            pstmt.setInt(2, datMon.getTblDatCombo100id());
            pstmt.setInt(3, datMon.getTblDatMonAn100id());
            pstmt.setInt(4, datMon.getTblDatBan100id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy thông tin đơn đặt món theo ID của đơn đặt bàn
    public DatMon100 getDatMonByDatBanId(int tblDatBan100id) {
        String sql = "SELECT * FROM tblDatMon100 WHERE tblDatBan100id = ?";
        DatMon100 datMon = null;

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tblDatBan100id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    float tongTien = rs.getFloat("tongTien");
                    int tblDatCombo100id = rs.getInt("tblDatCombo100id");
                    int tblDatMonAn100id = rs.getInt("tblDatMonAn100id");

                    datMon = new DatMon100(tongTien, tblDatBan100id, tblDatCombo100id, tblDatMonAn100id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datMon;
    }
}

