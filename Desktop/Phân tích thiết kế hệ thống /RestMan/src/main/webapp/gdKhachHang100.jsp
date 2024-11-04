<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DB.Dao" %>
<%@ page import="Dao.NguoiDungDao100" %>
<%@ page import="Object.NguoiDung100" %>
<%@ page import="java.util.*" %>
<%
    NguoiDung100 user = new NguoiDung100();
    String id = request.getParameter("user_id");
    NguoiDungDao100 nguoiDungDao = new NguoiDungDao100();
    Integer userId = Integer.parseInt(id);
    user = nguoiDungDao.getUserById(userId);
        
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/customer.css">
        <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet">
    </head>
    <body>
        <nav>
            <a href="">Home </a>
            <a href="">About</a>
            <a href="gdDatBan100.jsp?user_id=<%= user.getUserId()%>">DatBan</a>
            <a href="">Service</a>
            <a href="">Contant</a>
            <span></span>
             <div class="btn-dang-xuat">
            <button onclick="window.history.back();"> Đăng xuất</button>
            </div>  
        </nav>
        
       
    </body>
</html>
