<%--
  Created by IntelliJ IDEA.
  User: 小江
  Date: 2020/12/22
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>JSP编写Java代码</title>
</head>
<body>
//用Java获取当前时间<br>
现在时间：<%= new java.util.Date()%><br>

//与HTML直接编写<br>
<h4>现在时间:<%= new java.util.Date()%></h4><br>

   //小脚本<br>
<%
    String a="这是一个局部变量";
    out.print(a);   //打印在客户端页面
    System.out.println(a);   //打印在控制台
%>
<br>

   //声明脚本<br>
<%!
    String b="这是一个全局变量";
    public String m1(){
        String  c="这是一个定义函数！";
        return c;
    }

%>
<%
    out.print(b);
    System.out.println(b);
    System.out.println(m1());
    m1(); //调用方法
%><br>

//输出脚本><br>
<%=m1()%><br>

//JSP注释<br>
<%--这是一个JSP注释--%>
//HTML注释<br>
<!-- 这是一个HTML注释,在源文件中可以看到 -->

//错误脚本，发生错误跳转到错误界面error.jsp<br>
<%--<%=10/0%>--%>

//import 导包
</body>
</html>
