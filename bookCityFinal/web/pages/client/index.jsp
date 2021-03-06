<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("#pn_submit").click(function () {
				var pageNo = $("#pn_input").val();
				<%--var pageTotal = ${requestScope.page.pageTotal};--%>
				<%--alert(pageTotal);--%>
				// javaScript 语言中提供了一个location 地址栏对象
				// 它有一个属性叫href.它可以获取浏览器地址栏中的地址
				// href 属性可读，可写
				location.href = "${pageScope.basePath} ${requestScope.page.url}&pageNo=" + pageNo;
			});
/*			$("button.addToCart").click(function () {
				var bookId = $(this).attr("bookId");
				location.href = "${pageScope.basePath}cartServlet?action=addItem&id=" + bookId;
			})*/
			$("button.addToCart").click(function () {
				var bookId = $(this).attr("bookId");
				$.getJSON("${pageScope.basePath}cartServlet", "action=addItem&id=" + bookId, function (data) {
					if (data.countCart == 0) {
						$("#countCart").text("您的购物车中没有商品");
						$("#lastCart").text();
					} else {
						$("#countCart").text("您的购物车中有" + data.countCart + "件商品");
						$("#lastCart").text("您刚刚将" + data.lastName + "加入到了购物车中");
					}
				})
			})
		});
	</script>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
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
				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/ClientServlet" method="get">
					<input type="hidden" name="action" value="pageByPrice">
					<input type="hidden" name="pageNo" value="1">
					价格：<input id="min" type="text" name="min" value="${requestScope.min}"> 元 -
						<input id="max" type="text" name="max" value="${requestScope.max}"> 元
						<input type="submit" value="查询" />
				</form>
			</div>

			<div style="text-align: center">
				<span id="countCart">您的购物车中没有商品</span>
				<div>
					<span id="lastCart"></span>
				</div>
			</div>

			<c:forEach items="${requestScope.page.item}" var="item">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${item.imgPath}" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${item.name}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${item.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">￥${item.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${item.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${item.stock}</span>
						</div>
						<div class="book_add">
							<button bookId="${item.id}" class="addToCart">加入购物车</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<%@include file="/pages/common/page_menu.jsp"%>
	</div>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>