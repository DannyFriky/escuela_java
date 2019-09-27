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
                <link rel="stylesheet" type="text/css" href="style/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Usuario</h2>


        <% ArrayList<Persona> pers = (ArrayList) session.getAttribute("resultadoBuscado");


        %>

        <% if (pers != null) {
                for (int i = 0; i < pers.size(); i++) {
                    if (pers.get(i) != null) {
        %>
        <br/>
        <form name='formMod' method='post' action='./personas.do' class="tabla"> 
            <label for="nombre">Nombre: </label>
            <input type='text' name ="nombre" id="nombre"  value="<%=pers.get(i).getNombre()%>"/>
            <label for="edad">Edad </label>
            <input type='text' name ="edad" id="edad"  value="<%=pers.get(i).getEdad()%>"/>
            <label for="mail">Mail </label>
            <input type='text' name ="mail" id="mail"  value="<%=pers.get(i).getMail()%>"/>
            <label for="pass">Contraseña </label>
            <input type='text' name ="pass" id="pass"  value="<%=pers.get(i).getPass()%>"/>
            <input type='hidden' name ="nombreA" id="nombreA"  value="<%=pers.get(i).getNombre()%>"/>
            

            <input type='submit' name="metodo" value='modificado'/>
            <input type='submit' name="metodo" value='borrar' />
        </form>
        <%          }
                }
        } else {%>
        <span style="color: red">
            No se han encontrado personas
        </span>
        <%}%>

        <input type='button' value='volver' onclick="window.location.href='/Ejemplo_MVC_JSP/index.jsp'"/>
    </body>
    </html>
