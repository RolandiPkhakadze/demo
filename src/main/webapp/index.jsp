<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<h1>Log in</h1>
<form action="LoginServlet" >
    <label for="username">give me mail or username</label><br><br>
    <input type="text" id="username" class="username" placeholder="username " name="username"><br><br>
    <label for="password">give me password, asshole  :P :D</label><br><br>
    <input type="password" id="password" class="input-box" placeholder="password" name="password"><br><br>
    <% if (request.getAttribute("loginStatus") != null){ %>
    <%  if (request.getAttribute("loginStatus").equals("wrong uname")) {%>
    <label form="login-form"> Invalid username or mail </label>
    <% }else if(request.getAttribute("loginStatus").equals("incorrect pass")) { %>
    <label form="login-form"> Password incorrect </label>
    <% }}%>
    <br>
    <button type="submit" class="login-button">Sign in</button>
    <br>
    <br>
    <a style="font-size: smaller;color: rgb(40, 65, 24)" class="newtohere-link" href="registration.jsp">New to here? Sign up!</a>
</form>
</body>
</html>