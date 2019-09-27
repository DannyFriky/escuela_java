<%-- 
    Document   : borrado
    Created on : 27-sep-2019, 11:53:41
    Author     : alumno
--%>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrado usuario</title>
    </head>
    <body>
        <h1>Borrar usuario</h1>
		<% ArrayList<Boolean> borr =(ArrayList<Boolean>)session.getAttribute("resultadoBorrar") ; %>
		
		<%
			
				
		%>
			<span style="color:green"> Usuario borrado </span>
		<%
			
		%>
			<span style="color: red"> Usuario NO borrado </span>
		<%
			}
		%>
              <input type='button' value='volver' onclick="window.location.href='/Ejemplo_MVC_JSP/index.jsp'"/>
    </body>
</html>
