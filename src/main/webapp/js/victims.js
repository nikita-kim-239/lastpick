const ajaxUrl="https://lastpick.herokuapp.com/rest/admin/victimship";
const heroesUrl="https://lastpick.herokuapp.com/rest/heroes";


$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#modal").modal('show');
    });
    
    $("#save").click(function(){
        
        var predatorid={id:$("#selectPredator").val()};
        var victimid={id:$("#selectVictim").val()};
        var heroes=[predatorid,victimid];
        
        $.ajax({
            url:ajaxUrl,
            type:"POST",
            data:JSON.stringify(heroes),
            contentType:'application/json',
            dataType:'json',  
           
            success: function(response ){
               
                updateTable(response);
                
                
                
              
            },
            error:function(jqXHR){
                
                
                alert(jqXHR.responseText);
                
            }
            
        });
        
        
        
            $("#modal").modal('hide');  
        
        
    });
});

function initializePage()
{
    addVictimHeroSelect();

    
}




function updateTable(response)
{
    
                var table=document.getElementById("tableOfVictims"); 
               
                $("#tableOfVictims tr").remove();
                
                var row   = table.insertRow(0);
                row.insertCell(0).outerHTML = "<th>Контрпик</th>";
                row.insertCell(1).outerHTML = "<th>Герой</th>";
                row.insertCell(2).outerHTML = "<th>Редактировать</th>";
                row.insertCell(3).outerHTML = "<th>Удалить</th>";
                
               for (var i=0;i<response.length;i++)
                {
      
                 row=table.insertRow(i+1);
                var cellName1 = row.insertCell(0);
                var hero1Name = document.createTextNode(response[i].predator.name);
                 cellName1.appendChild(hero1Name);
                var cellName2=row.insertCell(1);
                var hero2Name = document.createTextNode(response[i].victim.name);
                cellName2.appendChild(hero2Name);
                var editCell=row.insertCell(2);
                var editButton=document.createElement("button");
                editButton.setAttribute('class','btn btn-warning');
                
                editButton.setAttribute('onclick','victimshipUpdate('+String(response[i].id)+')');
                editButton.textContent='Редактировать';
                editCell.appendChild(editButton);
                var deleteCell=row.insertCell(3);
                var deleteButton=document.createElement("button");
                deleteButton.setAttribute('class','btn btn-danger');

                deleteButton.setAttribute('onclick','victimshipDelete('+String(response[i].id)+')');
                deleteButton.textContent='Удалить';
                deleteCell.appendChild(deleteButton);
                }
}

function addVictimHeroSelect(){  
        
        var selectPredator=document.getElementById("selectPredator");
        var selectVictim=document.getElementById("selectVictim");
        var editPredator=document.getElementById("editPredator");
        var editVictim=document.getElementById("editVictim");
    
        var xhr = new XMLHttpRequest();

        xhr.open("GET", heroesUrl, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        xhr.setRequestHeader(header, token);
        xhr.setRequestHeader('Accept', 'application/json, text/javascript');
        xhr.setRequestHeader('Access-Control-Allow-Headers', '*');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
               var heroes = JSON.parse(xhr.responseText);
            for (var i=0;i<heroes.length;i++)
            {   
                
                var hero=heroes[i].name;
                var el1=document.createElement("option");
                el1.text=hero;
                el1.value=heroes[i].id;
                var el2=document.createElement("option");
                el2.text=hero;
                el2.value=heroes[i].id;
                var el3=document.createElement("option");
                el3.text=hero;
                el3.value=heroes[i].id;
                var el4=document.createElement("option");
                el4.text=hero;
                el4.value=heroes[i].id;
                selectPredator.append(el1);
                selectVictim.append(el2);
                editPredator.append(el3);
                editVictim.append(el4);
                              
            }
        } 

        };
        
        xhr.send();
        
        
        
}
     
     
function victimshipUpdate(i)
{
    
    
    $("#modalToUpdate").modal('show');
    
    var index=Number(i);
    
    $("#edit").click(function(){
        
        
        var victimshipId={id:Number(index)};
        var hero1id={id:$("#editPredator").val()};
        var hero2id={id:$("#editVictim").val()};
        var hero1=document.getElementById("editPredator");
        var hero1children=hero1.childNodes;
        
       
        var hero1idNumber=Number($("#editPredator").val());
        var hero2idNumber=Number($("#editVictim").val());
        var hero1name=hero1children[hero1idNumber+2].text;
        var hero2name=hero1children[hero2idNumber+2].text;
       
        
        var victimship=[victimshipId,hero1id,hero2id];
        
        $.ajax({
            url:ajaxUrl,
            type:"PATCH",
            data:JSON.stringify(victimship),
            contentType:'application/json',
            dataType:'json',     
            success: function(response){
              
              
                        updateTable(response);
                       
                        
                        
              
            },
            error:function(jqXHR){
    
                alert(jqXHR.responseText);
                
            }
        });
        
        
        
              
        $("#modalToUpdate").modal('hide');
        
//        
        
        
        
    });
}     


function victimshipDelete(i)
{
    
    
    $("#modalToDelete").modal('show');
    var index=Number(i);
    
    $("#delete").click(function(){
    
        var victimshipId={id:Number(index)};
        $.ajax({
            url:ajaxUrl,
            type:"DELETE",
            data:JSON.stringify(victimshipId),
            contentType:'application/json',
            dataType:'json',     
            success: function(response){
              
                
                    updateTable(response);
                        
              
            },
            error:function(jqXHR){
         
                alert(jqXHR.responseText);
                
            }
        });
        
        
        
              
        $("#modalToDelete").modal('hide');
    });
}     

