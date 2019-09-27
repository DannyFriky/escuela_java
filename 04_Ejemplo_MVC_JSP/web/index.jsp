<%-- 
    Document   : index
    Created on : 26-sep-2019, 15:52:48
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style/style.css"/>
        <title>Ejemplo MVC con JSP y Servlet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1 class="titulo">BASE DE DATOS DE STALKEO</h1>
        <div class="tabla_1">
        <h2>Añadir Persona</h2>
        <form name='form1' method='post' action='./personas.do'> 
            <table border='1'> 
                <tr><td>Nombre</td> 
                    <td><input type='text' name='nombre' id='nombre'/></td></tr> 
                <tr><td>Edad</td> 
                    <td><input type='number' name='edad' id='edad'/></td></tr> 
                <tr><td>Mail</td> 
                    <td><input type='text' name='mail' id='mail'/></td></tr> 
                <tr><td>Password</td> 
                    <td><input type='password' name='pass' id='pass'/>
                        <input type='hidden' name='metodo' id='metodo' value='anadir'/></td></tr> 
            </table>  
            <input type='submit' value='Añadir'/>
        </form>
        </div>
        <div class="tabla_2">
        <h2>Buscar Persona</h2>
        <form name='formBusq' method='post' action='./personas.do'> 
            <table border='1'> 
                <tr><td>Nombre</td> 
                    <td><input type='text' name='nombre' id='nombre'/></td>
                </tr> 
                <tr><td>Mail</td> 
                    <td><input type='text' name='mail2' id='mail2'/>
                        <input type='hidden' name='metodo' id='metodo' value='buscar'/></td>
                    

            </table> 
<input type='submit' value='Buscar'/>
        </form>
        </div>

    </body>
</html>

