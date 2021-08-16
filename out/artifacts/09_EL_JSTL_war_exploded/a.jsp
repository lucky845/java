<%--
  Created by IntelliJ IDEA.
  User: 12876
  Date: 2021/8/15
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
      request.setAttribute("key","值");

    %>
    表达式脚本输出key的值是：<%=request.getAttribute("key1")==null?"":request.getAttribute("key1")%> <br/>
    EL表达式输出key的值是：${ key1 }

</body>
</html>
