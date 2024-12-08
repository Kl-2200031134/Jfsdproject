<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>LMS</title>
    <style>
        /* General page styling */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f7fb;
        }

        /* Heading Styling */
        h2 {
            color: #3b5998;
            text-align: center;
            font-size: 2.5em;
            margin-top: 20px;
        }

        /* Navbar container */
        nav {
            background-color: #0056b3;
            padding: 15px;
            text-align: center;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            position: relative;
            bottom: 0;
            width: 100%;
        }

        /* Navbar links */
        nav a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
            font-size: 1.2em;
            padding: 10px 15px;
            border-radius: 5px;
            display: inline-block;
            transition: background-color 0.3s ease, color 0.3s ease;
        }

        /* Navbar links on hover */
        nav a:hover {
            background-color: #ffcc00;
            color: #333;
        }
    </style>
</head>
<body>
    <h2>Loan Issuance</h2>
    <!-- Main content can go here -->

    <nav>
        <a href="borrowerhome">Home</a>
        <a href="borrowerprofile">Borrower Profile</a>
        <a href="borrowerlogout">Logout</a>
        <a href="applyloan">Apply Loans</a>
    </nav>
</body>
</html>
