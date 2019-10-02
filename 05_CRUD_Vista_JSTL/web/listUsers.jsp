<%-- 
    Document   : listUsers
    Created on : 01-oct-2019, 16:48:04
    Author     : alumno
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sinensia.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usersList" type="java.util.ArrayList<User>" scope="request">
    <jsp:getProperty property="*" name="usersList"></jsp:getProperty>
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Users</title>
    </head>
    <body>
        <h1>List Users</h1>
        
        <c:if test="${ userLogged != null}">
            <c:forEach items="${usersList}" var="user">
                <form action="users.do" method="post">
                    <table>

                        <tr>
                            <td><input id="id" name="id" readonly size="4" value="${user.id}"/></td>
                            <td><input id="email" name="email" type="text" size="25" value="${user.email}"/></td>
                            <td><input id="password" name="password" type="text" size="25" value="${user.password}"/></td>
                            <td><input id="name" name="name" type="text" size="30" value="${user.name}"/></td>
                            <td><input id="age" name="age" type="text" size="3" value="${user.age}"/></td>
                            <td><input name="method" type="submit" value="Delete"/></td>
                            <td><input name="method" type="submit" value="Modify"/></td>
                        </tr>



                    </table>
                </form>
            </c:forEach>
        </c:if>
        <% if( session.getAttribute("userLogged") == null){%>
             <a href="index.jsp">Loggeate</a>
        <%}%>

    </body>
</html>
