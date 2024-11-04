<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DB.Dao" %>
<%@ page import="Dao.MonAnDao100" %>
<%@ page import="Object.MonAn100" %>
<%@ page import="java.util.*" %>
<%
    if (request.getParameter("themMonAn") != null) {
        String ten = request.getParameter("ten");
        String img = request.getParameter("hinhanh");
        String giaStr = request.getParameter("gia");
        try {
            float gia = Float.parseFloat(giaStr);
            MonAn100 monAn = new MonAn100(ten, img, gia);
            MonAnDao100 monAnDao = new MonAnDao100();

            boolean success = monAnDao.saveMonAn(monAn);
            if (success) {
                out.println("<p>Món ăn đã được thêm thành công!</p>");
            } else {
                out.println("<p>Lỗi: Không thể thêm món ăn.</p>");
            }
        } catch (NumberFormatException e) {
            out.println("<p>Lỗi: Giá không hợp lệ. Vui lòng nhập số.</p>");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="">
        <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet">
    </head>
    <body>
        <button onclick="window.history.back()">Trở lại</button>
        <form action="" method="POST">
            <label for="name">Tên</label>
            <input type="text" id="name" name="ten" required>
            <label for="gia">Giá</label>
            <input type="number" step="0.01" id="gia" name="gia" required>
            <label for="img">Hình ảnh</label>
            <input type="text" id="img" name="hinhanh" required>
            <button type="submit" value="Submit" name="themMonAn">Thêm món ăn</button>
            <button type="reset" value="Delete" name="Delete">Xoá</button>
        </form>
    </body>
</html>
