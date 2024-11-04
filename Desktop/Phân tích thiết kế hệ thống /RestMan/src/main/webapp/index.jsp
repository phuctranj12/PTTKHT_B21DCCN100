<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="Dao.NguoiDungDao100" %>
<%@ page import="Object.NguoiDung100" %>
<%@ page import="Dao.KhachHangDao100" %>
<%@ page import="Object.KhachHang100" %>
<%
    String errorMessage = "";

    if (request.getParameter("submitRegister") != null) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        NguoiDung100 newUser = new NguoiDung100();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);

        NguoiDungDao100 userDao = new NguoiDungDao100();
        KhachHangDao100 khd = new KhachHangDao100();
        if (userDao.checkRegister(newUser) == false) {
            errorMessage = "Tên người dùng đã tồn tại.Vui lòng chọn tên đăng nhập .";
        } else {
            userDao.addUser(newUser);
            khd.addKhachHang(newUser);
            errorMessage = "Đăng ký thành công!";
        }
    }
    
     if (request.getParameter("submitLogin") != null) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        NguoiDung100 newUser = new NguoiDung100();
        newUser.setUsername(username);
        newUser.setPassword(password);
        NguoiDungDao100 userDao = new NguoiDungDao100();

        if (username.equals("admin") && password.equals("123")) {
            response.sendRedirect("gdQuanLy100.jsp"); 
        } else if(userDao.checkLogin(newUser) == false) {
            errorMessage = "Sai tên đăng nhập hoặc mật khẩu";
        }else{
        int userId = userDao.getUserIdByUsername(username);
            response.sendRedirect("gdKhachHang100.jsp?user_id=" + userId); 
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet">
    </head>

    <body>
        <!-- JavaScript để hiện alert nếu có thông báo -->
        <% if (!errorMessage.equals("")) { %>
        <script type="text/javascript">
            alert("<%= errorMessage %>");
        </script>
        <% } %>
        <div class="container" id="container">
            <div class ="form-container register-container">
                <form action="index.jsp" method="POST">
                    <h1>Refgister</h1>
                    <input type="text" placeholder="UserName" id="username" name ="username" required/>
                    <input type="email" placeholder="Email" id="email" name ="email" required/>
                    <input type="password" placeholder="Password" id="password" name ="password" required/>
                    <button type="submit" name="submitRegister">Register</button>
                    <span>or use your account</span>
                    <div class="social-container">
                        <a href="#" class="social"><i class="lni lni-facebook-fill"></i></a>
                        <a href="#" class="social"><i class="lni lni-google"></i></a>
                        <a href="#" class="social"><i class="lni lni-linkedin-original"></i></a>
                    </div>
                </form>
            </div>

            <div class ="form-container login-container">
                <form action ="index.jsp" method="POST">
                    <h1>Login</h1>
                    <input type="text" placeholder="UserName" id="username" name ="username" required/>
                    <input type="password" placeholder="Password" id="password" name ="password" required/>
                    <div class="content">
                        <div class="checkbox">
                            <input type="checkbox" name="checkbox" id = "checkbox">
                            <label for="Remember me">Remember me</label>
                        </div>
                        <div class="pass-link">
                            <a href="#">Forgot Password?</a>
                        </div>
                    </div>
                    <button name ="submitLogin" type="submit">Login</button>
                    <span>or use your acount</span>
                    <div class="social-container">
                        <a href="#" class="social"><i class="lni lni-facebook-fill"></i></a>
                        <a href="#" class="social"><i class="lni lni-google"></i></a>
                        <a href="#" class="social"><i class="lni lni-linkedin-original"></i></a>
                    </div>
                </form>
            </div>

            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1 class="title">Hello<br>customers</h1>
                        <p>if you have an acount , login here and have fun</p>
                        <button class="ghost" id="login">Login
                            <i class="lni lni-arrow-left login"></i>
                        </button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1 class="title">Start your <br> order now</h1>
                        <p>if you don'n have an acount , join us</p>
                        <button class="ghost" id="register">Register
                            <i class="lni lni-arrow-right register"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <script src="script/login.js"></script>
    </body>
</html>
