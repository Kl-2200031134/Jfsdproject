<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lender Login</title>
</head>
<body>
    <%@ include file="mainnavbar.jsp" %>
    <h4 align="center" style="color:red">
        <c:out value="${message}"></c:out><br/>
    </h4>
    <h3 align="center">Lender Login Form</h3>
    <div class="container">
        <form method="post" action="checklenderlogin">

            <label>Enter Email</label>
            <input type="text" class="form-control" name="lemail" required />
            <br/>

            <label>Enter Password</label>
            <input type="password" name="lpwd" class="form-control" required />
            <br/>

            <input type="submit" value="Login" class="btn btn-success"/>
            <input type="reset" value="Clear" class="btn btn-success"/>
        </form>
    </div>
</body>
</html>
