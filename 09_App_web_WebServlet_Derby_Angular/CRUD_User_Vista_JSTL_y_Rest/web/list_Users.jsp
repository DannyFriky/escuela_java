<%-- 
    Document   : list_Users
    Created on : 01-oct-2019, 16:47:57
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sinensia.model.User"%>
<jsp:useBean id="usersList" type="java.util.ArrayList<User>" scope="request">
    <jsp:getProperty property="*" name="usersList"></jsp:getProperty>
</jsp:useBean>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users list</title>
    </head>
    <body>
        <h1>Users list</h1>
        <%-- ${} correspode a EL (Expression Languages) de JSTL --%>
        <c:if test="${sessionScope.userLogged != nill}">
            <c:forEach items="${usersList}" var="user">
                <form action="users.do" method="post">
                    <table>
                        <tr>
                            <td><input id="id" name="id" size="4" readonly type="number" value="${user.id}"></input></td>
                            <td><input id="email" name="email" size="50" type="text" readonly value="${user.email}"></input></td>
                            <td><input id="password" name="password" size="50" type="text" value="${user.password}"></input></td>
                            <td><input id="name" name="name" size="50" type="text" value="${user.name}"></input></td>
                            <td><input id="age" name="age" size="2" type="number" value="${user.age}"></input></td>
                            <td><input type="submit" value="Delete" name="method"></td>
                            <td><input type="submit" value="Modify" name="method"></td>
                        </tr>
                    </table>
                </form>
            </c:forEach>
        </c:if>
       <%-- <c:if test="${sessionScope.userLogged== null}">--%>
            <% if(session.getAttribute("userLogged") == null) {%>
            You didn't logged.
            <br/>
            <a href="index.jsp">Home</a>
            <% } %>
        <%--</c:if>--%>
    </body>
</html>