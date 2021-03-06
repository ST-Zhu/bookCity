<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("a.delete").click(function () {
				// 在事件的function 函数中，有一个this 对象。这个this 对象，是当前正在响应事件的dom 对象.(比如:<a>删除</a>)
				/**
				 * confirm 是确认提示框函数
				 * 参数是它的提示内容
				 * 它有两个按钮，一个确认，一个是取消。
				 * 返回true 表示点击了，确认，返回false 表示点击取消。
				 */
				return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
				// return false// 阻止元素的默认行为===不提交请求
			});
			$("#pn_submit").click(function () {
				var pageNo = $("#pn_input").val();
				<%--var pageTotal = ${requestScope.page.pageTotal};--%>
				<%--alert(pageTotal);--%>
				// javaScript 语言中提供了一个location 地址栏对象
				// 它有一个属性叫href.它可以获取浏览器地址栏中的地址
				// href 属性可读，可写
				location.href = "${pageScope.basePath} manager/bookServlet?action=page&pageNo=" + pageNo;
			});
		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.item}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td>${item.author}</td>
					<td>${item.sales}</td>
					<td>${item.stock}</td>
					<td><a href="manager/bookServlet?action=getBook&id=${item.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
					<td>
						<a class="delete" href="manager/bookServlet?action=delete&id=${item.id}&pageNo=${requestScope.page.pageNo}">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?action=add&pageNo=${requestScope.page.pageNo}">添加图书</a></td>
			</tr>	
		</table>
	</div>

	<%@include file="/pages/common/page_menu.jsp"%>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>