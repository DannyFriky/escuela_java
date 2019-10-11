window.onload = function ()
{
    let data_table = document.getElementById("data_table");
    //Que va en casi todos  los navegadores excepto IE
    let ajaxObj = new XMLHttpRequest();
    //Evento de cambio de estado de la llamada HTTP
    ajaxObj.onreadystatechange = function ()
    {
        /*alert("State changed: "+ this.readyState + ", status"+ this.status)*/
        if (this.readyState === 4 && this.status === 200)
        {
            let jsonResp = this.responseText;
            //Convertir texto Json en obj JS
            let objRespListUsers = JSON.parse(jsonResp);
            data_table.innerHTML = "";
            for (let user of objRespListUsers)
            {
                data_table.innerHTML += `<tr><td>${user.id}</td>
                                        <td>~${user.email}</td>
                                        <td>~${user.name}</td></tr>`
            }
        }
    }

    ajaxObj.open("GET", "api/users");
    ajaxObj.send();
};

function register()
{
    //Cargamos el formulario
    var form = document.forms['formJSON'];

    var array = jQuery(form).serializeArray();

    var json = {};

    jQuery.each(array, function () {
        json[this.name] = this.value || '';
    });

    sendJSONToServer(json);
    alert("Register")
}
function sendJSONToServer(json)
{
    $.ajax({
        type: "POST",
        url: "api/users",

        data: JSON.stringify(json),
        dataType: 'json'

    });
}
function modify()
{
    var form = document.forms['formJSON'];
    var array = jQuery(form).serializeArray();

    var json = {};

    jQuery.each(array, function () {
        json[this.name] = this.value || '';
    });

    sendJSONTModify(json);
    alert("Modify");
}
function sendJSONTModify(json)
{
       $.ajax(
    {
        type: "PUT",
        url: "api/users",
        data: JSON.stringify(json),
        dataType: 'json'
   });
}

function delet()
{
    var form = document.forms['formJSON'];
    var array = jQuery(form).serializeArray();

    var json = {};

    jQuery.each(array, function () {
        json[this.name] = this.value || '';
    });

    sendJSONTDelete(json);
    alert("Delete");
}
function sendJSONTDelete(json)
{
       $.ajax(
    {
        type: "DELETE",
        url: "api/users",
        data: JSON.stringify(json),
        dataType: 'json'
   });
}

