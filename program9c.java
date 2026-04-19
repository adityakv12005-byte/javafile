index.jsp

<%@ page language="java" session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Session Login</title>
</head>
<body>

<h2>Enter Your Name</h2>

<form action="welcome.jsp" method="post">
    Name: <input type="text" name="username" required>
    <input type="submit" value="Submit">
</form>

</body>
</html>

welcome.jsp

<%@ page import="java.util.*" %>
<%@ page session="true" %>

<%
    // Set session expiry time (in seconds)
    session.setMaxInactiveInterval(60); // 1 minute

    String name = request.getParameter("username");

    if (name != null) {
        session.setAttribute("username", name);
    }

    String user = (String) session.getAttribute("username");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<%
    if (user != null) {
%>

<h2>Hello <%= user %> !</h2>

<p><b>Session ID:</b> <%= session.getId() %></p>
<p><b>Session Expiry Time:</b> <%= session.getMaxInactiveInterval() %> seconds</p>

<br>

<!-- Link to check session -->
<a href="check.jsp">Click here to check session status</a>

<br><br>

<p><b>Note:</b> Session will expire in 1 minute if inactive.</p>

<%
    } else {
%>

<h2>Session Expired or Not Created</h2>
<a href="index.jsp">Go Back</a>

<%
    }
%>

</body>
</html>

check.jsp 

<%@ page session="true" %>

<%
    String user = (String) session.getAttribute("username");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Check Session</title>
</head>
<body>

<%
    if (user != null) {
%>

<h2>Session is ACTIVE</h2>
<h3>Welcome back, <%= user %>!</h3>

<p><b>Session ID:</b> <%= session.getId() %></p>

<a href="welcome.jsp">Go Back</a>

<%
    } else {
%>

<h2>Session EXPIRED</h2>
<p>Your session has ended after inactivity.</p>

<a href="index.jsp">Login Again</a>

<%
    }
%>

</body>
</html>


