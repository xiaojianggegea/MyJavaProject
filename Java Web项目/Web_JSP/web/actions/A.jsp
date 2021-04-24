<%--
  Created by IntelliJ IDEA.
  User: 小江
  Date: 2020/12/22
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>A页面</title>
</head>
<body>
<h2>小明</h2>
<jsp:forward page="B.jsp">
    <jsp:param name="name" value="GuoHuaiJiang"/>
</jsp:forward>
</body>
</html>
