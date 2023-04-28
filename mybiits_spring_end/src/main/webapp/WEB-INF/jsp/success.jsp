<%--
  Created by IntelliJ IDEA.
  User: LX
  Date: 2022/12/23
  Time: 20:11
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
操作成功
<a href="findAllBook" methods="get">返回显示页面，查看结果</a>
</body>
</html>
