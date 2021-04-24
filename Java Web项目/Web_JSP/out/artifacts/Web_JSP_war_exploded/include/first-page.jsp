<%--
  Created by IntelliJ IDEA.
  User: 小江
  Date: 2020/12/22
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>第一页面</title>
</head>
<body>
<h2>第一页面</h2>
<%
    String a="first";
%>
<%= a%>
</body>
<%-- include指令 --%>
<%@include file="second-page.jsp"%>
<%@include file="third-page.jsp"%>
</html>
