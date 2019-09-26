<%-- 
    Document   : exito
    Created on : 26-sep-2019, 13:41:49
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exito - Registrado</title>
    </head>
    <body>
        <h1>Exito - Registrado</h1>
        <label for="nombre">Nombre: </label>
        <input id="nombre" readonly value="<%=request.getParameter("nombre")%>"/>
        <label for="edad">Edad </label>
        <input id="edad" readonly value="<%=request.getParameter("edad")%>"/>
        <label for="mail">Mail: </label>
        <input id="mail" readonly value="<%=request.getParameter("mail")%>"/>
        <label for="pass">Contraseña </label>
        <input id="pass" readonly value="<%=request.getParameter("pass")%>"/>
    </body>
</html>
