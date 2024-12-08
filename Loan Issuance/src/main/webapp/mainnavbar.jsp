<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>JFSD</title>
    <style>
        /* Styling for navbar */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f7fb;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-top: 20px;
        }

        nav {
            background-color: #0056b3; /* Navbar background */
            padding: 10px 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        nav a {
            color: white; /* Link color */
            text-decoration: none;
            margin-right: 20px;
            font-size: 1.1em;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        nav a:hover {
            color: #ffcc00; /* Hover effect */
        }

        nav a.active {
            color: #ffcc00; /* Active link */
            text-decoration: underline;
        }

        nav {
            display: flex;
            justify-content: center;
        }

        /* Adjust navbar links for smaller screens */
        @media (max-width: 768px) {
            nav {
                flex-direction: column;
                align-items: center;
            }

            nav a {
                margin: 10px 0;
            }
        }
    </style>
</head>
<body>
    <h2>Loan Issuance</h2>
    <nav>
        <a href="/">Home</a>
        <a href="borrowerreg">Borrower Registration</a>
        <a href="borrowerlogin">Borrower Login</a>
        <a href="adminlogin">Admin Login</a>
        <a href="lenderregister">Lender Register</a> <!-- Added Lender Register -->
        <a href="lenderlogin">Lender Login</a> <!-- Added Lender Login -->
        <a href="financialanalysis">Financial Analysis</a>
    </nav>
</body>
</html>
