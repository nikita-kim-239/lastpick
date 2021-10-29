$(document).ready(function() {
    $("#myBtn").click(function () {
        $("#modal").modal('show');
    });


    $("#save").click(function () {

        const heroToBeCreatedName =document.getElementById("heroInput").value;
        const object={};
        object.name=heroToBeCreatedName;
        $.ajax({
            url: "http://localhost:8080/rest/heroes",
            type: "POST",
            data: JSON.stringify(object),
            contentType: 'application/json',
            dataType: 'json',
            success: function (response) {
                createHero(response);

            },
            error: function (jqXHR) {
                console.log(jqXHR);


                alert(jqXHR.responseText);

            }
        });
        $("#modalToCreate").modal('hide');
    });


});






function createHero(response)
{


    var position=response.positionInTable;
    var table=document.getElementById("tableOfHeroes");
    var row=table.insertRow(position+1);

    var cellName1=row.insertCell(0);
    var heroName = document.createTextNode(response.name);
    cellName1.appendChild(heroName);
    var editCell=row.insertCell(1);
    var editButton=document.createElement("button");
    editButton.setAttribute('class','btn btn-warning');

    editButton.setAttribute('onclick','friendshipUpdate('+String(response.id)+')');
    editButton.textContent='Редактировать';
    editCell.appendChild(editButton);
    var deleteCell=row.insertCell(2);
    var deleteButton=document.createElement("button");
    deleteButton.setAttribute('class','btn btn-danger');

    deleteButton.setAttribute('onclick','friendshipDelete('+String(response.id)+')');
    deleteButton.textContent='Удалить';
    deleteCell.appendChild(deleteButton);

}