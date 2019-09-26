<%-- 
    Document   : registro
    Created on : 26-sep-2019, 10:26:58
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>TODO write content</div>

        <form name='form1' method='post' action='./param.jsp'> 
            <table border='1'> 
                <tr><td>Nombre</td> 
                    <td><input type='text' name='nombre' id='nombre'/></td></tr> 
                <tr><td>Edad</td> 
                    <td><input type='number' name='edad' id='edad'/></td></tr> 
                <tr><td>Contraseña</td> 
                    <td><input type='password' name='contra1' id='contra1'/></td></tr> 
                <tr><td>Repita la contraseña</td> 
                    <td><input type='password' name='contra2' id='contra2'/></td></tr> 
            </table> 
            <input type='submit' value='enviar'/>
    </form> 
</body>
</html>