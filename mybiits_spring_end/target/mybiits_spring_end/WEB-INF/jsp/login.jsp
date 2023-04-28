
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            +request.getContextPath() + "/";
    System.out.println(basePath);
%>
<html>
<head>
    <title>login</title>
    <base href="<%=basePath%>">
    <style>
        input{
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div style="text-align: center;padding-top: 10px">
    <form action="login" method="post">
        用户名：<input type="text" name="username"><br>
        密码：&nbsp;<input type="password" name="password"><br>
        <input type="submit" value="登录">
    </form>
    <a href="userregister" methods="get">没有账号，进行注册</a>
    <p style="color: red">${msg}</p><br>
</div>

</body>
</html>
