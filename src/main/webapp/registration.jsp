<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/14/2022
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="RegistrationServlet" >
    <div class="container">
        <h3>Registration Page</h3><br>
        <label for="username">Enter your username:</label><br>
        <input type="text" id="username" name="username" placeholder="Username" required ><br><br>
        <label for="mail">Enter your mail:</label><br>
        <input type="text" id="mail" name="mail" placeholder="Mail" required ><br><br>
        <label for="firstname">Enter your name:</label><br>
        <input type="text" id="firstname" name="firstname" placeholder="Firstname" required ><br><br>
        <label for="lastname">Enter your surname:</label><br>
        <input type="text" id="lastname" name="lastname" placeholder="Lastname" required ><br><br>
        <label for="profession">Enter your profession:</label><br>
        <input type="text" id="profession" name="profession" placeholder="Profession" required><br><br>
        <label for="password">Enter your password:</label><br>
        <input type="password" id="password" name="password" placeholder="Password" required><br><br>
        <label for="reppassword">Please, confirm password:</label><br>
        <input type="password" id="reppassword" name="reppassword" placeholder="Repeat password" required ><br><br>
        <%if(request.getAttribute("status") != null){%>
            <% if(request.getAttribute("status").equals("uname taken")){%>
                <label form="registration-form"> Username already taken, DUMB! </label>
            <%} else if(request.getAttribute("status").equals("mail taken")){%>
                <label form="registration-form"> Mail already taken, DUMB! </label>
            <%}else if(request.getAttribute("status").equals("pass mismatch")){%>
                <label form="registration-form"> Are you IDIOT?! passwords don't match. dumbass... </label><br><br>
        <%}}%>
        <%--      <input type="submit" value="Register" href="userPage.jsp">--%>
        <button type="submit" class="regbtn" href="userPage.jsp" value="Register" >Register</button>
</form>
<div class="container logIn">
    <p>Already have an account? <a href="index.jsp">Log in</a></p>
</div>
<%--    <a href="index.jsp"> Login </a>--%>

</body>
</html>
