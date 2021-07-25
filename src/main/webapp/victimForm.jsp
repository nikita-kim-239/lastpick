<%-- 
    Document   : victimForm
    Created on : 19.07.2021, 18:40:31
    Author     : Никита
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Victimship Form</title>
        <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
        <script src="/js/victim.js"></script>
        
        
        
        
    </head>
    <body onload="addHeroSelect()">
        <form action="createVictimship" method="post">
            <p>Predator</p>
            
            <select id="selectPredator" name="predator">
                <option disabled>Выберите героя</option>
            </select>
         
            <br/>
            <p>Victim</p>
            
            <select id="selectVictim" name="victim">
                <option disabled>Выберите героя</option>
            </select>
            
            <br/>

            <input type="submit"  value="Create"/>
        </form>
    </body>
</html>
