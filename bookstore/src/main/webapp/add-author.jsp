<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>
<head>
    <c:if test="${up}"><title>Mettre à jour un auteur</title></c:if>
    <c:if test="${!up}"><title>Ajouter un auteur</title></c:if>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<c:if test="${up}">Mettre à jour un auteur</c:if>
<c:if test="${!up}">Rentrer les informations correspondant au nouvel auteur.</c:if>

<c:if test="${up}"><form method="POST" action="manage-author"></c:if>
<c:if test="${!up}"><form method="POST" action="author"></c:if>
<form method="POST" action="author">
    <table>
        <tr>
            <td>Nom : </td>
            <td> <input type="text" name="last" <c:if test="${up}"> value="${authorToUpdate.lastname}"</c:if>/> </td>
        </tr>
        <tr>
            <td>Prénom : </td>
            <td> <input type="text" name="first" <c:if test="${up}"> value="${authorToUpdate.firstname}"</c:if>/> </td>
        </tr>
        <tr>
            <td>Pseudonyme : </td>
            <td> <input type="text" name="pseudo"
                    <c:if test="${up}"> value="${authorToUpdate.pseudo}"</c:if>/> </td>
        </tr>
        <td> </td>
        <td>
            <c:if test="${up}"><input type="submit" value="Mettre à jour"/></c:if>
    <c:if test="${!up}"><input type="submit" value="Enregistrer"/></c:if>
             </td>
        </tr>
    </table>
</form>
</body>
</html>
