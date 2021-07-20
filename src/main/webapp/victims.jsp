<%-- 
    Document   : victims
    Created on : 19.07.2021, 18:37:51
    Author     : Никита
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Victims</title>
        <style>
            table
            {
                margin:auto
            }
        </style>
    </head>
    <body>
        
        <a href="victimForm.jsp">Create</a>
        <br/>
        
        <table border="1" cellpadding="5" >
            <caption><h2>List of Victimship</h2></caption>
            <tr>
   
                
                <th>Predator</th>
                <th>Victim</th>
                
            </tr>
            <c:forEach var="victimship" items="${victims}">
            <jsp:useBean id="victimship" class="kim.nikita.model.Victimship" scope="request"/>
                <tr>
                   
                    <td><c:out value="${victimship.predator}"/></td>
                    <td><c:out value="${victimship.victim}"/></td>
                </tr>
            </c:forEach>
        </table>
        
        
    </body>
</html>
