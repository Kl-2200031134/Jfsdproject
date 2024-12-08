<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Loans</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f0f8ff;
        }

        h1 {
            text-align: center;
            color: #333333;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        table th, table td {
            padding: 12px 15px;
            text-align: center;
            border: 1px solid #ddd;
        }

        table th {
            background-color: #007bff;
            color: white;
            font-weight: bold;
        }

        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        table tr:hover {
            background-color: #f1f1f1;
        }

        .actions a {
            text-decoration: none;
            color: white;
            font-weight: bold;
            padding: 5px 10px;
            border-radius: 4px;
            margin: 0 5px;
        }

        .actions a.approve {
            background-color: #28a745;
        }

        .actions a.reject {
            background-color: #dc3545;
        }

        .actions a:hover {
            opacity: 0.8;
        }

        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Your Loans</h1>
    <table>
        <thead>
            <tr>
                <th>Loan Amount</th>
                <th>Interest Rate (%)</th>
                <th>Tenure (months)</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="loan" items="${loans}">
                <tr>
                    <td>${loan.loanAmount}</td>
                    <td>${loan.interestRate}</td>
                    <td>${loan.loanTerm}</td>
                    <td>${loan.loanStatus}</td>
                    <td class="actions">
                        <!-- Approve Loan form -->
                        <form method="post" action="${pageContext.request.contextPath}/approveLoan">
                            <input type="hidden" name="loanId" value="${loan.id}" />
                            <button type="submit" class="approve">Approve</button>
                        </form>

                        <!-- Reject Loan form -->
                        <form method="post" action="${pageContext.request.contextPath}/rejectLoan">
                            <input type="hidden" name="loanId" value="${loan.id}" />
                            <button type="submit" class="reject">Reject</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="lenderdashboard" class="back-link">Back to Dashboard</a>
</body>
</html>
