<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>HOME</title>
    <style>
        /* Page background and fonts */
        body {
            font-family: 'Roboto', Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(120deg, #f0f4f9, #cfe2f3);
            color: #444;
        }

        /* Main content box */
        .home-content {
            max-width: 960px;
            margin: 50px auto;
            padding: 40px;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 8px 30px rgba(0, 0, 0, 0.2);
            text-align: center;
            border: 1px solid #e0e7ed;
        }

        /* Header styling */
        h1 {
            color: #2d5fa7;
            font-size: 2.8em;
            margin-bottom: 20px;
        }

        h2 {
            color: #3b5998;
            font-size: 1.8em;
            margin-top: 30px;
            margin-bottom: 20px;
            font-weight: 600;
            text-transform: uppercase;
        }

        /* Paragraphs */
        p {
            font-size: 1.2em;
            line-height: 1.8;
            color: #555;
            margin-bottom: 25px;
        }

        /* Unordered list styling */
        ul {
            list-style: none;
            padding: 0;
            margin: 0 auto;
            max-width: 700px;
            text-align: left;
        }

        li {
            font-size: 1.1em;
            padding: 12px 10px;
            margin-bottom: 8px;
            border-bottom: 1px solid #ddd;
            color: #555;
            transition: background-color 0.3s ease;
        }

        li:hover {
            background-color: #f7faff;
        }

        li:last-child {
            border-bottom: none;
        }

        /* Call-to-action button */
        .button {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 20px;
            font-size: 1.1em;
            font-weight: bold;
            text-transform: uppercase;
            color: #fff;
            background-color: #3b5998;
            border: none;
            border-radius: 6px;
            text-decoration: none;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        .button:hover {
            background-color: #29487d;
            box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>
    <%@ include file="mainnavbar.jsp" %>

    <div class="home-content">
        <h1>Welcome to the Loan Issuance System</h1>
        <p>Our Loan Issuance System is designed to streamline the loan application and management process for borrowers, lenders, and financial analysts. This system offers a secure and efficient platform to handle loan applications, track repayments, calculate interest, and manage financial records.</p>

        <h2>Features</h2>
        <ul>
            <li><strong>Loan Application:</strong> Simple and user-friendly interface for applying for loans.</li>
            <li><strong>Loan Tracking:</strong> Easily track loan statuses, due dates, and payment history.</li>
            <li><strong>Interest Calculation:</strong> Automated calculation of interest based on loan type and repayment schedule.</li>
            <li><strong>Role-Based Access:</strong> Separate portals for Admin, Lender, Borrower, and Financial Analyst to ensure a secure and personalized experience.</li>
            <li><strong>Reports and Analytics:</strong> Generate detailed reports and analytics for effective financial decision-making.</li>
        </ul>

        <h2>Getting Started</h2>
        <p>To begin, please log in to your account or create a new account if you are a first-time user. Our system is here to make managing your financial transactions easier and more efficient.</p>

        <a href="login.jsp" class="button">Get Started</a>
    </div>
</body>
</html>
