<%-- 
    Document   : result
    Created on : 02-oct-2019, 9:36:21
    Author     : alumno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <h1>Result</h1>
        <a href="index.jsp">Inicio</a>

        <c:catch var="loginException">
            <jsp:useBean id="userLogged" type="sinensia.model.User" scope="session">
                <jsp:getProperty property="*" name="userLogged"/>

            </jsp:useBean>
            <p>Usuario loggeado: ${userLogged.email}</p>
        </c:catch>

        <c:if test="${not empty loginException}">
            <c:if test="${param.method != null}">
                <c:if test="${userLogged != null}">
                <p>Exito Login</p>
                </c:if>
                <c:if test="${userLogged == null}">
                <p>Error Loggin</p>
                </c:if>
            </c:if>
            <c:if test="${param.method == null}">
                <p>Error on login</p>
            </c:if>
        </c:if>
        <c:if test="${requestScope.errorMessage != null}">
            <h3 style="color: orange"> 
                ${requestScope.errorMessage}
            </h3>  
            <c:remove var="errorMessage" scope="request"/>
        </c:if>



        <c:catch var="exception">
            <jsp:useBean id="user" type="sinensia.model.User" scope="request">
                <jsp:getProperty property="*" name="user"/>

            </jsp:useBean>
            <p>Usuario creado: ${user.email}</p>
        </c:catch>

        <c:if test="${not empty exception}">
            <c:if test="${param.method != null}">
                <p>Exito</p>
            </c:if>
            <c:if test="${param.method == null}">
                <p>Error on register</p>
            </c:if>
        </c:if>
        <c:if test="${requestScope.errorMessage != null}">
            <h3 style="color: orange"> 
                ${requestScope.errorMessage}
            </h3>  
            <c:remove var="errorMessage" scope="request"/>
        </c:if>
    </body>
</html>
