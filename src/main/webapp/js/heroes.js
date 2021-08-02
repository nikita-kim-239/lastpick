$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#modal").modal('show');
    });
    
});

function initializePage()
{
    
    createTableOfHeroes();
    
}


function createTableOfHeroes()
{
        var table=document.getElementById("tableOfHeroes");
        
        
        var xhr = new XMLHttpRequest();
        var url = "http://localhost:8080/rest/heroes";
        xhr.open("GET", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
               var heroes = JSON.parse(xhr.responseText);
               
            for (var i=0;i<heroes.length;i++)
            {   
                
                        var row=table.insertRow(i+1);
                        var cellName1 = row.insertCell(0);
                        var heroId = document.createTextNode(heroes[i].id);
                        cellName1.appendChild(heroId);
                        var cellName2=row.insertCell(1);
                        var heroName = document.createTextNode(heroes[i].name);
                        cellName2.appendChild(heroName);
                
               
            }  
                
            }
        };
        xhr.send(); 
        
}