<%--
  Created by IntelliJ IDEA.
  User: Byte
  Date: 2020/6/6
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
<%--    <base href="<%=basePath%>"/>--%>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="/updateSrevlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  readonly="readonly" value="${sessionScope.show.username}" />
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test='${sessionScope.show.gender=="女"}'>
                <input type="radio" name="gender" value="男"  />男
                <input type="radio" name="gender" value="女" checked />女
            </c:if>
            <c:if test='${sessionScope.show.gender=="男"}'>
                <input type="radio" name="gender" value="男" checked />男
                <input type="radio" name="gender" value="女"  />女
            </c:if>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age" value="${sessionScope.show.age}" />
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <c:if test='${sessionScope.show.birthplace == "日本"}'>
                <select name="address" id="address" class="form-control" >
                    <option value="日本" selected>日本</option>
                    <option value="中国">中国</option>
                    <option value="马来西亚">马来西亚</option>
                </select>
            </c:if>
            <c:if test='${sessionScope.show.birthplace == "中国"}'>
                <select name="address" id="address" class="form-control" >
                    <option value="日本" >日本</option>
                    <option value="中国" selected>中国</option>
                    <option value="马来西亚">马来西亚</option>
                </select>
            </c:if>
            <c:if test='${sessionScope.show.birthplace == "马来西亚"}'>
                <select name="address" id="address" class="form-control" >
                    <option value="日本" >日本</option>
                    <option value="中国">中国</option>
                    <option value="马来西亚" selected>马来西亚</option>
                </select>
            </c:if>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" name="qq" value="${sessionScope.show.qq}"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" name="mail" value="${sessionScope.show.mail}"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" onclick="javascript:history.back(-1);"/>
        </div>
    </form>
</div>
</body>
</html>
</body>
</html>
