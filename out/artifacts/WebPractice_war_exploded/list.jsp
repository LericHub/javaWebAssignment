<%@ page import="domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.UserDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Byte
  Date: 2020/6/5
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<script>
    window.onload = function () {
        document.getElementById("delSelected").onclick = function () {
            document.getElementById("form").submit();
        }
        document.getElementById("headCheck").onclick =function () {
            var check = document.getElementsByTagName("input");
            for (var i = 1;i<check.length;i++){
                check[i].checked = this.checked;
            }
        }

    }
</script>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <form class="form-inline" style="float: left;margin-bottom: 10px" action="${pageContext.request.contextPath}/conditionSearch" method="get">
        <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" class="form-control" id="name" name="name" >
        </div>
        <div class="form-group">
            <label for="address">籍贯</label>
            <input type="text" class="form-control" id="address" name="address">
            <input type="text" class="form-control" id="address" name="address">
        </div>
        <button type="submit" class="btn btn-default"><b>查询</b></button>
    </form>

    <div style="float: right;margin-bottom: 10px">
        <a href="${pageContext.request.contextPath}/add.jsp" class="btn btn-primary" >添加联系人</a>
        <a href="javascript:void(0);" class="btn btn-primary" id="delSelected">删除选中</a>
        <a href="${pageContext.request.contextPath}/searchServlet" class="btn btn-primary">刷新</a>
    </div>
    <form action="${pageContext.request.contextPath}/deleteSelectedServlet" method="post" id="form">
        <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" name="select" id="headCheck"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${sessionScope.list}" var="user" varStatus="s">
            <tr>
                <td><input type="checkbox" name="select" value="${user.id}"></td>
                <td>${s.index+1}</td>
                <td>${user.username}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.birthplace}</td>
                <td>${user.qq}</td>
                <td>${user.mail}</td>
                <td>
                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/showServlet?id=${user.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/deleteServlet?id=${user.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </form>
<%--    分页条--%>
    <div>
        <nav>
            <ul class="pagination">
                <li>
                    <a href="${pageContext.request.contextPath}/pageSearchServlet?current=${sessionScope.pb.current-1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:if test="${sessionScope.pb.current == -1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/pageSearchServlet?current=0">
                                1
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/pageSearchServlet?current=1">
                                2
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/pageSearchServlet?current=2">
                                3
                        </a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.pb.current == 0}">
                <li class="active">
                    <a href="${pageContext.request.contextPath}/pageSearchServlet?current=${sessionScope.pb.current}">
                            ${sessionScope.pb.current +1}
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/pageSearchServlet?current=${sessionScope.pb.current + 1}">
                            ${sessionScope.pb.current + 2}
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/pageSearchServlet?current=${sessionScope.pb.current + 2}">
                            ${sessionScope.pb.current + 3}
                    </a>
                </li>
            </c:if>
                <c:if test="${sessionScope.pb.current >= 1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/pageSearchServlet?current=${sessionScope.pb.current - 1}">
                                ${sessionScope.pb.current }
                        </a>
                    </li>
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/pageSearchServlet?current=${sessionScope.pb.current}">
                                ${sessionScope.pb.current + 1}
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/pageSearchServlet?current=${sessionScope.pb.current + 1}">
                                ${sessionScope.pb.current + 2}
                        </a>
                    </li>
                </c:if>

                <li>
                    <a href="${pageContext.request.contextPath}/pageSearchServlet?current=${sessionScope.pb.current +1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="margin-left: 10px;font-size: 20px;color: grey">共${sessionScope.pb.size}条记录，共${sessionScope.pb.pageSize+1}页</span>
            </ul>
        </nav>

    </div>
</div>
</body>
</html>
