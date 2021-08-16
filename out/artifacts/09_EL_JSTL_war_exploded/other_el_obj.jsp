<%--
  Created by IntelliJ IDEA.
  User: 12876
  Date: 2021/8/15
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    输出请求参数username的值：${ param.username } <br/>
    输出请求参数password的值：${ param.password } <br/>

    输出请求参数username的值：${ paramValues.username[1] } <br/>
    输出请求参数password的值：${ paramValues.password[1] } <br/>
    <hr>

    输出请求头的值：${ header } <br/>
    输出请求头[User-Agent]的值：${ header['User-Agent'] } <br/>
    输出请求头[connection]的值：${ header['connection'] } <br/>
    输出请求头[User-Agent]的值：${ headerValues['User-Agent'][0] } <br/>
    <hr>

    输出Cookie的名称：${ cookie.JSESSIONID.name } <br/>
    输出Cookie的值：${ cookie.JSESSIONID.value } <br/>
    <hr>

    输出&lt;Context-param&gt;username的值：${ initParam.username } <br/>
    输出&lt;Context-param&gt;url的值：${ initParam.url } <br/>



</body>
</html>
