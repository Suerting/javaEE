<%--
  Created by IntelliJ IDEA.
  User: LX
  Date: 2022/11/18
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            +request.getContextPath() + "/";
%>
<html>
<head>
    <title>register</title>
    <base href="<%=basePath%>">
</head>
<body>
<h2>注册</h2>
<form action="register" method="post">
     <input type="text" name="username"><br>
     <input type="password" name="password"><br>
     <input type="submit" value="注册">
</form>
<a href="userregister" methods="get">已有账号，进行登录</a>
</body>
</html>
