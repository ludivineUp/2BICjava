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
        <title>Liste des auteurs</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h1>Liste des auteurs</h1>
         <table>
             <tr>
                 <th>Nom</th>
                 <th> Prénom</th>
                 <th>Pseudonyme</th>
             </tr>
             <c:forEach items="${authors}" var="author">
                 <tr>
                     <td>
                         <c:if test="${!empty author.lastname}">${author.lastname}</c:if>
                     </td>
                     <td>
                         <c:if test="${!empty author.firstname}">${author.firstname}</c:if>
                     </td>
                     <td>
                         <c:if test="${!empty author.pseudo}">${author.pseudo}</c:if>
                     </td>
                 </tr>
             </c:forEach>
             </table>
    </body>
</html>
