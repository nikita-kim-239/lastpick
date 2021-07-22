<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Results</title>
    <style>
            
            table
            {
                margin:auto
            }
        </style>
</head>
<body>
    
    
        
        
    
   
    
    
    <table border="1" cellpadding="5">
        
            
            <caption><h2>List of Results</h2></caption>
            <tr>
   
                <th>Name</th>
                <th>Score</th>
                
            </tr>
            <c:forEach var="result" items="${results}">
            <jsp:useBean id="result" class="kim.nikita.model.Result" scope="request"/>
                <tr>
                   
                    <td><c:out value="${result.name}"/></td>
                    <td><c:out value="${result.score}"/></td>
                    
                </tr>
            </c:forEach>
        </table>


</body>
</html>
