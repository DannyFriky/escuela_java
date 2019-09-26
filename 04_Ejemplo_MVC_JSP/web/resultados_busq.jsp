<%-- 
    Document   : resultados_busq
    Created on : 26-sep-2019, 16:02:33
    Author     : alumno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.sinensia.modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Usuario</h2>
     

        <% ArrayList<Persona> pers =(ArrayList)session.getAttribute("resultadoBuscado") ;
        

        
        %>
        
        <% if (pers != null ) {
        for(int i =0;i<pers.size();i++){
            if(pers.get(i)!=null){
        %>
        <br/>
        <label for="nombre">Nombre: </label>
        <input id="nombre" readonly value="<%=pers.get(i).getNombre()%>"/>
        <label for="edad">Edad </label>
        <input id="edad" readonly value="<%=pers.get(i).getEdad()%>"/>
        <label for="mail">Mail </label>
        <input id="mail" readonly value="<%=pers.get(i).getMail()%>"/>
        <label for="pass">Contraseña </label>
        <input id="pass" readonly value="<%=pers.get(i).getPass()%>"/>
        <% } }}else {%>
        <span style="color: red">
            No se han encontrado personas
        </span>
        <%}%>
    </body>
</html>
