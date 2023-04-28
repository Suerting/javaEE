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
</head>
<body>
<a href="addbookjump" methods="post">添加学生</a>
<table border="1" cellspacing="0" width="50%" style="text-align: center">
    <tr>
<%--        <th></th>--%>
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
<%--            <td><input type="checkbox" /></td>--%>
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
                |
                <a href="updatejump?id=${b.id}">修改</a>
            </td>
        </tr>
    </c:forEach>

</table>
<a href="fenye?pageNo=${pageD.pageNum-1}&pageSize=${pageD.pageSize}">前一页</a>
<c:forEach begin="1" end="${pageD.pages}" step="1" var="i">
    <a href="fenye?pageNo=${i}&pageSize=${pageD.pageSize}">${i}</a>
</c:forEach>
<a href="fenye?pageNo=${pageD.pageNum+1}&pageSize=${pageD.pageSize}">后一页</a>

</body>
</html>
