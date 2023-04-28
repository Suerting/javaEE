<%--
  Created by IntelliJ IDEA.
  User: LX
  Date: 2022/12/1
  Time: 16:09
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
    <title>allbooklist</title>
    <base href="<%=basePath%>">
</head>
<body>
操作成功
<a href="findAll" methods="get">返回显示页面，查看结果</a>
</body>
</html>
