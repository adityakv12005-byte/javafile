package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//UserDataServlet.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/processUser")
public class tena extends HttpServlet {
 
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
     
     // Get parameters from the request
     String username = request.getParameter("username");
     String email = request.getParameter("email");
     String designation = request.getParameter("designation");
     
     // Perform some basic validation
     String message;
     if (username == null || username.trim().isEmpty()) {
         message = "Username is required";
     } else {
         // Process the data (in real app, you might save to database)
         message = "User data processed successfully";
         
         // Store data in request attributes to be accessed by JSP
         request.setAttribute("username", username);
         request.setAttribute("email", email);
         request.setAttribute("designation", designation);
     }
     request.setAttribute("message", message);
     
     // Forward to result JSP
     RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
     dispatcher.forward(request, response);
 }
 
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
     // Redirect GET requests to the input form
     response.sendRedirect("index.jsp");
 }
}


index.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Data Form</title>
    <style>
        .form-container {
            width: 300px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
        }
        .form-field {
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Enter User Data</h2>
        <form action="processUser" method="POST">
            <div class="form-field">
                <label for="username">Username       :</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-field">
                <label for="email">Email           :</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-field">
                <label for="designation">Designation     :</label>
                <input type="text" id="designation" name="designation" required>
            </div>
            <div class="form-field">
                <input type="submit" value="Submit">
            </div>
        </form>
    </div>
</body>
</html>

result.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Result Page</title>
    <style>
        .result-container {
            width: 300px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
        }
        .message {
            color: green;
            margin-bottom: 20px;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="result-container">
        <h2>Processing Result</h2>
        <div class="${message.contains('error') ? 'error' : 'message'}">
            <%= request.getAttribute("message") %>
        </div>
        
        <% if(request.getAttribute("username") != null) { %>
            <h3>Submitted Data:</h3>
            <p>Username: <%= request.getAttribute("username") %></p>
            <p>Email: <%= request.getAttribute("email") %></p>
            <p>Designation: <%= request.getAttribute("designation") %></p>
        <% } %>
        
        <a href="index.jsp">Back to Form</a>
    </div>
</body>
</html>
