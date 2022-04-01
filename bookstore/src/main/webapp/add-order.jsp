<%--
    Document   : addBook
    Created on : 7 août 2012, 12:11:46
    Author     : ludiviine
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajouter une commande</title>
</head>
<body>
<h1>Ajouter votre commande
</h1>
<form method="POST" action="orders">
    <table>
        <tr>
            <td>Client : </td>
            <td>
                <select name="customer">
                    <c:forEach items="${customers}" var="c">
                        <option
                                value="${c.id}">
                            ${c.name}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Livres :
                <c:forEach items="${books}" var="b">
                    <input type="checkbox" name="book-${b.id}" />${b.title}<br/>
                </c:forEach>
            </td>
            <td></td>
        </tr>

            <td></td>
            <td>
                <input type="submit" value="Enregistrer"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
