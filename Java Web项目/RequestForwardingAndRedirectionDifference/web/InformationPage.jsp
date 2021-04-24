<%--
  Created by IntelliJ IDEA.
  User: 小江
  Date: 2020/12/20
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息页面</title>
</head>
<body>
<%
    //获取参数
    String username=request.getParameter("uname");
    String pwd= (String) request.getAttribute("pwd");

    //输出内容
    out.print("username:"+username+"  "+"pwd:"+pwd);
%>
</body>
</html>
