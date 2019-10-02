<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Vista JSTL Operaciones CRUD</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Vista JSTL Operaciones CRUD</h1>
        <ul>
            <li><a href="register.jsp">Register</a></li>
            <li><a href="users.do">Users</a></li>
        </ul>
        <form id="formLogin" action="users.do" method="get">

            Email: <input id="email" name="email" type="text" size="25" value="${cookie.email.value}"/>
            Password: <input id="password" name="password" type="password" size="25"/>

            <input name="method" type="submit" value="Login"/>
        </form>

        <script src='js/md5.min.js'></script>
        <script src='js/encrypt.js'></script>

    </body>
</html>
