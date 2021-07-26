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
    <body>
        
        <a href="createFriendship">Create</a>
        <br/>
        
        <table border="1" cellpadding="5">
            <caption><h2>List of Friendship</h2></caption>
            <tr>
   
                
                <th>Hero1</th>
                <th>Hero2</th>
                
            </tr>
            <c:forEach var="friendship" items="${friends}">
            <jsp:useBean id="friendship" class="kim.nikita.model.Friendship" scope="request"/>
                <tr>
                   
                    <td><c:out value="${friendship.hero1.name}"/></td>
                    <td><c:out value="${friendship.hero2.name}"/></td>
                </tr>
            </c:forEach>
        </table>

        
        
        
    </body>
</html>
