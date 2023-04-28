<%--
  Created by IntelliJ IDEA.
  User: LX
  Date: 2022/11/30
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            +request.getContextPath() + "/";
    System.out.println(basePath);
%>
<html>
<head>
    <title>add</title>
    <base href="<%=basePath%>">
</head>
<body>
<h2>添加页面</h2>
<form action="addbooks" method="post">
    书名：<input type="text" name="bookname"/><br>
    作者：<input type="text" name="author"/><br>
    价钱：<input type="text" name="price"/><br>
    状态：<input type="radio" name="status" value="0">售出
    <input type="radio" name="status" value="1">未售出</br>
    <input type="submit">
</form>
</body>
</html>
