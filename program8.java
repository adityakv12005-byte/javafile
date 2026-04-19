package com.example;

// Step 1: Required imports
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

// Step 2: Servlet mapping
@WebServlet("/CookieServlet")
public class eighta extends HttpServlet {

    private static final long serialVersionUID = 1L;

    int count = 0; // NOTE: This resets on every request (not real session tracking)

    // Step 3: Handle GET request
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        // Step 4: Create cookie if user enters name
        if (userName != null && !userName.trim().isEmpty()) {
            Cookie userCookie = new Cookie("user", userName);

            // cookie lifetime (30 seconds, not 1 minute as comment said)
            userCookie.setMaxAge(30);

            response.addCookie(userCookie);
        }

        // Step 5: Read cookies
        Cookie[] cookies = request.getCookies();
        String existingUser = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user".equals(cookie.getName())) {
                    existingUser = cookie.getValue();
                    break;
                }
            }
        }

        // Step 6: HTML output
        out.println("<html><head><title>Cookie Example</title></head><body>");

        if (existingUser != null) {
            count++;
            out.println("<font color='blue'><h2>Welcome back, " + existingUser + "!</h2></font>");
            out.println("<font color='magenta'><h2>You have visited this page " + count + " times!</h2></font>");

            out.println("<form action='CookieServlet' method='post'>");
            out.println("<input type='submit' value='Logout'>");
            out.println("</form>");

        } else {
            out.println("<h2 style='color:red;'>Welcome Guest! Please login</h2>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Login'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    // Step 7: Logout (POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Correct way to delete cookie
        Cookie cookie = new Cookie("user", "");
        cookie.setMaxAge(0); // delete cookie immediately
        cookie.setPath("/"); // important for proper deletion

        response.addCookie(cookie);

        // redirect back
        response.sendRedirect("CookieServlet");
    }
}