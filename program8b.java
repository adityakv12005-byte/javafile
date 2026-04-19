package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class eightb extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Step 1: Handle GET request
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int visitCount = 1;
        String username = null;

        Cookie[] cookies = request.getCookies();

        // Step 2: Read cookies
        if (cookies != null) {
            for (Cookie c : cookies) {

                if (c.getName().equals("username")) {
                    username = c.getValue();
                }

                if (c.getName().equals("visit")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++; // increase visit count
                }
            }
        }

        // Step 3: If user exists
        if (username != null) {

            // update visit cookie
            Cookie visitCookie = new Cookie("visit", String.valueOf(visitCount));
            visitCookie.setMaxAge(60); // expires in 60 seconds
            response.addCookie(visitCookie);

            out.println("<html><body>");
            out.println("<h2>Welcome back, " + username + "!</h2>");
            out.println("<h3>You have visited this page " + visitCount + " times.</h3>");

            // Step 4: Display all cookies
            out.println("<h3>Cookie List:</h3>");

            for (Cookie c : cookies) {
                out.println("Name: " + c.getName() +
                            " | Value: " + c.getValue() + "<br>");
            }

            // Step 5: Show expiry info
            out.println("<br><b>Note:</b> Cookies expire in 60 seconds");

            out.println("<br><br><a href='CookieServlet'>Refresh Page</a>");
            out.println("</body></html>");

        } else {
            out.println("<html><body>");
            out.println("<h2>Please submit your name first.</h2>");
            out.println("</body></html>");
        }
    }

    // Step 6: Handle POST request (first login)
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        // Create cookies
        Cookie userCookie = new Cookie("username", username);
        Cookie visitCookie = new Cookie("visit", "1");

        // Step 7: Set expiry (60 seconds)
        userCookie.setMaxAge(60);
        visitCookie.setMaxAge(60);

        response.addCookie(userCookie);
        response.addCookie(visitCookie);

        // Redirect to GET method
        response.sendRedirect("CookieServlet");
    }
}

index.html

<!DOCTYPE html>
<html>
<head>
    <title>Cookie Login</title>
</head>
<body>

<h2>Enter Your Name</h2>

<form action="CookieServlet" method="post">
    Name: <input type="text" name="username" required>
    <input type="submit" value="Submit">
</form>

</body>
</html>