<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>Lastpick</title>
     <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
      
    <script src="/js/index.js"></script>
    

</head>
    <body onload="addVictimHeroSelect()">
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
