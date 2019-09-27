<%-- 
    Document   : borrado
    Created on : 27-sep-2019, 11:53:41
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrado usuario</title>
    </head>
    <body>
        <h1>Borrar usuario</h1>
		<% boolean borr =(boolean)session.getAttribute("resultadoBorrar") ; %>
		
		<%
			if(borr == true){
				
		%>
			<span style="color:green"> Usuario borrado </span>
		<%
			}else{
		%>
			<span style="color: red"> Usuario NO borrado </span>
		<%
			}
		%>
    </body>
</html>
