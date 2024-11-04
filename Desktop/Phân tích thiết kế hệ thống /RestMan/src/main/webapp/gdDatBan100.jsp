<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DB.Dao" %>
<%@ page import="Dao.DatBanDao100" %>
<%@ page import="Object.Ban100" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Tìm kiếm bàn trống</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/datban.css">
        <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet">
    </head>
    <body>
        <% 
           String userId = request.getParameter("user_id");
        %>
        <button class="btn-back" onclick="window.history.back();">Trở lại</button>
        <div class="form-contanier">
            <form action="gdDatBan100.jsp?user_id=" method ="GET">
              <input type="hidden" name="user_id" value="<%= userId %>">
              <label for="datetime">Chọn ngày và giờ :</label>
              <input type="datetime-local" id="datetime" name="datetime">
              <button type="submit" value="Submit" name ="findTable">Tìm kiếm</button>
             </form>
            
        </div>
      
        <div class="">
            id cua nguoi dung : <%= userId %>
        </div>

        <%
            
            if (request.getParameter("findTable") != null) {
                String datetimeParam = request.getParameter("datetime");
                if (datetimeParam != null && !datetimeParam.isEmpty()) {
                    LocalDateTime localDateTime = LocalDateTime.parse(datetimeParam);
                    Timestamp thoiGian = Timestamp.valueOf(localDateTime);
                    DatBanDao100 datBanDao = new DatBanDao100();
                    List<Ban100> availableBans = datBanDao.getBanChuaDat(thoiGian);
                    
                    if (!availableBans.isEmpty()) {
        %>
        
        <h3>Danh sách bàn trống:</h3>
        <div class="table-container">
            <table border="1">
            <tr>
                <th>ID Bàn</th>
                <th>Sức chứa</th>
                <th>Trạng thái</th>
                <th>Đặt bàn</th>
            </tr>
            <%
            for (Ban100 ban : availableBans) {
            %>
            <tr>
                <td><%= ban.getId() %></td>
                <td><%= ban.getSucChua() %></td>
                <td><%= ban.getTrangThai() %></td>
                <td class="chonBan">
                    <form action="gdDatBan2100.jsp" method="GET">
                        <input type="hidden" name="banId" value="<%= ban.getId() %>">
                        <input type="hidden" name="user_id" value="<%= userId %>">
                        <button type="submit" name ="findTable">Chọn bàn</button> 
                    </form>
                </td>
            </tr>
            <%
        }
            %>
        </table>
        <div>
        
        <%
    } else {
        %>
        <p>Không có bàn trống vào thời gian này.</p>
        <%
    }
} else {
        %>
        <p>Vui lòng chọn ngày và giờ.</p>
        <%
    }
}
        %>
    </body>
</html>
