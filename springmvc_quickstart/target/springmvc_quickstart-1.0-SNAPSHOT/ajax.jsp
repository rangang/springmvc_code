<%--
  Created by IntelliJ IDEA.
  User: zhsmac
  Date: 2022/10/28
  Time: 7:02 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>

    <button id="btn1">ajax异步请求</button>

    <%--  ajax异步交互  --%>
    <script>
        $("#btn1").click(function(){
            let url = '${pageContext.request.contextPath}/user/ajaxRequest';
            let data = '[{"id":1,"username":"张三"},{"id":2,"username":"李四"}]';

            $.ajax({
                type: 'POST',
                url: url,
                data: data,
                contentType: 'application/json;charset=utf-8',
                success: function(resp){
                    alert(JSON.stringify(resp))
                }
            })
        })


    </script>
</body>
</html>
