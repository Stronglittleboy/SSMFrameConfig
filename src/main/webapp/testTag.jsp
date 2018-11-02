<!DOCTYPE html>
<%@ page import="com.bean.Department" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/22
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mytage" uri="http://java.sun.com/jsp/my/firsttag" %>
<html>
<head>
    <title>简单标签的方法测试</title>
</head>
<body>
<H1>测试</H1>
<%
    Department d = new Department();
    d.setDepartname("世界和平部");
    pageContext.setAttribute("bu",d);
%>
<mytage:testtag bate="${1<2}" department="${bu}">龙珠</mytage:testtag>
</body>
</html>
