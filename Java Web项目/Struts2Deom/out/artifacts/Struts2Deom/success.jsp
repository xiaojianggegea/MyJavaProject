<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 80580
  Date: 2020/11/13
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功界面</title>
</head>
<body>
<h2>登录成功!<br>用户登录信息:</h2>
用户名:<s:property value="username"></s:property> <br>
密码:  <s:property value="password"></s:property><br>
</body>
</html>
