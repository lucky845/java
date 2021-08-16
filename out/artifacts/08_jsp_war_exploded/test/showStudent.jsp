<%@ page import="com.jsp.pojo.Student" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: 12876
  Date: 2021/8/15
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border: 1px black solid;
            width: 600px;
            border-collapse: collapse;
        }

        td, th {
            border: 1px black solid;
        }
    </style>
</head>
<body>
<%-- jsp中输出一个表格，里面有10个学生信息 --%>
<%
    List<Student> studentList = (List<Student>) request.getAttribute("stuList");
%>

<table align="center">
    <h1 align="center">学生表</h1>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>电话</td>
        <td>操作</td>
    </tr>
    <% for (Student student : studentList) { %>
    <tr>
        <td><%= student.getId() %>
        </td>
        <td><%= student.getName() %>
        </td>
        <td><%= student.getAge() %>
        </td>
        <td><%= student.getPhone() %>
        </td>
        <td>删除、修改</td>
    </tr>
    <% } %>
</table>
</body>
</html>
