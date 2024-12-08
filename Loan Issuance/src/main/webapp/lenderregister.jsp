<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lender Registration Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            padding: 20px;
        }
        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h3 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            font-weight: bold;
        }
        .form-control {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 5px;
        }
        .btn {
            padding: 10px 20px;
            border-radius: 5px;
            margin-top: 10px;
        }
        .btn-success {
            background-color: #28a745;
            color: white;
        }
        .btn-success:hover {
            background-color: #218838;
        }
        .form-control-input {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <%@include file="mainnavbar.jsp" %>
    <h3>Lender Registration Form</h3>
    <div class="container">
        <form method="post" action="insertlender">
            <label>Enter Name</label>
            <input type="text" class="form-control" name="lname" required />
            <br/>
            
            <label>Select Gender</label>
            <input type="radio" name="lgender" class="form-control-input" value="Male" required /> Male
            <input type="radio" name="lgender" class="form-control-input" value="Female" required /> Female
            <input type="radio" name="lgender" class="form-control-input" value="Others" required /> Others
            <br/>
            
            <label>Select Date of Birth</label>
            <input type="date" name="ldob" class="form-control" required />
            <br/>
            
            <label>Enter Email ID</label>
            <input type="email" name="lemail" class="form-control" required />
            <br/>
            
            <label>Enter Password</label>
            <input type="password" name="lpwd" class="form-control" required />
            <br/>
            
            <label>Enter Location</label>
            <input type="text" name="llocation" class="form-control" required />
            <br/>
            
            <label>Enter Contact</label>
            <input type="number" name="lcontact" class="form-control" required />
            <br/>
            
            <label>Enter Default Interest Rate</label>
            <input type="number" name="default_interest_rate" class="form-control" step="0.01" required />
            <br/>
            
            <!-- Loan Amount Field -->
            <label>Enter Loan Amount</label>
            <input type="number" name="loanAmount" class="form-control" step="0.01" required />
            <br/>

            <!-- Loan Type Field -->
            <label>Select Loan Type</label>
            <select name="loanType" class="form-control" required>
                <option value="Personal">Personal</option>
                <option value="Home">Home</option>
                <option value="Car">Car</option>
                <option value="Education">Education</option>
                <!-- Add more loan types as needed -->
            </select>
            <br/>
            
            <input type="submit" value="Register" class="btn btn-success" />
            <input type="reset" value="Clear" class="btn btn-success" />
        </form>
    </div>
</body>
</html>
