<%--
  Created by IntelliJ IDEA.
  User: ludivine
  Date: 31/03/2022
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des clients</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<h1>Liste des clients</h1>
<table>
    <tr>
        <td>ID</td>
        <td>Nom</td>
        <td>Ville</td>
    </tr>
    <c:forEach items="${customers}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.city.name}</td>
            <td>${c.language}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
