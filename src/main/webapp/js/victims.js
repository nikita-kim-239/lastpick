$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#modal").modal('show');
    });
    
    $("#save").click(function(){
        
        var predatorid={id:$("#selectPredator").val()};
        var victimid={id:$("#selectVictim").val()};
        
        var hero1=document.getElementById("selectPredator");
        var hero1children=hero1.childNodes;
       
        var predatoridNumber=Number($("#selectPredator").val());
        var victimidNumber=Number($("#selectVictim").val());
        var predatorname=hero1children[predatoridNumber+2].text;
        var victimname=hero1children[victimidNumber+2].text;
       
        
        var heroes=[predatorid,victimid];
        
        $.ajax({
            url:"http://localhost:8080/rest/victimship",
            type:"POST",
            data:JSON.stringify(heroes),
            contentType:'application/json',
            dataType:'json',  
           
            success: function( ){
                var table=document.getElementById("tableOfVictims");
            
                var row=table.insertRow(1);
                var cellName1 = row.insertCell(0);
                var hero1Name = document.createTextNode(predatorname);
                 cellName1.appendChild(hero1Name);
                var cellName2=row.insertCell(1);
                var hero2Name = document.createTextNode(victimname);
                cellName2.appendChild(hero2Name);
              
            },
            error:function(jqXHR,exception){
                
                
                alert(jqXHR.responseText);
                
            }
            
        });
        
        
        
            $("#modal").modal('hide');  
        
        
    });
});

function initializePage()
{
    addVictimHeroSelect();
    createVictimTable();
    
}

function createVictimTable(){
    
    
        
        var table=document.getElementById("tableOfVictims");
        
        var xhr = new XMLHttpRequest();
        var url = "http://localhost:8080/rest/victimship";
        xhr.open("GET", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
               var victimship = JSON.parse(xhr.responseText);
               
            for (var i=0;i<victimship.length;i++)
            {   
                
                        var row=table.insertRow(i+1);
                        var cellName1 = row.insertCell(0);
                        var predatorName = document.createTextNode(victimship[i].predator.name);
                        cellName1.appendChild(predatorName);
                        var cellName2=row.insertCell(1);
                        var victimName = document.createTextNode(victimship[i].victim.name);
                        cellName2.appendChild(victimName);
                        var editButton=document.createElement("button");
                        editButton.setAttribute('class','btn btn-warning');
                        var index=Number(i)+1;
                        var editCell=row.insertCell(2);
                        editButton.setAttribute('onclick','victimshipUpdate('+index+')');
                        editButton.textContent='Редактировать';
                        editCell.appendChild(editButton);
                        var deleteCell=row.insertCell(3);
                        var deleteButton=document.createElement("button");
                        deleteButton.setAttribute('class','btn btn-danger');
                        
                        deleteButton.setAttribute('onclick','victimshipDelete('+index+')');
                        deleteButton.textContent='Удалить';
                        deleteCell.appendChild(deleteButton);
                
               
            }  
                
            }
        };
        xhr.send(); 
        
        
}

function addVictimHeroSelect(){  
        
        var selectPredator=document.getElementById("selectPredator");
        var selectVictim=document.getElementById("selectVictim");
        var editPredator=document.getElementById("editPredator");
        var editVictim=document.getElementById("editVictim");
    
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
            url:"http://localhost:8080/rest/victimship",
            type:"PATCH",
            data:JSON.stringify(victimship),
            contentType:'application/json',
            dataType:'json',     
            success: function(){
              
              var table=document.getElementById("tableOfVictims");
                        
                        var row=table.rows[index];
                        console.log(row);
                        
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


function victimshipDelete(i)
{
    
    
    $("#modalToDelete").modal('show');
    var index=Number(i);
    
    $("#delete").click(function(){
    
        var victimshipId={id:Number(index)};
        $.ajax({
            url:"http://localhost:8080/rest/victimship",
            type:"DELETE",
            data:JSON.stringify(victimshipId),
            contentType:'application/json',
            dataType:'json',     
            success: function(){
              
              var table=document.getElementById("tableOfVictims");
                       
              var tableBody=table.childNodes[1]; 
               
              var row=tableBody.rows[index];
              
              tableBody.removeChild(row);
                        
                        
              
            },
            error:function(jqXHR,exception){
         
                alert(jqXHR.responseText);
                
            }
        });
        
        
        
              
        $("#modalToDelete").modal('hide');
    });
}     

