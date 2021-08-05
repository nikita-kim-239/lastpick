<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>Контрпики</title>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="/js/victims.js"></script>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">

</head>

<body onload="initializePage()">
    
    
    <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Создать контрпик</h4>
                         <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                    </div>
                    <div class="modal-body">
                         <p>Контрпик</p>

                        <select id="selectPredator" name="predator">
                            <option disabled>Выберите героя</option>
                        </select>

                        <br/>
                        <p>Герой</p>

                        <select id="selectVictim" name="victim">
                            <option disabled>Выберите героя</option>
                        </select>

                        <br/>
                    </div>
                    <div class="modal-footer" >
                        <button type="button" class="btn btn-primary" id="save">Сохранить изменения</button>
                    </div>
                    
                </div>
            </div>
        </div>
        
    
        <div class="modal fade" id="modalToUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Редактировать контрпик</h4>
                         <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                    </div>
                    <div class="modal-body">
                         <p>Контрпик</p>

                        <select id="editPredator" name="editPredator">
                            <option disabled>Выберите героя</option>
                        </select>

                        <br/>
                        <p>Герой</p>

                        <select id="editVictim" name="editVictim">
                            <option disabled>Выберите героя</option>
                        </select>

                        <br/>
                    </div>
                    <div class="modal-footer" >
                        <button type="button" class="btn btn-primary" id="edit">Сохранить изменения</button>
                    </div>
                    
                </div>
            </div>
        </div>
    
    
        <div class="modal fade" id="modalToDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Удалить контрпик</h4>
                         
                    </div>
                    <div class="modal-body">
                         <p>Вы уверены?</p>
                        <br/>
                    </div>
                    <div class="modal-footer" >
                        <button type="button" class="btn btn-danger" id="delete">Да</button>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            Нет
                         </button>
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
                <a href="heroes" class="navbar-brand" >Герои</a>
              </div>   
              
              
              
              <div class="col-md-3">   
              <button class="navbar-toggler" type="button" data-toggle="modal" id="myBtn" data-target="#modal" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                Создать контрпик
              </button>
              </div>    
            </div>    
          </div> 
      </nav>  
        
        
    
    
      <div class="container">  
        
        <br/>

            <table border="1" cellpadding="5" class="table table-primary" id="tableOfVictims">
                
                <tr>


                    <th>Контрпик</th>
                    <th>Герой</th>
                    <th>Редактировать</th>
                    <th>Удалить</th>

                </tr>
                
            </table>
      </div>   
        
    </body>
</html>
