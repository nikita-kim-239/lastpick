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

    <body onload="addFriendsHeroSelect()">
        
        <form action="createFriendship" method="post">
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

            <input type="submit"  onclick="createFriendship()" value="Create"/>
        </form>
        
    </body>
</html>
