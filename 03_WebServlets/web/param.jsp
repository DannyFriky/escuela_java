<%-- 
    Document   : param
    Created on : 25-sep-2019, 17:37:09
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./Estilos/estilos.jsp">
    </head>
    <body>
        <%@include file="barra_nav.jsp" %>
        <h1>Datos</h1>


        <p>Te llamas <%out.println(request.getParameter("nombre"));%></p>
        <p>Tienes <%out.println(request.getParameter("edad"));%></p>
        <%
        if(request.getParameter("contra1").compareTo(request.getParameter("contra2"))!=0){
            out.println("Las contraseñas no son iguales");
        }
        %>
        
        <% for(int i=0; i<10;i++){%>
	<p class ="tipo-letra-tam-<%=i%>" >Numero generado en Java: <%=i%></p>
			 <% }%>
        <p>Tienes <%out.println(request.getParameter("contra1"));%></p>
        
        <p>Tienes <%out.println(request.getParameter("contra2"));%></p>

    </body>
</html>
