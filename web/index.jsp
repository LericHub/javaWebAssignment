<%--
  Created by IntelliJ IDEA.
  User: Byte
  Date: 2020/6/5
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
  <meta charset="UTF-8">
  <style>
    #link{
      text-align: center;
      font-size: 50px;
    }
    a:hover{
      color: #2b669a;
    }
    a:link{
      color: #66cdff;
    }
    a:visited{
      color: #66cdff;
    }
  </style>
</head>
<body>
<b>${sessionScope.user},欢迎您</b>
<div id="link">
  <a href="${pageContext.request.contextPath}/searchServlet" style="text-align: center;text-decoration-line: none">用户信息查询</a>
</div>
</body>
</html>
