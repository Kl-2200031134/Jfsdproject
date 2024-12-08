<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Apply for Loan</title>
    <style>
        /* General Styles */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        .form-container {
            max-width: 700px;
            margin: 0 auto;
            background-color: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        /* Form Elements */
        .form-container label {
            display: block;
            font-weight: bold;
            margin-bottom: 8px;
            color: #555;
        }

        .form-container input,
        .form-container select,
        .form-container button {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
        }

        .form-container input[type="number"] {
            -moz-appearance: textfield;
        }

        .form-container input:focus,
        .form-container select:focus {
            border-color: #007bff;
            outline: none;
        }

        .form-container button {
            background-color: #007bff;
            color: white;
            border: none;
            font-size: 18px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form-container button:hover {
            background-color: #0056b3;
        }

        /* Error and Success Messages */
        .error, .success {
            text-align: center;
            padding: 12px;
            margin: 20px 0;
            border-radius: 5px;
            font-weight: bold;
            box-sizing: border-box;
        }

        .error {
            background-color: #f8d7da;
            color: #721c24;
        }

        .success {
            background-color: #d4edda;
            color: #155724;
        }

        /* Back Link */
        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
            transition: text-decoration 0.3s ease;
        }

        .back-link:hover {
            text-decoration: underline;
        }

        /* Responsiveness */
        @media (max-width: 768px) {
            .form-container {
                padding: 15px;
                margin: 10px;
            }

            .form-container label, 
            .form-container input, 
            .form-container select,
            .form-container button {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>

    <h2>Apply for Loan</h2>

    <!-- Display error or success messages -->
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty message}">
        <div class="success">${message}</div>
    </c:if>

    <!-- Loan Application Form -->
    <div class="form-container">
        <form action="${pageContext.request.contextPath}/applyloan" method="post">
            <label for="loanAmount">Loan Amount:</label>
            <input type="number" step="0.01" name="loanAmount" required />

            <label for="interestRate">Interest Rate (%):</label>
            <input type="number" step="0.01" name="interestRate" required />

            <label for="loanTerm">Loan Term (in months):</label>
            <input type="number" name="loanTerm" required />

            <label for="interestType">Interest Type:</label>
            <select name="interestType" required>
                <option value="Fixed">Fixed</option>
                <option value="Variable">Variable</option>
            </select>

            <label for="startDate">Start Date:</label>
            <input type="date" name="startDate" required />

            <label for="endDate">End Date:</label>
            <input type="date" name="endDate" required />

            <button type="submit">Apply</button>
        </form>

        <a href="${pageContext.request.contextPath}/borrowerhome" class="back-link">Back to Dashboard</a>
    </div>

</body>
</html>
