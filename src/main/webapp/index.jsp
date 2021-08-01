<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>Lastpick</title>
    
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <script type="text/javascript" src="/js/index.js"></script>
    

</head>


<body onload="addIndexHeroSelect()">
    <div class="container">
        
        
        <br/>
        <a href="friendship" class="btn btn-primary btn-md" role="button">Friendship</a>
        <br/>
        <a href="victimship" class="btn btn-primary btn-md" role="button">Victimship</a>
        <br/>

            <p>Enemies</p>
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
          
          <button type="button" onclick="createTable()"  class="btn btn-info btn-md">Get results</button>   
          
          <br/>
          
   </div>
    <div class="row" id="output"></div>
</body>
</html>
