<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Financial Analysis</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        /* Navbar styling */
        .navbar {
            background-color: #007bff;
            overflow: hidden;
        }

        .navbar a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
        }

        .navbar a:hover {
            background-color: #0056b3;
        }

        /* Content styling */
        .content {
            text-align: center;
            padding: 30px;
        }

        h1 {
            color: #007bff;
        }

        /* Chart container */
        .chart-container {
            width: 50%;  /* Set the width as per requirement */
            margin: 30px auto;
            padding: 20px;
            border: 1px solid #ccc;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

    </style>
</head>
<body>

    <!-- Navbar -->
    <div class="navbar">
        <a href="/">Home</a>
        <a href="borrowerreg">Borrower Registration</a>
        <a href="borrowerlogin">Borrower Login</a>
        <a href="adminlogin">Admin Login</a>
        <a href="lenderregister">Lender Register</a> <!-- Added Lender Register -->
        <a href="lenderlogin">Lender Login</a> <!-- Added Lender Login -->
        <a href="financialanalysis">Financial Analysis</a>
    </div>

    <!-- Main content -->
    <div class="content">
        <h1>Financial Analysis Dashboard</h1>
        <p>Here is the loan status analysis based on the latest data.</p>

        <!-- Chart Section -->
        <div class="chart-container">
            <canvas id="loanStatusChart"></canvas>
        </div>

        <!-- Optional: More content below the chart -->
        <p>More financial data can be shown here.</p>
    </div>

    <script>
        // Prepare the data for the chart
        var loanStatuses = ['Pending', 'Approved', 'Rejected'];  // Define the loan statuses
        var loanStatusCounts = [
            ${pendingCount},   // These values will be dynamically injected from the controller
            ${approvedCount},
            ${rejectedCount}
        ];

        var ctx = document.getElementById('loanStatusChart').getContext('2d');
        var loanStatusChart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: loanStatuses,
                datasets: [{
                    data: loanStatusCounts,
                    backgroundColor: ['#ffcc00', '#28a745', '#dc3545'],
                    hoverOffset: 4
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    tooltip: {
                        callbacks: {
                            label: function(tooltipItem) {
                                return tooltipItem.label + ': ' + tooltipItem.raw;
                            }
                        }
                    }
                }
            }
        });
    </script>

</body>
</html>
