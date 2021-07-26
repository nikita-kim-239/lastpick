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
        
        <a href="createVictimship">Create</a>
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
                   
                    <td><c:out value="${victimship.predator.name}"/></td>
                    <td><c:out value="${victimship.victim.name}"/></td>
                </tr>
            </c:forEach>
        </table>
        
        
    </body>
</html>
