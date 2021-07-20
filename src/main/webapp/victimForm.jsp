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
    </head>
    <body>
        <form action="victimship" method="post">
            <p>Predator</p>
            <input type="text" name="predator"  />
            <br/>
            <p>Victim</p>
            <input type="text" name="victim"  />
            <br/>

            <input type="submit"  value="Create"/>
        </form>
    </body>
</html>
