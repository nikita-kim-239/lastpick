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
    </head>
    <body>
        
        <form action="friendship" method="post">
            <p>Hero1</p>
            <input type="text" name="hero1"  />
            <br/>
            <p>Hero2</p>
            <input type="text" name="hero2"  />
            <br/>

            <input type="submit"  value="Create"/>
        </form>
        
    </body>
</html>
