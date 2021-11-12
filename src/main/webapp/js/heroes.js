const adminUrl="https://lastpick.herokuapp.com/rest/admin/heroes";


$(document).ready(function() {


    $(function () {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        $(document).ajaxSend(function(e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });

    $("#myBtn").click(function () {
        $("#modal").modal('show');
    });


    $("#save").click(function () {

        const heroToBeCreatedName =document.getElementById("heroInput").value;
        const object={};
        object.name=heroToBeCreatedName;
        $.ajax({
            url: adminUrl,
            type: "POST",
            data: JSON.stringify(object),
            contentType: 'application/json',
            dataType: 'json',
            success: function (response) {
                updateTable(response);

            },
            error: function (jqXHR) {
                console.log(jqXHR);


                alert(jqXHR.responseText);

            }
        });
        $("#modal").modal('hide');
    });


});








function heroUpdate (id)
{


    $("#modalToUpdate").modal('show');
    $("#edit").click(function () {

        const heroToBeUpdatedName =document.getElementById("heroInput2").value;
        const object={};
        object.name=heroToBeUpdatedName;
        object.id=Number(id);;
        $.ajax({
            url: adminUrl,
            type: "PATCH",
            data: JSON.stringify(object),
            contentType: 'application/json',
            dataType: 'json',
            success: function (response) {
                updateTable(response);

            },
            error: function (jqXHR) {
                console.log(jqXHR);


                alert(jqXHR.responseText);

            }
        });
        $("#modalToUpdate").modal('hide');
    });
}

function heroDelete (id)
{

    $("#modalToDelete").modal('show');


    $("#delete").click(function(){

        var object={id:Number(id)};
        $.ajax({
            url:adminUrl,
            type:"DELETE",
            data:JSON.stringify(object),
            contentType:'application/json',
            dataType:'json',
            success: function(response){
                updateTable(response);
            },
            error:function(jqXHR){
                console.log(jqXHR);
                alert(jqXHR.responseText);

            }
        });
        $("#modalToDelete").modal('hide');
    });

}

function updateTable(response)
{

    var table=document.getElementById("tableOfHeroes");

    $("#tableOfHeroes tr").remove();

    var row   = table.insertRow(0);
    row.insertCell(0).outerHTML = "<th>Герой</th>";
    row.insertCell(1).outerHTML = "<th>Редактировать</th>";
    row.insertCell(2).outerHTML = "<th>Удалить</th>";


    for (var i=0;i<response.length;i++)
    {

        row=table.insertRow(i+1);
        var cellName1 = row.insertCell(0);
        var heroName = document.createTextNode(response[i].name);
        cellName1.appendChild(heroName);
        var editCell=row.insertCell(1);
        var editButton=document.createElement("button");
        editButton.setAttribute('class','btn btn-warning');

        editButton.setAttribute('onclick','heroUpdate('+String(response[i].id)+')');
        editButton.textContent='Редактировать';
        editCell.appendChild(editButton);
        var deleteCell=row.insertCell(2);
        var deleteButton=document.createElement("button");
        deleteButton.setAttribute('class','btn btn-danger');

        deleteButton.setAttribute('onclick','heroDelete('+String(response[i].id)+')');
        deleteButton.textContent='Удалить';
        deleteCell.appendChild(deleteButton);
    }
}