<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 8/31/2023
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <table>
                        <tr>
                            <td>Tài khoản:</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><a href="products">
                                <button class="btn btn-outline-success">Đăng xuất</button>
                            </a></td>
                            <td></td>
                        </tr>
                    </table>
                </li>
                <li></li>
            </ul>
            <form class="d-flex" role="search" method="post" action="">
                <input class="form-control me-2" type="" placeholder="Search" aria-label="Search" name="name_product">
                <button class="btn btn-outline-success" type="submit">Tìm kiếm</button>
            </form>
        </div>
    </div>
</nav>

<div style="text-align: center">
    <h2>Danh sách các bài đăng của bạn</h2>
</div>
<table>
    <tr>
        <td>Tiêu đề bài viết</td>
        <td>Nội dung bài viết</td>
    </tr>
    <c:forEach var="blog" items="blogList">
        <tr>
            <td><c:out value="${blog.getTittle()}"/></td>
            <td><c:out value="${blog.getContent()}"/></td>
        </tr>
    </c:forEach>
</table>

<%
    String message = (String) session.getAttribute("message");
%>
<%if (message != null && !message.isEmpty()) { %>
<script type="text/javascript">
    alert("<%= message %>");
</script>
<% } %>
<%
    session.removeAttribute("message");
%>
</body>
</html>
