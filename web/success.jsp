<%--
  Created by IntelliJ IDEA.
  User: 51459
  Date: 2018-07-23
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${xiaoxi} <br>
    <a href="Searchall">查看所有用户</a>
</body>
</html>
