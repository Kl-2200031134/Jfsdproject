<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Loan Offer Success</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f8ff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            text-align: center;
            background-color: #ffffff;
            padding: 30px 50px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        h1 {
            color: #28a745;
        }

        p {
            color: #333;
            font-size: 16px;
        }

        a {
            text-decoration: none;
            color: #ffffff;
            background-color: #007bff;
            padding: 10px 20px;
            border-radius: 5px;
            font-weight: bold;
            transition: background-color 0.3s, box-shadow 0.3s;
        }

        a:hover {
            background-color: #0056b3;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Loan Offered Successfully!</h1>
        <p>Your loan has been successfully created and is now available for borrowers to apply.</p>
        <a href="lenderdashboard">Back to Dashboard</a>
    </div>
</body>
</html>
