<%--
  Created by IntelliJ IDEA.
  User: 小江
  Date: 2020/12/21
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>文件下载</title>
</head>
<body>
<%--
    超链接下载
        使用超链接（a标签）时，如果遇到浏览器能够识别的资源，则会显示资源。否则会进行下载
    download属性下载
        通过download属性规定浏览器进行下载
        download属性可以不写任何信息，会自动使用默认文件名，若设置了download属性的值，则使用设置的值作为文件名

--%>
<a href="download/test.txt">文本文件</a>
<a href="download/郭怀江.png">图片文件</a>
<a href="download/test.rar">压缩文件</a>

<hr>
<a href="download/test.txt" download>文本文件</a>
<a href="download/郭怀江.png" download="郭怀江.png">图片文件</a>
<hr>
<form action="${pageContext.request.contextPath}/downloadServlet">
    文件名：<label>
    <input type="text" name="fileName" placeholder="请输入要下载的文件名">
</label>
    <button>下载</button>
</form>

</body>
</html>
