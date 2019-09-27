<%-- 
    Document   : modificar
    Created on : 27-sep-2019, 10:02:33
    Author     : alumno
--%>

<%@page import="com.sinensia.modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Usuario a modificar</h2>
     

        <% Persona persona =(Persona)session.getAttribute("resultadoModificar") ;%>
        

        <br/>
        <form name='formMod' method='post' action='./personas.do'> 
        <label for="nombre">Nombre: </label>
        <input type='text' name ="nombre" id="nombre"  value="<%=persona.getNombre()%>"/>
        <label for="edad">Edad </label>
        <input type='text' name ="edad" id="edad"  value="<%=persona.getEdad()%>"/>
        <label for="mail">Mail </label>
        <input type='text' name ="mail" id="mail"  value="<%=persona.getMail()%>"/>
        <label for="pass">Contraseña </label>
        <input type='text' name ="pass" id="pass"  value="<%=persona.getPass()%>"/>
        <input type='hidden' name ="nombreA" id="nombreA"  value="<%=persona.getNombre()%>"/>
        <input type='hidden' name='metodo' id='metodo' value='modificado'/>
        
        
        <input type='submit' value='modificado'/>

        </form>
        
    </body>
</html>
