<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019-02-21
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
</head>
<body>

<h3>Category name: <c:out value="${category.categoryName}"/></h3>
<p>Description: <c:out value="${category.description}"/></p>
<c:forEach items="${category.products}" var="p">
    <p>Products: <c:out value="${p.productName}"/></p>
</c:forEach>

</body>
</html>
