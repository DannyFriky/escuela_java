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
                <form action="users.do" method="post">
        <table>
            <c:forEach items="${usersList}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                </tr>
                
            </c:forEach>
                </form>
        </table>
    </body>
</html>
