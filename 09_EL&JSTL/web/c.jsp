<%@ page import="com.EL.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 12876
  Date: 2021/8/15
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("我好帅!");
        person.setPhones(new String[]{"161616161651","45151511516"});

        List<String> cities = new ArrayList<String>();
        cities.add("北京");
        cities.add("上海");
        cities.add("深圳");
        cities.add("武汉");
        person.setCities(cities);

        Map<String,Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        person.setMap(map);

        pageContext.setAttribute("person", person);
    %>

    输出Person：${ person } <br/>
    输出Person的name属性${ person.name } <br/>
    输出Person的phones数组属性${ person.phones[0] } <br/>
    输出Person的cities集合${ person.cities } <br/>
    输出Person的cities集合的元素值${ person.cities[3] } <br/>
    输出Person的Map集合${ person.map } <br/>
    输出Person的Map集合的元素值${ person.map.key1 } <br/>
    输出Person的age值${ person.age } <br/> <%-- 直接找get方法 -->
</body>
</html>
