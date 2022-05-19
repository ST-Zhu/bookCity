<%--
  Created by IntelliJ IDEA.
  User: ZST-PC
  Date: 2021/11/4
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserWelcome</title>
</head>
<body>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临ST-Zhu书城</span>
        <a href="orderServlet?action=showMyOrders&userId=${sessionScope.user.id}">我的订单</a>
        <a href="userServlet?action=logout">退出登录</a>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>
</body>
</html>
