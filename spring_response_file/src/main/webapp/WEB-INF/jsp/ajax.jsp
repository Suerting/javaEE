<%--
  Created by IntelliJ IDEA.
  User: LX
  Date: 2022/11/11
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

<%--    <script type="text/javascript" src="js/jquery-3.1.1.js"></script>--%>
<%--    <script type="text/javascript">--%>
<%--        $.ajax({--%>
<%--            type:"post",--%>
<%--            url:"test9",--%>
<%--            data:"",--%>
<%--            contentType:"application/json;charset=utf-8",--%>
<%--            success:function(data){--%>
<%--                alert(data);--%>
<%--            }--%>
<%--        })--%>
<%--    </script>--%>
</head>
<body>
<form action="test11" method="post" enctype="multipart/form-data">
    选择文件1：<input type="file" name="file1"><br>
    选择文件2：<input type="file" name="file1"><br>
    选择文件3：<input type="file" name="file1"><br>
    <input type="submit">
</form>
</body>
</html>
