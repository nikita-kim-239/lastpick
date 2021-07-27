<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>Lastpick</title>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">  
    <script src="/js/index.js"></script>
    

</head>

    <body>
        
        <a href="createVictimship" class="btn btn-primary btn-md" role="button">Create Victimship</a>
        <br/>
        
        <table border="1" cellpadding="5" class="table table-primary caption-top" >
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
