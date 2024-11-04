<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DB.Dao" %>
<%@ page import="Dao.BanDao100" %>
<%@ page import="Dao.DatBanDao100" %>
<%@ page import="Dao.NguoiDungDao100" %>
<%@ page import="Object.Ban100" %>
<%@ page import="Object.DatBan100" %>
<%@ page import="Object.NguoiDung100" %>
<%@ page import="Object.KhachHang100" %>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Xử lý đặt bàn</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/datban2.css">
    </head>
    <body>
        <button class="btn-back" name="back" type="submit" onclick="window.history.back();">Trở lại</button>
      
        <div class="container">
            <div class="form-container">
                <h2>Thông tin khách hàng</h2>
                <form method="POST" action="">
                    <input type="text" name="ten" required placeholder="Tên"/>
                    <input type="text" name="sdt" required placeholder="Số Điện Thoại" />
                    <div class="btn-container">
                        <button type="reset" name="reset">Xoá</button>
                        <button type="submit" name="Datban">Xác nhận đặt bàn</button>
                    </div>
                </form>
            </div>
        <%
            if (request.getParameter("Datban") != null) {
            
            String UserId = request.getParameter("user_id");
            if (UserId == null || UserId.isEmpty()) {
                out.println("<p>Lỗi: Không có thông tin user_id.</p>");
                return;
            }
            int userId;
            try {
                userId = Integer.parseInt(UserId);
            } catch (NumberFormatException e) {
                out.println("<p>Lỗi: user_id không hợp lệ.</p>");
                return;
            }
                NguoiDungDao100 ndd = new NguoiDungDao100();
                NguoiDung100 nd = ndd.getUserById(userId);
                if (nd == null) {
                out.println("<p>Lỗi: Người dùng không tồn tại.</p>");
                return;
                }
            String banId = request.getParameter("banId");
            Ban100 ban = null;
            if (banId != null && !banId.isEmpty()) {
                int idBan;
                try {
                    idBan = Integer.parseInt(banId);
                } catch (NumberFormatException e) {
                    out.println("<p>Lỗi: ID bàn không hợp lệ.</p>");
                    return;
                }
                 BanDao100 banDao = new BanDao100();
                ban = banDao.getBanById(idBan);
                if (ban != null) {
                    out.println("<h3>ID người dùng: " + userId + "</h3>");
                    out.println("<h3>Bạn đã chọn bàn có ID: " + ban.getId() + "</h3>");
                    out.println("<p>Sức chứa: " + ban.getSucChua() + "</p>");
                    out.println("<p>Trạng thái: " + ban.getTrangThai() + "</p>");
                } else {
                    out.println("<p>Lỗi: Bàn không tồn tại.</p>");
                    return;
                }
            } else {
                out.println("<p>Lỗi: Không nhận được ID bàn.</p>");
                return;
            }
            
                String ten = request.getParameter("ten");
                String sdt = request.getParameter("sdt");
                 
                if (ten == null || ten.isEmpty() || sdt == null || sdt.isEmpty()) {
                    out.println("<p>Lỗi: Vui lòng nhập đầy đủ tên và số điện thoại.</p>");
                    return;
                }
                try {
                    KhachHang100 kh = new KhachHang100(ten, sdt, nd);
                    LocalDateTime thoiGianDatBan = LocalDateTime.now();
                    Timestamp thoiGian = Timestamp.valueOf(thoiGianDatBan);
                    DatBan100 datBan = new DatBan100(kh, ban, thoiGian, 0, "Chờ Xác nhận");
                    if (datBan != null) {
                              out.println("<div>Thoi gian Dat Ban : " + datBan.getThoiGian() + "</div>");
                    } else {
                           out.println("<p>Lỗi: Đối tượng DatBan100 bị null.</p>");
                    }
                    DatBanDao100 dbd = new DatBanDao100();
                    boolean success = dbd.addDatBan(datBan);
                    if (success) {
        %>
                        <script>
                            alert("Đặt bàn thành công!");
                            window.location.href = "gdDatBan100.jsp?user_id=<%= userId %>";
                        </script>
        <%
                    } else {
                        out.println("<p>Lỗi: Đặt bàn không thành công. Vui lòng thử lại.</p>");
                    }
                } catch (Exception e) {
                    out.println("<p>Lỗi: " + e.getMessage() + "</p>");
                }
            }
        %>
        </div>
    </body>
</html>
