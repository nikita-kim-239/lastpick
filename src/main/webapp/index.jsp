<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>Lastpick</title>
    
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">

</head>


<body onload="addIndexHeroSelect()">
    
      <nav class="navbar navbar-dark bg-primary">
          
          <div class="container">
            <div class="row">
            
               <div class="col-md-4"> 
                <a href="friendship" class="navbar-brand" >Связки</a>
               </div>
               
              <div class="col-md-4">   
                <a href="victimship" class="navbar-brand" >Контрпики</a>
              </div>   
              
              <div class="col-md-4">    
                <a href="heroes" class="navbar-brand" >Герои</a>
              </div>   
            </div>    
          </div> 
      </nav>  
       
    
    <div class="container">
                <h4>Враги</h4>
           
                <select id="selectEnemy1" name="enemy1">
                  <option disabled>Выберите героя</option>
                  <option value="0">Нет героя</option>
                </select>
            
                <select id="selectEnemy2" name="enemy2">
                  <option disabled>Выберите героя</option>
                  <option value="0">Нет героя</option>
                </select>
           
                <select id="selectEnemy3" name="enemy3">
                  <option disabled>Выберите героя</option>
                  <option value="0">Нет героя</option>
                </select>
            
                <select id="selectEnemy4" name="enemy4">
                  <option disabled>Выберите героя</option>
                  <option value="0">Нет героя</option>
                </select>
            
                <select id="selectEnemy5" name="enemy5">
                  <option disabled>Выберите героя</option>
                  <option value="0">Нет героя</option>
                </select>
            
            <br/>
            
                <h4>Союзники</h4>
            
            
                <select id="selectAlly1" name="ally1">
                   <option disabled>Выберите героя</option>
                   <option value="0">Нет героя</option>
                </select>
               
             
                 <select id="selectAlly2" name="ally2">
                   <option disabled>Выберите героя</option>
                   <option value="0">Нет героя</option>
                 </select>
            
                
                <select id="selectAlly3" name="ally3">
                  <option disabled>Выберите героя</option>  
                  <option value="0">Нет героя</option>
                </select>
            
            
                <select id="selectAlly4" name="ally4">
                  <option disabled>Выберите героя</option>
                  <option value="0">Нет героя</option>
                </select>
             
  
                <button type="button" onclick="createTable()"  class="btn btn-primary btn-md">Получить результаты</button>   
             
            <br/>
          
          
   </div>
    <div class="row" id="output"></div>
</body>
</html>
