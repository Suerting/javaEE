<%--
  Created by IntelliJ IDEA.
  User: LX
  Date: 2022/12/23
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>修改页面,修改数据的id为${id}</h2>
<form action="updatebook" method="post">
    <input type="hidden" name="id" value="${id}">
    书名：<input type="text" name="bookname"  value="${books.bookname }"/><br>
    作者：<input type="text" name="author" value="${books.author }"/><br>
    价钱：<input type="text" name="price" value="${books.price }"/><br>
    状态：<input type="radio" name="status" value="0">售出
    <input type="radio" name="status" value="1">未售出</br>
    <input type="submit">
</form>
</body>
</html>
