<%--
  Created by IntelliJ IDEA.
  User: 小江
  Date: 2020/12/22
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userBean</title>
</head>
<body>
<%-- id对象名 class全限定名 --%>
<jsp:useBean id="user" class="com.ghj.jsp.User"/>

<%-- jsp:setProperty()修改设置属性--%>
<jsp:setProperty name="user" property="name" value="郭怀江"/>
<jsp:setProperty name="user" property="password" value="123456"/>

<%----%>
<h4><jsp:getProperty name="user" property="name"/><br></h4>
<h4><jsp:getProperty name="user" property="password"/></h4>
</body>
