//const ajaxUrl = "https://lastpick.herokuapp.com/rest/admin/friendship";
//const heroesUrl = "https://lastpick.herokuapp.com/rest/heroes";
const ajaxUrl = "http://localhost:8080/rest/admin/friendship";
const heroesUrl = "http://localhost:8080/rest/heroes";
$(document).ready(function () {

    $(function () {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });

    $("#myBtn").click(function () {
        $("#modalToCreate").modal('show');
    });

    $("#save").click(function () {

        var hero1id = {id: $("#selectHero1").val()};
        var hero2id = {id: $("#selectHero2").val()};

        var heroes = [hero1id, hero2id];

        $.ajax({
            url: ajaxUrl,
            type: "POST",
            data: JSON.stringify(heroes),
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

        $("#modalToCreate").modal('hide');

    });
});


function initializePage() {
    addFriendsHeroSelect();


}


function updateTable(response) {


    let table = document.getElementById("tableOfFriends");

    $("#tableOfFriends tr").remove();

    let row = table.insertRow(0);
    row.insertCell(0).outerHTML = "<th>Герой 1</th>";
    row.insertCell(1).outerHTML = "<th>Герой 2</th>";
    row.insertCell(2).outerHTML = "<th>Редактировать</th>";
    row.insertCell(3).outerHTML = "<th>Удалить</th>";


    for (let i = 0; i < response.length; i++) {
        row = table.insertRow(i + 1);
        if (response[i].friends)
            row.setAttribute('class', 'table-success');
        else
            row.setAttribute('class', 'table-danger');
        var cellName1 = row.insertCell(0);
        var hero1Name = document.createTextNode(response[i].hero1.name);
        cellName1.appendChild(hero1Name);
        var cellName2 = row.insertCell(1);
        var hero2Name = document.createTextNode(response[i].hero2.name);
        cellName2.appendChild(hero2Name);
        var editCell = row.insertCell(2);
        var editButton = document.createElement("button");
        editButton.setAttribute('class', 'btn btn-warning');

        editButton.setAttribute('onclick', 'friendshipUpdate(' + String(response[i].id) + ')');
        editButton.textContent = 'Редактировать';
        editCell.appendChild(editButton);
        var deleteCell = row.insertCell(3);
        var deleteButton = document.createElement("button");
        deleteButton.setAttribute('class', 'btn btn-danger');

        deleteButton.setAttribute('onclick', 'friendshipDelete(' + String(response[i].id) + ')');
        deleteButton.textContent = 'Удалить';
        deleteCell.appendChild(deleteButton);
    }

}


function addFriendsHeroSelect() {

    var selectHero1 = document.getElementById("selectHero1");
    var selectHero2 = document.getElementById("selectHero2");
    var editHero1 = document.getElementById("editHero1");
    var editHero2 = document.getElementById("editHero2");

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
            for (var i = 0; i < heroes.length; i++) {

                var hero = heroes[i].name;
                var el1 = document.createElement("option");
                el1.text = hero;
                el1.value = heroes[i].id;
                var el2 = document.createElement("option");
                el2.text = hero;
                el2.value = heroes[i].id;
                var el3 = document.createElement("option");
                el3.text = hero;
                el3.value = heroes[i].id;
                var el4 = document.createElement("option");
                el4.text = hero;
                el4.value = heroes[i].id;

                selectHero1.append(el1);
                selectHero2.append(el2);
                editHero1.append(el3);
                editHero2.append(el4);

            }
        }

    };

    xhr.send();


}


function friendshipUpdate(i) {


    $("#modalToUpdate").modal('show');

    var index = Number(i);

    $("#edit").click(function () {


        var friendshipId = {id: Number(index)};
        var hero1id = {id: $("#editHero1").val()};
        var hero2id = {id: $("#editHero2").val()};




        var friendship = [friendshipId, hero1id, hero2id];

        $.ajax({
            url: ajaxUrl,
            type: "PATCH",
            data: JSON.stringify(friendship),
            contentType: 'application/json',
            dataType: 'json',
            success: function (response) {

                updateTable(response);

            },
            error: function (jqXHR) {
                alert(jqXHR.responseText);

            }
        });


        $("#modalToUpdate").modal('hide');

//        


    });
}


function friendshipDelete(i) {
    $("#modalToDelete").modal('show');
    var index = Number(i);

    $("#delete").click(function () {

        var friendshipId = {id: Number(index)};
        $.ajax({
            url: ajaxUrl,
            type: "DELETE",
            data: JSON.stringify(friendshipId),
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


        $("#modalToDelete").modal('hide');
    });


}

