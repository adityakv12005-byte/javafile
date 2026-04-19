package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prime")
public class sevenc extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int number = Integer.parseInt(request.getParameter("number"));

            // Validation
            if (number < 0) {
                throw new IllegalArgumentException("Number cannot be negative");
            }

            boolean isPrime = true;

            if (number == 0 || number == 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= number / 2; i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            // Output page
            out.println("<html>");
            out.println("<head><title>Prime Result</title></head>");
            out.println("<body>");
            out.println("<h2>Prime Number Result</h2>");
            out.println("<p>Number: " + number + "</p>");

            if (isPrime) {
                out.println("<h3 style='color:green;'>It is a PRIME number</h3>");
            } else {
                out.println("<h3 style='color:red;'>It is NOT a PRIME number</h3>");
            }

            out.println("<a href='index.html'>Try Again</a>");
            out.println("</body>");
            out.println("</html>");

        } catch (NumberFormatException e) {
            displayError(out, "Invalid input! Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            displayError(out, e.getMessage());
        }
    }

    private void displayError(PrintWriter out, String message) {
        out.println("<html>");
        out.println("<head><title>Error</title></head>");
        out.println("<body>");
        out.println("<div style='margin:20px; color:red;'>");
        out.println("<h2>Error</h2>");
        out.println("<p>" + message + "</p>");
        out.println("<a href='index.html'>Go Back</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.html");
    }
}



index.html

<!DOCTYPE html>
<html>
<head>
<title>Prime Number Checker</title>
<style>
.container {
    margin: 20px;
    padding: 20px;
    width: 300px;
    border: 1px solid #ccc;
    border-radius: 5px;
}
.form-group {
    margin: 10px 0;
}
</style>
</head>

<body>
<div class="container">
    <h2>Prime Number Checker</h2>

    <form action="prime" method="post">
        <div class="form-group">
            Enter a number:
            <input type="number" name="number" min="0" required>
        </div>

        <input type="submit" value="Check Prime">
    </form>
</div>
</body>
</html>