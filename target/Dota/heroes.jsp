

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Герои</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="/js/heroes.js"></script>
        <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    </head>
    <body>
        
        <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Создать героя</h4>
                         <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                    </div>
                    <div class="modal-body">
                         <p>Имя героя</p>
                         <br/>
                         <input type="text" size="20" id="heroInput">
                         <br/>
                    </div>
                    <div class="modal-footer" >
                        <button type="button" class="btn btn-primary" id="save">Сохранить изменения</button>
                    </div>
                    
                </div>
            </div>
        </div>
        
        
        <nav class="navbar navbar-dark bg-primary">
          
           <div class="container">
            <div class="row">
            
               <div class="col-md-3"> 
                <a href="/" class="navbar-brand" >На главную</a>
               </div>
               
              <div class="col-md-3">    
                <a href="friendship" class="navbar-brand" >Связки</a>
              </div>   
                
              <div class="col-md-3">   
                <a href="victimship" class="navbar-brand" >Контрпики</a>
              </div>   

                
              <div class="col-md-3">   
              <button class="navbar-toggler" type="button" data-toggle="modal" id="myBtn" data-target="#modal" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                Создать героя
              </button>
              </div>    
            </div>    
           </div> 
      </nav>  
        
        
        
        
        <div class="container">
            
            <br/>

            <table border="1" cellpadding="5" class="table table-primary" id="tableOfHeroes">

                <thead>
                <tr>


                    <th>Герой</th>
                    <th>Редактировать</th>
                    <th>Удалить</th>
                </tr>
                </thead>
                <c:forEach items="${heroes}" var="hero">
                    <jsp:useBean id="hero" type="kim.nikita.model.Hero"/>
                    <tr>

                        <td><c:out value="${hero.name}"/></td>
                        <td><button onclick="heroUpdate(${hero.id})" class="btn btn-warning">Редактировать</button></td>
                        <td><button onclick="heroDelete(${hero.id})" class="btn btn-danger">Удалить</button></td>
                    </tr>
                </c:forEach>
                
            </table>

        
        </div>
        
        
        
    </body>
</html>
