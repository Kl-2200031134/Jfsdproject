<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Request Loan</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2 align="center">Request Loan</h2>
    <h3>Select a loan offer:</h3>

    <%-- Assuming you have a list of loan offers in a variable loanOffers --%>
    <form action="requestLoan" method="post">
        <label for="loanOfferId">Choose Loan Offer:</label><br>
        <select id="loanOfferId" name="loanOfferId">
            <%-- Loop through loanOffers and display available offers --%>
            <c:forEach var="offer" items="${loanOffers}">
                <option value="${offer.id}">${offer.amount} at ${offer.interestRate}% for ${offer.repaymentTerm} months</option>
            </c:forEach>
        </select><br><br>

        <input type="submit" value="Request Loan">
    </form>
</body>
</html>
