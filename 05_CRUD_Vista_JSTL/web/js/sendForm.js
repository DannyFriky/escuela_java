/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
const formToJSON = elements => [].reduce.call(elements, (data, element) => {

        data[element.name] = element.value;
        return data;

    }, {});


const handleFormSubmit = event => {

    // Stop the form from submitting since we’re handling that with AJAX.
    event.preventDefault();

    // TODO: Call our function to get the form data.
    let objUser = {
            "email": $("#email").val(),
            "age": $("#age").val()
        };
        
        let objMethod = {
            "method": $("#method").val()
        };
   // const data = formToJSON(form.elements);

       let send = JSON.stringify(objUser);
 let send2 = objMethod;
    //send = JSON.parse(send);
    $.ajax({
        url: "api/users",
        type: "POST",// GET POST PUT DELETE , con sus respectivos do---
        data: {"json" :send,"method":send2} ,
        dataType: "json",
        complete: function (obj) {
            alert(obj.responseText);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            //alert(xhr.status);
            //alert(ajaxOptions);
            alert(thrownError);
        }
    });
    
    

};


const form = document.getElementById('data_form');
form.addEventListener('submit', handleFormSubmit);

*/

    /*
     * German lo ha hecho de otra forma pero muy similar, ojear 
     *$.post({"url": "....",
     *"contentType":"JSON",
     *"data":JSON.stringify(objUser),
     *"succes": lokesea
     *});
     * 
     * 
     * 
     */
    // ...this is where we’d actually do something with the form data...  
    /*const dataContainer = document.getElementById('results__display');
     
     // Use `JSON.stringify()` to make the output valid, human-readable JSON.
     dataContainer.textContent = JSON.stringify(data, null, "  ");*/

$(document).ready(function () {
    $("#btnSend").click(function () {
        let objUser = {
            "email": $("#email").val(),
            "password": $("#password").val(),
            "name": $("#name").val(),
            "age": $("#age").val()
        };
        $.post({"url": "api/users", 
                "contentType": "JSON",
                "data": JSON.stringify(objUser),
                "success":
                    function (respuestaUserObj) {
                        $("#id").val(respuestaUserObj.id);
                    }
                });
               
    });
    
     $("#btnDel").click(function () {
        let objUser = {
            "id":$("#id").val(),
            "email": $("#email").val(),
            "password": $("#password").val(),
            "name": $("#name").val(),
            "age": $("#age").val()
        };
        $.ajax({"url": "api/users", 
            type: "DELETE",
                "contentType": "JSON",
                "data": JSON.stringify(objUser),
                "success":
                    function (respuestaUserObj) {
                       alert(respuestaUserObj.borrado +" Mensaje :" +respuestaUserObj.mensaje);
                    }
                });
               
    });
});