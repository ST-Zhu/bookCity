<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("a.deleteItem").click(function () {
				return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
			})

			$("a.clear").click(function () {
				return confirm("你确定要清空购物车吗?");
			})

			// 给输入框绑定onchange 内容发生改变事件
			$(".updateCount").change(function () {
				// 获取商品名称
				var name = $(this).parent().parent().find("td:first").text();
				var id = $(this).attr('bookId');
				// 获取商品数量
				var count = this.value;
				if ( confirm("你确定要将【" + name + "】商品修改数量为：" + count + " 吗?") ) {
				//发起请求。给服务器保存修改
					if (count > 0) {
						location.href = "${pageScope.basePath}cartServlet?action=updateCount&count="+count+"&id="+id;
					} else {
						location.href = "${pageScope.basePath}cartServlet?action=deleteItem&id="+id;

					}

				} else {
					// defaultValue 属性是表单项Dom 对象的属性。它表示默认的value 属性值。
					this.value = this.defaultValue;
				}
			});
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
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
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5"><a href="index.jsp">亲，当前购物车为空！快跟小伙伴们去浏览商品吧！！！</a>
					</td>
				</tr>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="item">
					<tr>
						<td>${item.value.name}</td>
						<td>
							<input class="updateCount" style="width: 80px;" bookId="${item.value.id}" type="text" value="${item.value.count}">
						</td>
						<td>${item.value.price}</td>
						<td>${item.value.totalPrice}</td>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${item.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>

		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a class="clear" href="cartServlet?action=clear">清空购物车</a></span>
				<c:if test="${empty sessionScope.user}">
					<span class="cart_span"><a href="pages/user/login.jsp">请先登录</a></span>
				</c:if>
				<c:if test="${not empty sessionScope.user}">
					<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
				</c:if>
			</div>
		</c:if>
	
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>