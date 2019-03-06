<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oleksandrkh
  Date: 2019-02-18
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<h1>Login page!</h1>

<form action="<c:url value="/servlet/login"/>" method="post">

    <div class="container">
        <label for="login"><b>Username</b></label>
        <input id="login" type="text" placeholder="Enter Username" name="username" required>

        <label for="psw"><b>Password</b></label>
        <input id="psw" type="password" placeholder="Enter Password" name="password" required>

        <button type="submit">Login</button>
    </div>
</form>

<c:if test="${error != null}">
    <p style="color: red; margin-left: 105px">Username of Password is incorrect!</p>
</c:if>

</body>
</html>
