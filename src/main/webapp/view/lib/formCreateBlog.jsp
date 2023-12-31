<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 8/30/2023
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body onload="">
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
                            <td><a href=""><button class="btn btn-outline-success">Đăng xuất</button></a></td>
                            <td></td>
                        </tr>
                    </table>
                </li>
                <li></li>
            </ul>
        </div>
    </div>
</nav>
<div style="text-align: center">
    <h2>Bạn đang tạo một blog</h2>
    <a href="blogs?action=showListBlogByUser&&id_account=1"><button type="button">Xem blog mà bạn đã đăng</button></a>
</div>
<form method="post" action="blogs?action=createBlog">
    <table class="table table-hover">
        <tr>
            <th>Nhập tiêu đề của blog:</th>
            <td>
                <input class="form-control" type="text" name="tittle" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Nhập nội dung của blog:</th>
            <td>
                <input class="form-control" type="text" name="content" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Lựa chọn danh mục của blog:</th>
            <td>
                <select name="id_category">
                    <c:forEach items="${categoryList}" var="category">
                        <option value="${category.getId()}">${category.getName()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Ngày tháng năm đăng blog:</th>
            <td>
                <input class="form-control" type="date" name="create_at" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Chọn ảnh cho bài viết của bạn:</th>
            <td>
                <input type="file" name="url_image" onchange="" accept="image/gif, image/jpeg, image/png">
            </td>
        </tr>
        <tr>
            <th>ID nguời đăng blog:</th>
            <td>
                <input class="form-control" type="number" name="id_account" size="45"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"></td>
            <button type="submit">Đăng blog</button>
        </tr>
    </table>
</form>
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
