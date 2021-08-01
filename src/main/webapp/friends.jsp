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

    <script src="/js/friends.js"></script>
    

</head>
    <body onload="initializePage()">
        
        <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Create Friendship</h4>
                         <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                    </div>
                    <div class="modal-body">
                         <p>Hero1</p>

                        <select id="selectHero1" name="hero1">
                            <option disabled>Выберите героя</option>
                        </select>

                        <br/>
                        <p>Hero2</p>

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
        
        
        <button  class="btn btn-primary btn-md" type="button" data-toggle="modal" data-target="#modal" id="myBtn">Create Friendship</button>
        
        <div class="container">
            
            <br/>

            <table border="1" cellpadding="5" class="table table-primary" id="tableOfFriends">
                
                <tr>


                    <th>Hero1</th>
                    <th>Hero2</th>

                </tr>
                
            </table>

        
        </div>
        
        
            
        
        
    </body>
</html>
