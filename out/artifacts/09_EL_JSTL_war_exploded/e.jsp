<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 12876
  Date: 2021/8/15
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--  empty运算  --%>
    <%
//        1、值为 null 值的时候，为空
        request.setAttribute("emptyNull",null);
//        2、值为空串的时候，为空
        request.setAttribute("emptyString","");
//        3、值是 Object 类型数组，长度为零的时候
        request.setAttribute("emptyArrr",new Object[]{});
//        4、list 集合，元素个数为零
        List<String> list = new ArrayList<>();
//        list.add("abc");
        request.setAttribute("emptyList",list);
//        5、map 集合，元素个数为零
        Map<String, Object> map = new HashMap<String,Object>();
//        map.put("key1", "value1");
        request.setAttribute("emptyMap",map);
    %>

    ${ empty emptyNull } <br/>
    ${ empty emptyString } <br/>
    ${ empty emptyArrr } <br/>
    ${ empty emptyList } <br/>
    ${ empty emptyMap } <br/>

    <hr>
    ${ 12 == 12 ? "我好帅":"我不帅" }

</body>
</html>
