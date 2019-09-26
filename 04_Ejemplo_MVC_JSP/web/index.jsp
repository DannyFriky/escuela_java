<%-- 
    Document   : index
    Created on : 26-sep-2019, 15:52:48
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC con JSP y Servlet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h2>Añadir Persona</h2>
        <form name='form1' method='post' action='./personas.do'> 
            <table border='1'> 
                <tr><td>Nombre</td> 
                    <td><input type='text' name='nombre' id='nombre'/></td></tr> 
                <tr><td>Edad</td> 
                    <td><input type='number' name='edad' id='edad'/></td></tr> 

            </table> 
            <input type='submit' value='enviar'/>
        </form>
        
        <h2>Buscar Persona</h2>
        <form name='formBusq' method='get' action='./personas.do'> 
            <table border='1'> 
                <tr><td>Nombre</td> 
                    <td><input type='text' name='nombre' id='nombre'/></td>
                <td><input type='submit' value='enviar'/></td> 
                </tr> 

            </table> 
            
        </form>
    </body>
</html>

