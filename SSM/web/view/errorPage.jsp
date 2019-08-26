<%--
  Created by IntelliJ IDEA.
  User: WDW
  Date: 2019/8/25
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>errorPage</title>
</head>
<body>
    <h1 align="center" style="color: red" >error page</h1>

    <p align="center" style="color: red">
        ${requestScope.exceptionMessage}
    </p>
</body>
</html>
