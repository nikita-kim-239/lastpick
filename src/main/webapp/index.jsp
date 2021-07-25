

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>Dota Pick</title>
     <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <script src="/js/index.js"></script>
        

</head>
<body onLoad="addHeroSelect()">
    <a href="friendship">Friendship</a>
    <br/>
    <a href="victimship">Victimship</a>
    <br/>
    <form action="results" method="post">
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
      <br/>

      <input type="submit"     value="Get result"/>
    </form>
    
</body>
</html>
