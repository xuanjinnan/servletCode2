<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/10
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传实例 - 菜鸟教程</title>
</head>
<body>
    <h1>文件上传实例 - 菜鸟教程</h1>
    <form action="/web_war_exploded/UploadServlet" method="post" enctype="multipart/form-data">
        选择第一个文件
        <input type="file" name="uploadFile1">
        <br/>
        选择第二个文件
        <input type="file" name="uploadFile2">
        <br/>
        <input type="submit" value="上传">
    </form>
</body>
</html>
