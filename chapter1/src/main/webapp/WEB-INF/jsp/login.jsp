<%--
  Created by IntelliJ IDEA.
  User: cwtec
  Date: 2016/2/17
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>网站登录</title>
</head>
<body>
    <c:if test="${!empty error}">
        <font color="red">
         <c:out value="${error}"/>
        </font>
    </c:if>
    <form action="<c:url value="/ /admin/ /loginCheck.html"/>" method="post">
        用户名：
        <input type="text" name="userName">
        <br>
        密码：
        <input type="password" name="password">
        <br>
        <input type="submit" value="登陆">
        <input type="reset" value="重置">
    </form>
</body>
</html>
