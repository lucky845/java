<%--
  Created by IntelliJ IDEA.
  User: 12876
  Date: 2021/8/17
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/10_cookie_session/loginServlet" method="get">
        用户名：<input type="text" name="username" value="${cookie.username.value}"/><br/>
        密码：<input type="text" name="password"/><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
