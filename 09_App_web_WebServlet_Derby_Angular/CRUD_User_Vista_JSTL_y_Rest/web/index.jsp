<!DOCTYPE html>
<html>
    <head>
        <title>Vista JSLT Operaciones CRUD</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" src="js/md5.min.js"></script>
        <script type="text/javascript" src="js/encrypt.js"></script>
    </head>
    <body>
        <h1>Vista JSLT Operaciones CRUD</h1>
        <ul>
            <li><a href="register.jsp">Register</a></li>
            <li><a href="users.do">Users List</a></li>
            <li><a href="restClient.html">Rest Client con Ajax</a></li>
        </ul>
        <form id="form1" action="users.do" method="get">
            <label for="email">Email: </label>
            <input id="email" name="email" type="email" placeholder="Write your email..."
                   size="50" maxlength="255" required="required" value="${cookie.email.value}"/>
            <br/>
            <label for="password">Password: </label>
            <input id="password" name="password" type="password" placeholder="Write your password..."
                   size="50" maxlength="50" required="required" value=""/>
            <br/>
            <input type="submit" value="Login" name="method"/>
        </form>

    </body>
</html>
