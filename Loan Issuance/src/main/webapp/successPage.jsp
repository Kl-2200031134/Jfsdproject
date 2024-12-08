<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success</title>
</head>
<body>
    <h1>Loan Application Successful</h1>
    <p>
        <!-- Display the success message using JSTL -->
        <c:if test="${not empty message}">
            ${message}  <!-- This will show the success message -->
        </c:if>
        <c:if test="${not empty error}">
            ${error}  <!-- This will show any error message if there was an error -->
        </c:if>
    </p>
    
    <!-- Optionally provide a link to the home page -->
    <a href="<c:url value='/borrowerhome'/>">Go to Home</a>
</body>
</html>
