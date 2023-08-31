<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Title</title>
  <style>
    image {
      width: 150px;
      height: 150px;
    }
  </style>
</head>

<body>
<a href="">Blog</a>
<a href=""></a>
<form action="/view" method="get">
  <input type="hidden" name="action" value="search">
  <input type="text" placeholder="search by name" name="nameSearch">
  <button>Tìm</button>
</form>
<a href=""></a>
<table border="1">
  <tr>
    <th>Ảnh</th>
    <th>Tên</th>
    <th></th>

    <th colspan="2">Action</th>
  </tr>

  <c:forEach items="${listblog}" var="listblog">

    <tr>
      <input type="hidden" name="pId" value="${blog.id}">
      <td><img src="${blog.title}" style="width: 150px ; height:  150px" alt="sv"></td>
      <td>${blog.content}</td>
      <td>${blog.create_at}</td>
      <td>
        <form action="http://localhost:8080/oder">
          <input type="hidden" name="action" value="addToCart">
          <input type="hidden" name="idProduct" value="${product.id}">
          <input type="hidden" name="idUser" value="${idUser}">
          <button></button>
        </form>
      </td>
      <td></td>
    </tr>

  </c:forEach>

</table>


</body>
</html>