

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
                var el5=document.createElement("option");
                el5.text=hero;
                el5.value=i+1;
                var el6=document.createElement("option");
                el6.text=hero;
                el6.value=i+1;
                var el7=document.createElement("option");
                el7.text=hero;
                el7.value=i+1;
                var el8=document.createElement("option");
                el8.text=hero;
                el8.value=i+1;
                var el9=document.createElement("option");
                el9.text=hero;
                el9.value=i+1;
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


function addFriendsHeroSelect(){  
        
        
        var selectHero1=document.getElementById("selectHero1");
        var selectHero2=document.getElementById("selectHero2");
        
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
 
                selectHero1.append(el1);
                selectHero2.append(el2);
                              
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