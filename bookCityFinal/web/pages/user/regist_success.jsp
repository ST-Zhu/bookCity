<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>ST-Zhu会员注册页面</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.gif" >
				<span class="wel_word"></span>
			<div>
				<a href="pages/user/login.jsp">登录</a> |
				<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
				<a href="index.jsp">返回商城</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="pages/user/login.jsp">转到登录</a></h1>
	
		</div>

		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>