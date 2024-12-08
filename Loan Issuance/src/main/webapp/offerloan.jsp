<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Offer Loan</title>
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
            background-color: #ffffff;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 400px;
        }

        h1 {
            text-align: center;
            color: #333333;
            margin-bottom: 20px;
        }

        label {
            font-size: 14px;
            color: #555555;
            font-weight: bold;
        }

        input[type="number"],
        select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        input[type="submit"] {
            width: 100%;
            background-color: #007bff;
            color: white;
            padding: 10px;
            font-size: 16px;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .back-link {
            display: block;
            text-align: center;
            margin-top: 15px;
            text-decoration: none;
            color: #007bff;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Offer a Loan</h1>
        <form action="offerloan" method="POST">
            <label for="amount">Loan Amount:</label>
            <input type="number" id="amount" name="amount" required>

            <label for="rate">Interest Rate (%):</label>
            <input type="number" id="rate" name="rate" required>

            <label for="tenure">Tenure (in months):</label>
            <input type="number" id="tenure" name="tenure" required>

            <label for="interestType">Interest Type:</label>
            <select id="interestType" name="interestType">
                <option value="simple">Simple Interest</option>
                <option value="compound">Compound Interest</option>
            </select>

            <input type="submit" value="Offer Loan">
        </form>
        <a href="lenderdashboard" class="back-link">Back to Dashboard</a>
    </div>
</body>
</html>
