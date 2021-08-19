<%@ page import="java.util.List" %>
<%@ page import="com.book.pojo.OrderItem" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>


    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
        h2 {
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">订单详情</span>
    <%--静态包含，登录 成功之后的菜单 --%>
    <%@ include file="/pages/common/login_success_menu.jsp" %>

</div>

<div id="main">
    <h2>订单编号：${requestScope.orderId} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户：${requestScope.username}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日期：${requestScope.createTime}</h2>
    <table>
        <tr>
            <td>图书名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>总价</td>
        </tr>
        <c:forEach items="${sessionScope.orderItems}" var="orderItem">
            <tr>
                <td>${orderItem.name}</td>
                <td>${orderItem.count}</td>
                <td>${orderItem.price}</td>
                <td>${orderItem.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>

    <h2 style="margin-top: 20px;">共消费：${requestScope.consumption} 元</h2>
</div>


<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>


</body>
</html>