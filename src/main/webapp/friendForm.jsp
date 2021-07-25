<%-- 
    Document   : friendForm
    Created on : 19.07.2021, 18:12:32
    Author     : Никита
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Friendship Form</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <script src="${pageContext.request.contextPath}/js/friend.js"></script>
    </head>
    <body onload="addHeroSelect()">
        
        <form action="friendship" method="post">
            <p>Hero1</p>
            
            <select id="selectHero1" name="hero1">
                <option disabled>Выберите героя</option>
            </select>
            
            <br/>
            <p>Hero2</p>
            
            <select id="selectHero2" name="hero2">
                <option disabled>Выберите героя</option>
            </select>
            
            <br/>

            <input type="submit"  value="Create"/>
        </form>
        
    </body>
</html>
