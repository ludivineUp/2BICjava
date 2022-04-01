<%-- 
    Document   : menu
    Created on : 7 août 2012, 11:10:37
    Author     : ludiviine
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table>
    <tr>
        <td><a href="<%= request.getContextPath()%>/index.jsp">Accueil</a></td>
        <td><a href="<%= request.getContextPath()%>/author">Liste des auteurs</a></td>
        <td><a href="<%= request.getContextPath()%>/add-author.html">Ajouter un auteur</a></td>
        <td><a href="<%= request.getContextPath()%>/books">Liste des livres</a></td>
        <td><a href="<%= request.getContextPath()%>/add-book.jsp">Ajouter un livre</a></td>
        <td><a href="<%= request.getContextPath()%>/customers">Liste des clients</a></td>
        <td><a href="<%= request.getContextPath()%>/add-customer.jsp">Ajouter un client</a></td>
    </tr>
</table>
