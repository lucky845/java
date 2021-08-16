<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 12876
  Date: 2021/8/15
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Map<String, Object> map = new HashMap<>();
        map.put("a.a.a", "aaaValue");
        map.put("b+b+b", "bbbValue");
        map.put("c-c-c", "cccValue");

        request.setAttribute("map",map);
    %>
<%--    []中括号运算，可以输出有序集合中某个元素的值。--%>
<%--    并且[]中括号运算，还可以输出 map 集合中 key 里含有特殊字符的 key 的值--%>
    ${ map['a.a.a'] } <br/>
    ${ map['b+b+b'] } <br/>
    ${ map['c-c-c'] } <br/>

</body>
</html>
