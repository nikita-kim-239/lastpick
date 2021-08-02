

$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#modal").modal('show');
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
        console.log(JSON.stringify(heroes));
        $.ajax({
            url:"http://localhost:8080/rest/friendship",
            type:"POST",
            data:JSON.stringify(heroes),
            contentType:'application/json',
            dataType:'json',     
            success: function( ){
              console.log('Success');
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
        
        
        
              
        $("#modal").modal('hide');
        
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
        
        
        

