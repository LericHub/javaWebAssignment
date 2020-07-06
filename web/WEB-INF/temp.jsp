<%--
  Created by IntelliJ IDEA.
  User: Byte
  Date: 2020/6/7
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach begin="0" end="${sessionScope.pb.pageSize}" step="1" varStatus="x">
    <c:if test="${sessionScope.pb.current== x.index}">
        <li class="active">
            <a href="${pageContext.request.contextPath}/pageSearchServlet?current=${x.index}">
                    ${x.index+1}
            </a>
        </li>
    </c:if>
    <c:if test="${sessionScope.pb.current != x.index}">
        <li>
            <a href="${pageContext.request.contextPath}/pageSearchServlet?current=${x.index}">
                    ${x.index+1}
            </a>
        </li>
    </c:if>
</c:forEach>
</body>
</html>
