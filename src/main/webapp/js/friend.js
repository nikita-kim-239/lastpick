function addHeroSelect(){  
        
        var request = new XMLHttpRequest();
        
        request.open("GET", "http://localhost:8080/rest/heroes", false);
        	
        request.send();
        
        
        var heroes=JSON.parse(request.responseText);
        
        
        var selectHero1=document.getElementById("selectHero1");
        var selectHero2=document.getElementById("selectHero2");
        
        for (var i=0;i<heroes.length;i++)
            {
                var hero=heroes[i];
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
