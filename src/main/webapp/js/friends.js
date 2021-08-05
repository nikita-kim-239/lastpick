

$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#modalToCreate").modal('show');
    });
    
    $("#save").click(function(){
        
        var hero1id={id:$("#selectHero1").val()};
        var hero2id={id:$("#selectHero2").val()};
        var hero1=document.getElementById("selectHero1");
        var hero1children=hero1.childNodes;
        
       
        var hero1idNumber=Number($("#selectHero1").val());
        var hero2idNumber=Number($("#selectHero2").val());
        var hero1name=hero1children[hero1idNumber+2].text;
        var hero2name=hero1children[hero2idNumber+2].text;
       
        
        var heroes=[hero1id,hero2id];
        
        $.ajax({
            url:"http://localhost:8080/rest/friendship",
            type:"POST",
            data:JSON.stringify(heroes),
            contentType:'application/json',
            dataType:'json',     
            success: function( ){
              
              var table=document.getElementById("tableOfFriends");
            
            var row=table.insertRow(1);
            var cellName1 = row.insertCell(0);
            var hero1Name = document.createTextNode(hero1name);
            cellName1.appendChild(hero1Name);
            var cellName2=row.insertCell(1);
            var hero2Name = document.createTextNode(hero2name);
            cellName2.appendChild(hero2Name);
              
            },
            error:function(jqXHR,exception){
                console.log(jqXHR);
                
                
                
                alert(jqXHR.responseText);
                
            }
        });
        
        
        
              
        $("#modalToCreate").modal('hide');
        
//        
        
        
        
    });
});

function initializePage()
{
    addFriendsHeroSelect();
    createFriendTable();
    
}

function createFriendTable(){
    
    
        
        var table=document.getElementById("tableOfFriends");
        
        
        var xhr = new XMLHttpRequest();
        var url = "http://localhost:8080/rest/friendship";
        xhr.open("GET", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
               var friendship = JSON.parse(xhr.responseText);
               
            for (var i=0;i<friendship.length;i++)
            {   
                
                        var row=table.insertRow(i+1);
                        var cellName1 = row.insertCell(0);
                        var hero1Name = document.createTextNode(friendship[i].hero1.name);
                        cellName1.appendChild(hero1Name);
                        var cellName2=row.insertCell(1);
                        var hero2Name = document.createTextNode(friendship[i].hero2.name);
                        cellName2.appendChild(hero2Name);
                        var editCell=row.insertCell(2);
                        var editButton=document.createElement("button");
                        editButton.setAttribute('class','btn btn-warning');
                        var index=Number(i)+1;
                        
                        editButton.setAttribute('onclick','friendshipUpdate('+index+')');
                        editButton.textContent='Редактировать';
                        editCell.appendChild(editButton);
                        var deleteCell=row.insertCell(3);
                        var deleteButton=document.createElement("button");
                        deleteButton.setAttribute('class','btn btn-danger');
                        
                        deleteButton.setAttribute('onclick','friendshipDelete('+index+')');
                        deleteButton.textContent='Удалить';
                        deleteCell.appendChild(deleteButton);
                
               
            }  
                
            }
        };
        xhr.send(); 
        
        
}

function addFriendsHeroSelect(){  
        
        var selectHero1=document.getElementById("selectHero1");
        var selectHero2=document.getElementById("selectHero2");
        var editHero1=document.getElementById("editHero1");
        var editHero2=document.getElementById("editHero2");
    
        var xhr = new XMLHttpRequest();
        var url = "http://localhost:8080/rest/heroes";
        xhr.open("GET", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
               var heroes = JSON.parse(xhr.responseText);
            for (var i=0;i<heroes.length;i++)
            {   
                
                var hero=heroes[i].name;
                var el1=document.createElement("option");
                el1.text=hero;
                el1.value=i+1;
                var el2=document.createElement("option");
                el2.text=hero;
                el2.value=i+1;              
                var el3=document.createElement("option");
                el3.text=hero;
                el3.value=i+1;
                var el4=document.createElement("option");
                el4.text=hero;
                el4.value=i+1;
                
                selectHero1.append(el1);
                selectHero2.append(el2);
                editHero1.append(el3);
                editHero2.append(el4);
                              
            }
        } 

        };
        
        xhr.send();
        
        
        
}
        
        
function friendshipUpdate(i)
{
    
    
    $("#modalToUpdate").modal('show');
    
    var index=Number(i);
    
    $("#edit").click(function(){
        
        
        var friendshipId={id:Number(index)};
        var hero1id={id:$("#editHero1").val()};
        var hero2id={id:$("#editHero2").val()};
        var hero1=document.getElementById("editHero1");
        var hero1children=hero1.childNodes;
        
       
        var hero1idNumber=Number($("#editHero1").val());
        var hero2idNumber=Number($("#editHero2").val());
        var hero1name=hero1children[hero1idNumber+2].text;
        var hero2name=hero1children[hero2idNumber+2].text;
       
        
        var friendship=[friendshipId,hero1id,hero2id];
        
        $.ajax({
            url:"http://localhost:8080/rest/friendship",
            type:"PATCH",
            data:JSON.stringify(friendship),
            contentType:'application/json',
            dataType:'json',     
            success: function(){
              
              var table=document.getElementById("tableOfFriends");
                        
                        var row=table.rows[index];
                        
                        
                        var cells=row.childNodes;
                        
                        var cellName1 = cells[0];
                        for (var node of cellName1.childNodes)
                            {
                                cellName1.removeChild(node);
                            }
                        var hero1Name = document.createTextNode(hero1name);
                        cellName1.appendChild(hero1Name);
                        
                        var cellName2 = cells[1];
                        for (var node of cellName2.childNodes)
                            {
                                cellName2.removeChild(node);
                            }
                        var hero2Name = document.createTextNode(hero2name);
                        cellName2.appendChild(hero2Name);
                        
                        
              
            },
            error:function(jqXHR,exception){
                
                
                
                
                alert(jqXHR.responseText);
                
            }
        });
        
        
        
              
        $("#modalToUpdate").modal('hide');
        
//        
        
        
        
    });
}


function friendshipDelete(i)
{
    $("#modalToDelete").modal('show');
    var index=Number(i);
    
    $("#delete").click(function(){
    
        var friendshipId={id:Number(index)};
        $.ajax({
            url:"http://localhost:8080/rest/friendship",
            type:"DELETE",
            data:JSON.stringify(friendshipId),
            contentType:'application/json',
            dataType:'json',     
            success: function(){
              
              var table=document.getElementById("tableOfFriends");
                       
              var tableBody=table.childNodes[1]; 
               
              var row=tableBody.rows[index];
              
              tableBody.removeChild(row);
                        
                        
              
            },
            error:function(jqXHR,exception){
                console.log(jqXHR);
                
                
                
                alert(jqXHR.responseText);
                
            }
        });
        
        
        
              
        $("#modalToDelete").modal('hide');
    });
    
    
}

