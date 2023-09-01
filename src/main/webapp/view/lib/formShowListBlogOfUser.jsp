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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

    <style>
        #imgBlogListByUser {
            width: 200px;
            height: 200px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <div>
            <table>
                <tr>
                    <td>TÀI KHOẢN:</td>
                    <td></td>
                </tr>
                <tr>
                    <td><a href="">
                        <button class="btn btn-outline-success">ĐĂNG XUẤT</button>
                    </a></td>
                    <td></td>
                </tr>
            </table>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-left: 150px">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">TRANG CHỦ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true">XEM BÀI ĐĂNG THEO DANH MỤC</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        DANH MỤC
                    </a>
                    <ul class="dropdown-menu">
                        <c:forEach items="${categoryList}" var="category">
                            <li><a class="dropdown-item" href="blogs?action=showBlogByCategory&&id_category=${category.getId()}&&id_account=1">${category.getName()}</a></li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div style="text-align: center; margin-top: 50px; margin-bottom: 30px">
    <h2>DANH SÁCH BÀI ĐĂNG CỦA BẠN</h2>
</div>
<c:forEach items="${blogList}" var="blog">
    <div style="display: flex">
        <div style="flex: 1;"></div>
        <div style="flex: 2; text-align: center; align-items: center;">
            <div>
                <h3><c:out value="${blog.getTitle()}"/></h3>
            </div>
            <div>
                <c:forEach items="${imgBlogList}" var="img">
                    <c:if test="${blog.getId() == img.getId_blog()}">
                        <img src="${img.getUrl_image()}" alt="Không có ảnh!!!" id="imgBlogListByUser">
                    </c:if>
                </c:forEach>

            </div>
            <div><c:out value="${blog.getContent()}"/></div>
            <hr>
            <br>
        </div>
        <div style="flex: 1;"></div>
    </div>

</c:forEach>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>
