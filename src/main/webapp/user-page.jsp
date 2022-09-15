<%@ page import="com.example.demo.controllers.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/14/2022
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<body>
<form action="UserPageServlet" >
    <h1>User Page</h1><br>
    <h2>Hello <%=((User)request.getSession().getAttribute("user")).getUsername()%> </h2>
    <div class="container">
        <label for="username">Update your username or email:</label><br>
        <input type="text" id="username" name="username" placeholder="Username" ><br><br>
        <label for="mail">Update your username or email:</label><br>
        <input type="text" id="mail" name="mail" placeholder="Email"  ><br><br>
        <label for="firstname">Update your name:</label><br>
        <input type="text" id="firstname" name="firstname" placeholder="Name"  ><br><br>
        <label for="lastname">Update your surname:</label><br>
        <input type="text" id="lastname" name="lastname" placeholder="Surname"  ><br><br>
        <label for="profession">Update your profession:</label><br>
        <input type="text" id="profession" name="profession" placeholder="Profession" ><br><br>
        <label for="password">Update your password:</label><br>
        <input type="password" id="password" name="password" placeholder="Password" ><br><br>
        <label for="repeat-password">Please, confirm password:</label><br>
        <input type="password" id="repeat-password" name="repeat-password" placeholder="Repeat password"  ><br><br>
        <input type="submit" value="Update">
    </div>

</form>
<div class="container signOut">
    <p>Want to sign out? <a href="index.jsp">Sign out</a></p>
</div>
</body>
</html>

