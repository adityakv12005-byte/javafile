package com.example;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/processResult")
public class tenb extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String name = request.getParameter("name");

        int[] marks = new int[5];
        boolean valid = true;
        String message = "";

        // Server-side validation
        if (rollno == null || rollno.trim().isEmpty() ||
            name == null || name.trim().isEmpty()) {
            valid = false;
            message = "Roll No and Name are required!";
        }

        try {
            for (int i = 0; i < 5; i++) {
                marks[i] = Integer.parseInt(request.getParameter("sub" + (i + 1)));
                if (marks[i] < 0 || marks[i] > 100) {
                    valid = false;
                    message = "Marks must be between 0 and 100";
                }
            }
        } catch (Exception e) {
            valid = false;
            message = "Invalid mark input!";
        }

        if (!valid) {
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
            return;
        }

        // Calculation
        int total = 0;
        boolean pass = true;

        for (int m : marks) {
            total += m;
            if (m < 40) {
                pass = false;
            }
        }

        double avg = total / 5.0;

        // Set attributes
        request.setAttribute("rollno", rollno);
        request.setAttribute("name", name);
        request.setAttribute("marks", marks);
        request.setAttribute("total", total);
        request.setAttribute("average", avg);
        request.setAttribute("result", pass ? "PASS" : "FAIL");
        request.setAttribute("message", "Data processed successfully");

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}

index.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Marks Entry</title>

<script>
function validateForm() {
    let rollno = document.forms["studentForm"]["rollno"].value;
    let name = document.forms["studentForm"]["name"].value;

    if (rollno === "" || name === "") {
        alert("Roll No and Name are required!");
        return false;
    }

    for (let i = 1; i <= 5; i++) {
        let mark = document.forms["studentForm"]["sub" + i].value;
        if (mark === "" || mark < 0 || mark > 100) {
            alert("Enter valid marks (0–100) for Subject " + i);
            return false;
        }
    }
    return true;
}
</script>

<style>
.container {
    width: 350px;
    margin: 40px auto;
    padding: 20px;
    border: 1px solid #ccc;
}
input {
    margin: 5px;
}
</style>

</head>

<body>

<div class="container">
<h2>Student Marks Form</h2>

<form name="studentForm" action="processResult" method="post" onsubmit="return validateForm()">

    Roll No: <input type="text" name="rollno"><br>
    Name: <input type="text" name="name"><br>

    Sub1: <input type="number" name="sub1"><br>
    Sub2: <input type="number" name="sub2"><br>
    Sub3: <input type="number" name="sub3"><br>
    Sub4: <input type="number" name="sub4"><br>
    Sub5: <input type="number" name="sub5"><br>

    <input type="submit" value="Submit">

</form>
</div>

</body>
</html>

result.jsp

<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Result Page</title>

<style>
.container {
    width: 350px;
    margin: 40px auto;
    padding: 20px;
    border: 1px solid #ccc;
}
.pass { color: green; }
.fail { color: red; }
</style>

</head>

<body>

<div class="container">
<h2>Student Result</h2>

<%
    String msg = (String) request.getAttribute("message");
    if (msg != null) {
%>
    <p><b><%= msg %></b></p>
<%
    }

    String rollno = (String) request.getAttribute("rollno");
    String name = (String) request.getAttribute("name");

    if (rollno != null) {
        int[] marks = (int[]) request.getAttribute("marks");
        int total = (Integer) request.getAttribute("total");
        double avg = (Double) request.getAttribute("average");
        String result = (String) request.getAttribute("result");
%>

    <p>Roll No: <%= rollno %></p>
    <p>Name: <%= name %></p>

    <p>Marks:</p>
    <ul>
        <li>Sub1: <%= marks[0] %></li>
        <li>Sub2: <%= marks[1] %></li>
        <li>Sub3: <%= marks[2] %></li>
        <li>Sub4: <%= marks[3] %></li>
        <li>Sub5: <%= marks[4] %></li>
    </ul>

    <p>Total: <%= total %></p>
    <p>Average: <%= avg %></p>

    <h3 class="<%= result.equals("PASS") ? "pass" : "fail" %>">
        Result: <%= result %>
    </h3>

<%
    }
%>

<br>
<a href="index.jsp">Back to Form</a>

</div>

</body>
</html>