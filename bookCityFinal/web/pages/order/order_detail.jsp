<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>订单详情</title>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单详情</span>
		<div>
			<c:if test="${empty sessionScope.user}">
				<a href="pages/user/login.jsp">登录</a> |
				<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
			</c:if>
			<c:if test="${not empty sessionScope.user}">
				<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临ST-Zhu书城</span>
				<a href="orderServlet?action=showMyOrders&userId=${sessionScope.user.id}">我的订单</a>
				<a href="userServlet?action=logout">退出登录</a>&nbsp;&nbsp;
			</c:if>
			<a href="index.jsp">返回商城</a>
			<a href="pages/manager/manager.jsp">后台管理</a>
		</div>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
			</tr>
			<c:forEach items="${sessionScope.orderItems}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.count}</td>
					<td>${item.price}</td>
					<td>${item.totalPrice}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>