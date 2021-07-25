

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>Dota Pick</title>
     <link rel="stylesheet" href="../css/style.css">
    <script src="../js/index.js"></script>
        

</head>
<body onLoad="addHeroSelect()">
    <a href="friendship">Friendship</a>
    <br/>
    <a href="victimship">Victimship</a>
    <br/>
    <form action="index" method="post">
        <select id="selectEnemy1" name="enemy1">
          <option disabled>Выберите героя</option>
        </select>
        <select id="selectEnemy2" name="enemy2">
          <option disabled>Выберите героя</option>
        </select>
        <select id="selectEnemy3" name="enemy3">
          <option disabled>Выберите героя</option>
        </select>
       <select id="selectEnemy4" name="enemy4">
          <option disabled>Выберите героя</option>
        </select>
       <select id="selectEnemy5" name="enemy5">
          <option disabled>Выберите героя</option>
        </select>
      <br/>
      <p>Friends</p>
       <select id="selectAlly1" name="ally1">
           <option disabled>Выберите героя</option>
        </select>
       <select id="selectAlly2" name="ally2">
          <option disabled>Выберите героя</option>
        </select>
       <select id="selectAlly3" name="ally3">
          <option disabled>Выберите героя</option>    
        </select>
       <select id="selectAlly4" name="ally4">
          <option disabled>Выберите героя</option>
        </select>
      <br/>

      <input type="submit"     value="Get result"/>
    </form>
    <br/>
    <c:if test="${!empty results}">
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
    </c:if>  
</body>
</html>
