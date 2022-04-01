<%--
  Created by IntelliJ IDEA.
  User: ludivine
  Date: 31/03/2022
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un nouveau client</title>
</head>
<body>
Rentrer les informations correspondant au nouvel client.
<form method="POST" action="cutomers">
    <table>
        <tr>
            <td>Nom : </td>
            <td> <input type="text" name="name"/> </td>
        </tr>
        <tr>
            <td>Ville : </td>
            <td>
                <select name="author">
                    <c:forEach items="${cities}" var="c">
                        <option value="${c.id}">
                                ${c.name}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Langue : </td>
            <td>
                <select name="author">
                    <c:forEach items="${languages}" var="l">
                        <option value="${l}">
                                ${l}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <td> </td>
        <td> <input type="submit" value="Enregistrer"/> </td>
        </tr>
    </table>
</form>
</body>
</html>
