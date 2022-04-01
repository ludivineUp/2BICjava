<%--
    Document   : listAuthors
    Created on : 7 août 2012, 18:37:16
    Author     : ludiviine
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Liste des commandes</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<h1>Liste des commandes</h1>
<table>
  <tr>
    <th>Num</th>
    <th> Client</th>
    <th> Date </th>
    <th>Livres</th>
  </tr>
  <c:forEach items="${orders}" var="order">
    <tr>
      <td>
        ${order.id}
      </td>
      <td>
          ${order.customer.name}
      </td>
      <td>
          ${order.dayAsString}
      </td>
      <td>
        <c:forEach items="${order.books}" var="book">
          ${book.title} <br/>
        </c:forEach>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
