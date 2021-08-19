<%--
  Created by IntelliJ IDEA.
  User: 12876
  Date: 2021/8/19
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        System.out.println("a.jsp执行了");
        Object user = session.getAttribute("user");
        // 如果用户未登录
        if(user == null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

    %>

    我是a.jsp文件
</body>
</html>
