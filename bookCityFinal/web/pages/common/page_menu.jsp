<%--
  Created by IntelliJ IDEA.
  User: ZST-PC
  Date: 2021/11/11
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <div id="page_nav">
    <c:if test="${requestScope.page.pageNo != 1}">
      <a href="${requestScope.page.url}&pageNo=1">首页</a>
      <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
    </c:if>
    <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
      <c:if test="${requestScope.page.pageNo == i}">
        <a href="${requestScope.page.url}&pageNo=${i}">【${i}】</a>
      </c:if>
      <c:if test="${requestScope.page.pageNo != i}">
        <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
      </c:if>

    </c:forEach>
    <c:if test="${requestScope.page.pageNo != requestScope.page.pageTotal}">
      <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
      <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input name="pn" id="pn_input" value="${requestScope.page.pageNo}"/>页
    <input type="button" value="确定" id="pn_submit">
  </div>

</body>
</html>
