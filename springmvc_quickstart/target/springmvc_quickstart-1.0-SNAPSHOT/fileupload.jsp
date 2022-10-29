<%--
  Created by IntelliJ IDEA.
  User: zhsmac
  Date: 2022/10/29
  Time: 9:51 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        编写一个满足文件上传三要素的表单
        1.表达提交方式必须是post
        2.表单的enctype属性必须要修改成multipart/form-data
        3.表单中必须要有文件上传项
    --%>
    <form action="${pageContext.request.contextPath}/fileUpload" method="post" enctype="multipart/form-data">
        名称：<input type="text" name="username"><br>
        文件：<input type="file" name="filePic"><br>
        <input type="submit" value="单文件上传">
    </form>

    <%--实现多文件上传--%>
    <form action="${pageContext.request.contextPath}/filesUpload" method="post" enctype="multipart/form-data">
        名称：<input type="text" name="username"><br>
        文件1：<input type="file" name="filePic"><br>
        文件2：<input type="file" name="filePic"><br>
        <input type="submit" value="多文件上传">
    </form>
</body>
</html>
