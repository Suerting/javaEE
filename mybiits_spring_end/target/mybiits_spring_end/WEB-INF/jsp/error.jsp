<%--
  Created by IntelliJ IDEA.
  User: LX
  Date: 2022/11/20
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            +request.getContextPath() + "/";
    System.out.println(basePath);
%>

<html>
<head>
    <title>error</title>
    <base href="<%=basePath%>">
</head>
<body>
操作失败
<a href="findAllBook" methods="get">返回显示页面</a>
</body>
</html>