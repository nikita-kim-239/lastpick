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
            contentType: "application/json",
            success: function( ){
              console.log('Success');
              
            }   
        }).done(function(){
            var table=document.getElementById("tableOfVictims");
            
            var row=table.insertRow(1);
            var cellName1 = row.insertCell(0);
            var hero1Name = document.createTextNode(predatorname);
            cellName1.appendChild(hero1Name);
            var cellName2=row.insertCell(1);
            var hero2Name = document.createTextNode(victimname);
            cellName2.appendChild(hero2Name);
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
                
               
            }  
                
            }
        };
        xhr.send(); 
        
        
}

function addVictimHeroSelect(){  
        
        var selectPredator=document.getElementById("selectPredator");
        var selectVictim=document.getElementById("selectVictim");
    
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
                selectPredator.append(el1);
                selectVictim.append(el2);
                              
            }
        } 

        };
        
        xhr.send();
        
        
        
}
     
