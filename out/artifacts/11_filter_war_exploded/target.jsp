<%--
  Created by IntelliJ IDEA.
  User: 12876
  Date: 2021/8/19
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
      System.out.println("target.jsp执行了");
      System.out.println("target.jsp线程 " + Thread.currentThread().getName());
  %>
</body>
</html>
