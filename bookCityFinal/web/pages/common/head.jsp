<%--
  Created by IntelliJ IDEA.
  User: ZST-PC
  Date: 2021/11/4
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Head</title>
</head>
<body>
    <%
        String basePath = request.getScheme()
                        + "://"
                        + request.getServerName()
                        + ":"
                        + request.getServerPort()
                        + request.getContextPath()
                        + "/";
    %>
    <base href=<%= basePath%>>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
</body>
</html>
