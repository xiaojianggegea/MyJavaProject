<%--
  Created by IntelliJ IDEA.
  User: 小江
  Date: 2020/12/21
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息页面</title>
</head>
<body>
<%
    //获取session域对象
    String uname= (String) request.getSession().getAttribute("uname");
    String pwd= (String) request.getSession().getAttribute("pwd");

    //获取request对象
    String name= (String) request.getAttribute("Requestname");

    //输出数据、
    out.print("uname:"+uname+"  "+"pwd:"+pwd+"  "+"Requestname:"+name);
%>
</body>
</html>
