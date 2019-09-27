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
                <tr><td>Mail</td> 
                    <td><input type='text' name='mail' id='mail'/></td></tr> 
                <tr><td>Password</td> 
                    <td><input type='password' name='pass' id='pass'/>
                    <input type='hidden' name='metodo' id='metodo' value='anadir'/></td></tr> 
            </table>  
            <input type='submit' value='enviar'/>
        </form>

        <h2>Buscar Persona</h2>
        <form name='formBusq' method='post' action='./personas.do'> 
            <table border='1'> 
                <tr><td>Nombre</td> 
                    <td><input type='text' name='nombre' id='nombre'/></td>
                </tr> 
                <tr><td>Mail</td> 
                    <td><input type='text' name='mail2' id='mail2'/>
                    <input type='hidden' name='metodo' id='metodo' value='buscar'/></td>
                    <td><input type='submit' value='enviar'/></td> 

            </table> 

        </form>

        <h2>Modificar Persona</h2>
        <form name='formMod' method='post' action='./personas.do'> 
            <table border='1'> 
                <tr><td>Nombre a modificar</td> 
                    <td><input type='text' name='nombre' id='nombre'/>
                        <input type='hidden' name='metodo' id='metodo' value='modificar'/>

                    </td>
                    <td><input type='submit' value='modificar'/></td> 
                </tr> 
            </table> 

        </form>
        
        <h2>Borrar Persona</h2>
        <form name='formMod' method='post' action='./personas.do'> 
            <table border='1'> 
                <tr><td>Nombre a borrar</td> 
                    <td><input type='text' name='nombre' id='nombre'/>
                        <input type='hidden' name='metodo' id='metodo' value='borrar'/>

                    </td>
                    <td><input type='submit' value='borrar'/></td> 
                </tr> 
            </table> 

        </form>
    </body>
</html>

