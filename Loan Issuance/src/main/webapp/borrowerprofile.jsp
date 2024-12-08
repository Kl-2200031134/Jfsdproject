<%@page import="com.klef.sdp.springboot.model.Borrower" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Borrower b = (Borrower)session.getAttribute("borrower");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>
<link rel="stylesheet" type="text/css" href="style.css">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        margin: 0;
        padding: 0;
    }
    .container {
        max-width: 600px;
        margin: 50px auto;
        background: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    h3 {
        text-align: center;
        color: #343a40;
    }
    .profile-details {
        font-size: 16px;
        line-height: 1.6;
    }
    .profile-details label {
        font-weight: bold;
        display: inline-block;
        width: 150px;
        color: #495057;
    }
    .navbar {
        background-color: #343a40;
        padding: 10px;
        text-align: center;
    }
    .navbar a {
        color: white;
        text-decoration: none;
        margin: 0 15px;
        font-size: 16px;
    }
    .navbar a:hover {
        color: #f8f9fa;
        text-decoration: underline;
    }
</style>
</head>
<body>
<%@include file="borrowernavbar.jsp" %>
<div class="container">
    <h3>My Profile</h3>
    <div class="profile-details">
        <p><label>ID:</label> <%=b.getId()%></p>
        <p><label>Name:</label> <%=b.getName()%></p>
        <p><label>Gender:</label> <%=b.getGender()%></p>
        <p><label>DOB:</label> <%=b.getDateofbirth()%></p>
        <p><label>Email:</label> <%=b.getEmail()%></p>
        <p><label>Location:</label> <%=b.getLocation()%></p>
        <p><label>Contact:</label> <%=b.getContact()%></p>
    </div>
</div>
</body>
</html>
