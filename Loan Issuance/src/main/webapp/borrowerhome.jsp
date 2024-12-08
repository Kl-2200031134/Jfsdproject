<%@ page import="com.klef.sdp.springboot.model.Borrower" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    Borrower b = (Borrower) session.getAttribute("borrower");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Borrower Home</title>
    <link rel="stylesheet" href="styles.css" />
    <style>
        /* General page styling */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f7fb;
        }

        /* Container for the content */
        .home-content {
            max-width: 900px;
            margin: 40px auto;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 12px;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        /* Header and welcome text */
        h1 {
            color: #3b5998;
            font-size: 2.5em;
            margin-bottom: 20px;
        }

        h2 {
            color: #4a90e2;
            font-size: 1.8em;
            font-weight: 600;
        }

        /* Welcome message styling */
        .welcome-message {
            font-size: 1.2em;
            color: #333;
            margin: 20px 0;
            padding: 20px;
            background-color: #eef2f7;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        /* Navbar styling */
        nav {
            background-color: #0056b3;
            padding: 10px 20px;
            text-align: center;
        }

        nav a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
            font-size: 1.1em;
        }

        nav a:hover {
            color: #ffcc00;
        }

        /* Footer styling */
        footer {
            text-align: center;
            margin-top: 50px;
            padding: 20px;
            background-color: #333;
            color: white;
        }
    </style>
</head>
<body>

    <%@ include file="borrowernavbar.jsp" %>

    <div class="home-content">
        <h1>Welcome to Your Borrower Dashboard</h1>
        <div class="welcome-message">
            <h2>Hello, <%= b.getName() %>!</h2>
            <p>Welcome back! Here you can manage your loan applications, track payments, and more. Please navigate through the options in the menu.</p>
        </div>
        <!-- Add additional sections for loan status, applications, etc. -->
    </div>

    
</body>
</html>
