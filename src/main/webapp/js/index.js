const simpleUrl="http://lastpick.herokuapp.com/rest/";



function addIndexHeroSelect(){  
        
    
    
        var selectEnemy1=document.getElementById("selectEnemy1");
        var selectEnemy2=document.getElementById("selectEnemy2");
        var selectEnemy3=document.getElementById("selectEnemy3");
        var selectEnemy4=document.getElementById("selectEnemy4");
        var selectEnemy5=document.getElementById("selectEnemy5");
        var selectAlly1=document.getElementById("selectAlly1");
        var selectAlly2=document.getElementById("selectAlly2");
        var selectAlly3=document.getElementById("selectAlly3");
        var selectAlly4=document.getElementById("selectAlly4");
        
       
        var xhr = new XMLHttpRequest();

        xhr.open("GET", simpleUrl+"heroes", true);
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        xhr.setRequestHeader(header, token);
        xhr.setRequestHeader("Content-Type", "application/json");
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
                var el5=document.createElement("option");
                el5.text=hero;
                el5.value=heroes[i].id;
                var el6=document.createElement("option");
                el6.text=hero;
                el6.value=heroes[i].id;
                var el7=document.createElement("option");
                el7.text=hero;
                el7.value=heroes[i].id;
                var el8=document.createElement("option");
                el8.text=hero;
                el8.value=heroes[i].id;
                var el9=document.createElement("option");
                el9.text=hero;
                el9.value=heroes[i].id;
                selectEnemy1.append(el1);
                selectEnemy2.append(el2);
                selectEnemy3.append(el3);
                selectEnemy4.append(el4);
                selectEnemy5.append(el5);
                selectAlly1.append(el6);
                selectAlly2.append(el7);
                selectAlly3.append(el8);
                selectAlly4.append(el9);
               
            }  
                
            }
        };
        xhr.send();     
      }     












function createTable() {
    
        var selectEnemy1=document.getElementById("selectEnemy1");
        var selectEnemy2=document.getElementById("selectEnemy2");
        var selectEnemy3=document.getElementById("selectEnemy3");
        var selectEnemy4=document.getElementById("selectEnemy4");
        var selectEnemy5=document.getElementById("selectEnemy5");
        var selectAlly1=document.getElementById("selectAlly1");
        var selectAlly2=document.getElementById("selectAlly2");
        var selectAlly3=document.getElementById("selectAlly3");
        var selectAlly4=document.getElementById("selectAlly4");
        var enemy1Id=selectEnemy1.value;
        var enemy2Id=selectEnemy2.value;
        var enemy3Id=selectEnemy3.value;
        var enemy4Id=selectEnemy4.value;
        var enemy5Id=selectEnemy5.value;
        var ally1Id=selectAlly1.value;
        var ally2Id=selectAlly2.value;
        var ally3Id=selectAlly3.value;
        var ally4Id=selectAlly4.value;

        

    var url = simpleUrl+"results?";
    url+="enemy1="+enemy1Id+"&";
    url+="enemy2="+enemy2Id+"&";
    url+="enemy3="+enemy3Id+"&";
    url+="enemy4="+enemy4Id+"&";
    url+="enemy5="+enemy5Id+"&";
    url+="ally1="+ally1Id+"&";
    url+="ally2="+ally2Id+"&";
    url+="ally3="+ally3Id+"&";
    url+="ally4="+ally4Id;
         
          $.ajax({
            url:url,
            type:"GET",

              contentType: "application/json",
              dataType:"json",



            success: function( ){
              console.log('Success');
              
            }
        }).done(function(data){
         

               var result=data;
               
               var desirableHeroes=result.filter(hero=>hero.score>0);
               
               var undesirableHeroes=result.filter(hero=>hero.score<0);
               
               var output=document.getElementById("output");
               
               
               
              while (output.firstChild) {
                    output.removeChild(output.firstChild);
                  }
               
                
               var divOfDesirableHeroes = document.createElement('div');
               divOfDesirableHeroes.setAttribute('class','col-md-6');
               var tableOfDesirableHeroes = document.createElement('table');
              tableOfDesirableHeroes.setAttribute('class','table');

                for (var i=0;i<desirableHeroes.length;i++)
                    {
                        var row=tableOfDesirableHeroes.insertRow(i);
                        row.setAttribute('class','bg-success');
                        var cellName = row.insertCell(0);
                        var textName = document.createTextNode(desirableHeroes[i].name);
                        cellName.appendChild(textName);
                        var cellScore=row.insertCell(1);
                        var textScore = document.createTextNode(desirableHeroes[i].score);
                        cellScore.appendChild(textScore);
                        
                    }
              
            
            divOfDesirableHeroes.appendChild(tableOfDesirableHeroes);
            output.appendChild(divOfDesirableHeroes);
            
            
            
            
            
            var divOfUndesirableHeroes = document.createElement('div');
               divOfUndesirableHeroes.setAttribute('class','col-md-6');
            var tableOfUndesirableHeroes = document.createElement('table');
              tableOfUndesirableHeroes.setAttribute('class','table');

                for (var i=0;i<undesirableHeroes.length;i++)
                    {
                        var row=tableOfUndesirableHeroes.insertRow(i);
                        row.setAttribute('class','bg-danger');
                        var cellName = row.insertCell(0);
                        var textName = document.createTextNode(undesirableHeroes[i].name);
                        cellName.appendChild(textName);
                        var cellScore=row.insertCell(1);
                        var textScore = document.createTextNode(undesirableHeroes[i].score);
                        cellScore.appendChild(textScore);
                        
                    }
            divOfUndesirableHeroes.appendChild(tableOfUndesirableHeroes);  
            output.appendChild(divOfUndesirableHeroes); 
            
        }).fail(function(jqXHR){
            
            
            
            alert(jqXHR.responseText);

        });
        
        
        
}