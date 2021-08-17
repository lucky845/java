<%--
  Created by IntelliJ IDEA.
  User: 12876
  Date: 2021/8/17
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="registServlet" method="get">
      用户名：<input type="text" name="username" id=""><br>
      验证码:<input type="text" style="width: 80px" name="code">
      <img src="http://localhost:8080/tmp/kaptcha.jpg" alt="" style="width: 100px;height: 30px"><br>
              <input type="submit" value="提交"/><br>
    </form>
  </body>
</html>
