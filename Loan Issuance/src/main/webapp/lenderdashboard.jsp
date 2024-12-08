<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lender Dashboard</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f8ff;
        }

        .container {
            max-width: 80%;
            margin: 50px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1, h2, h3 {
            text-align: center;
            color: #333;
        }

        .menu {
            text-align: center;
            margin-bottom: 20px;
        }

        .menu a {
            margin: 0 15px;
            text-decoration: none;
            font-weight: bold;
            color: #007bff;
            padding: 8px 15px;
            border: 1px solid #007bff;
            border-radius: 5px;
            transition: background-color 0.3s, color 0.3s;
        }

        .menu a:hover {
            background-color: #007bff;
            color: #fff;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table th, table td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }

        table th {
            background-color: #f4f4f4;
            font-weight: bold;
        }

        table tr:hover {
            background-color: #f9f9f9;
        }

        .actions a {
            text-decoration: none;
            color: white;
            font-weight: bold;
            background-color: #28a745;
            padding: 5px 10px;
            border-radius: 4px;
            margin: 0 5px;
            display: inline-block;
        }

        .actions a.reject {
            background-color: #dc3545;
        }

        .actions a:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome, ${lender.name}!</h1>
        <h2>Your Loan Management</h2>
        <div class="menu">
            <a href="offerloan">Offer a Loan</a>
            <a href="viewloans">View My Loans</a>
            <a href="lenderlogout">Logout</a>
        </div>

        
    </div>
</body>
</html>
