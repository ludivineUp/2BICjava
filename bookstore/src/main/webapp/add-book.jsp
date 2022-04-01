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
        <title>Ajouter un livre</title>
    </head>
    <body>
        <h1>Ajouter votre livre
        </h1>
                <form method="POST" action="books">
            <table>
                <tr>
                    <td>ISBN : </td>
                    <td><input type="text" name="isbn" value="${book.isbn}"/></td>
                </tr>
                <tr>
                    <td>Titre : </td>
                    <td><input type="text" name="title"  value="${book.title}"/></td>
                </tr>
                <tr>
                    <td>Auteur : </td>
                    <td>
                        <select name="author">
                            <c:forEach items="${authors}" var="author">
                                <option 
                                    <c:if test="${book.author.id} == ${author.id}">
                                         selected
                                    </c:if>
                                    value="${author.id}"> 
                                    
                                    <c:if test="${empty author.pseudo}" >
                                        ${author.firstname} ${author.lastname}
                                    </c:if>
                                    <c:if test="${!empty author.pseudo}" >
                                        ${author.pseudo}
                                    </c:if>
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Année de parution : </td>
                    <td><input type="text" name="parution"  value="${book.parutionDate}"/></td>
                </tr>
                <tr>
                    <td>Checker la case si livre pour enfant et donner l'âge conseillé </td>
                    <td><input type="checkbox" name="kid" />
                        Livre pour enfant
                    Age <input type="text" id="age" name="age"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
               <input type="submit" value="Enregistrer"/>
               </td>
                </tr>
            </table>
        </form>
    </body>
</html>
