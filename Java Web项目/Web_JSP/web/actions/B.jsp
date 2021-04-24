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
    <title>B页面</title>
</head>
<body>
<h2>王麻子<h2>
    <%
        String name=request.getParameter("name");
    %>
    <%=name%>
</body>
</html>
