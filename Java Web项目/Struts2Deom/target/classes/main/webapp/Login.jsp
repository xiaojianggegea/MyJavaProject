<%--
  Created by IntelliJ IDEA.
  User: 小江
  Date: 2020/11/13
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <form action="LoginAction" method="post">
        用户名:<input type="text" name="username" placeholder="请输入用户名"/><br>
        密码: <input type="password" name="password" placeholder="请输入密码"/><br>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
