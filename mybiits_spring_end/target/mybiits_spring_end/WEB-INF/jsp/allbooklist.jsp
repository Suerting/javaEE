<%--
  Created by IntelliJ IDEA.
  User: LX
  Date: 2022/12/23
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<%--    <script>--%>
<%--        window.location.href="findAllBook";--%>
<%--    </script>--%>
</head>
<body>
<form action="searchbook" method="post">
    <input type="search" name="bookname" placeholder="请输入书名">
    <input type="submit"value="搜索">
</form>

<a href="addbookjump" methods="post">添加图书</a>
<table border="1" cellspacing="0" width="50%" style="text-align: center;">
    <tr>
        <th>序号</th>
        <th>编号</th>
        <th>书名</th>
        <th>作者</th>
        <th>价钱</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${books}" var="b" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${b.id}</td>
            <td>${b.bookname}</td>
            <td>${b.author}</td>
            <td>${b.price}</td>
            <c:if test="${b.status==1}">
                <td>未售出</td>
            </c:if>
            <c:if test="${b.status==0}">
                <td>售出</td>
            </c:if>
            <td>
                <a href="deletebook?id=${b.id}">删除</a>
                <a href="updatejump?id=${b.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p style="color: red">${error}</p>
</body>
</html>
