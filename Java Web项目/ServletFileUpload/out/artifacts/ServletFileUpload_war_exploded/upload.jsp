<%--
  Created by IntelliJ IDEA.
  User: 小江
  Date: 2020/12/21
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<%--
    文件上传
        1、准备表单
        2、设置表单的提交类型为Post
        3、设置表单类型为文件上传表单 enctype="multipart/form-data
        4 、设置文件提交的地址
        5、准备表单元素
            1、普通的表单项 type="text"
            2、文件项 type="file"
        6、设置表单元素name的属性的值（一定要设置表单name的属性值，否则后台无法接受数据）
--%>
<form method="post" enctype="multipart/form-data" action="servlet">
    姓名：<input type="text" name="uname"><br>
    文件：<input type="file" name="myfile"><br>
    <!--button-->
    <button>提交</button>
</form>
</body>
</html>
