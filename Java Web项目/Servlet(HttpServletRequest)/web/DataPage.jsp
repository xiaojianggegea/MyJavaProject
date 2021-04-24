<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 小江
  Date: 2020/12/19
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据显示页面</title>
</head>
<body>
<h2>信息页面</h2>
<%
    //获取域对象内容
    String name= (String) request.getAttribute("name");
    String age= (String) request.getAttribute("age");
    response.getWriter().write("姓名:"+name+"  "+"年龄:" +age);
%>
</body>
</html>
