<%--
  Created by IntelliJ IDEA.
  User: anhph
  Date: 8/31/2023
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="../../account" method="post">
    <input type="text" placeholder="Tài khoản" name="username"><br>
    <input type="password" placeholder="Mật khẩu" name="password"><br>
    <button>Đăng nhập</button><br>
    <a href="register.jsp">Bạn chưa có tài khoản?</a>
</form>
</body>
</html>
