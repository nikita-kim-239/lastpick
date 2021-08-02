<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>Связки</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <script src="/js/friends.js"></script>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">

</head>
    <body onload="initializePage()">
        
        <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Создать связку</h4>
                         <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                    </div>
                    <div class="modal-body">
                         <p>Герой 1</p>

                        <select id="selectHero1" name="hero1">
                            <option disabled>Выберите героя</option>
                        </select>

                        <br/>
                        <p>Герой 2</p>

                        <select id="selectHero2" name="hero2">
                            <option disabled>Выберите героя</option>
                        </select>

                        <br/>
                    </div>
                    <div class="modal-footer" >
                        <button type="button" class="btn btn-primary" id="save">Save changes</button>
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
                <a href="victimship" class="navbar-brand" >Контрпики</a>
              </div>   
              
              <div class="col-md-3">    
                <a href="heroes" class="navbar-brand" >Герои</a>
              </div>  
              
              <div class="col-md-3">   
              <button class="navbar-toggler" type="button" data-toggle="modal" id="myBtn" data-target="#modal" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                Создать связку
              </button>
              </div>    
            </div>    
          </div>  
      </nav>  
        
        
        <div class="container">
            
            <br/>

            <table border="1" cellpadding="5" class="table table-primary" id="tableOfFriends">
                
                <tr>


                    <th>Герой 1</th>
                    <th>Герой 2</th>

                </tr>
                
            </table>

        
        </div>
        
        
            
        
        
    </body>
</html>
