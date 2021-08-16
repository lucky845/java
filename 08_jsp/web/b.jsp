<%--
  Created by IntelliJ IDEA.
  User: 12876
  Date: 2021/8/15
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         errorPage="/error500.jsp"
         language="java" %>
<!--
errorpags表示错误后自动跳转去的路径  <br/>
这个路径一般都是以斜杠打头，他表示请求地址为http://ip:port/工程路径/
映射到代码的web目录
-->

<html>
<head>
    <title>Title</title>
</head>
<body>
    这是b.jsp页面数据
    <!-- 这是HTML注释 -->
    <%
        // 这是java单行注释
        /* 这也是java多行注释 */
    %>

    <%-- 这是jsp注释 --%>
</body>
</html>
