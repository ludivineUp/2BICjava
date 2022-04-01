<%-- 
    Document   : listEditors
    Created on : 7 août 2012, 09:30:06
    Author     : ludiviine
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des livres</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h1>Liste des livres</h1>
        <table>
            <tr>
                <td>ISBN</td>
                <td>Titre</td>
                <td>Auteur</td>
                <td>Date de parution</td>
                <td>Age Conseillé</td>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td><c:if test="${!empty book.author.pseudo}" >
                            ${book.author.pseudo}
                        </c:if>
                        <c:if test="${empty book.author.pseudo}" >
                            ${book.author.firstname} ${book.author.lastname}
                        </c:if></td>
                    <td>${book.parutionYear}</td>
                    <td>
                        <c:set var="classObject" value="${book.getClass().toString()}"/>
                       <c:if test="${classObject == 'class com.nfs.bookstore.entities.KidBook'}">${book.age}</c:if>
                        <c:if test="${classObject == 'class com.nfs.bookstore.entities.Book'}">Adultes</c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>