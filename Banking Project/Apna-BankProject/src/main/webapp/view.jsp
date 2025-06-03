<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Test.NewAcBean"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Account Details</title>
<style>
    /* General styling */
    body {
        font-family: Arial, sans-serif;
        background-color: #e0f7fa; /* Light cyan background */
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    
    h1 {
        color: #006064; /* Dark cyan for header */
        margin-top: 20px;
    }
    
    /* Table styling */
    table {
        width: 60%;
        max-width: 500px;
        border-collapse: collapse;
        margin-top: 20px;
        background-color: #ffffff;
        border: 2px solid #004d40; /* Dark cyan border */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    
    td {
        padding: 12px;
        border-bottom: 1px solid #ddd;
        font-size: 1rem;
        color: #004d40; /* Dark cyan for text */
    }
    
    tr:nth-child(even) {
        background-color: #f1f8e9; /* Light green for even rows */
    }
    
    tr:last-child td {
        border-bottom: none;
    }
    
    /* Button and link styling */
    .nav-links {
        margin-top: 20px;
        display: flex;
        gap: 10px;
    }
    
    .nav-links a {
        text-decoration: none;
        padding: 10px 20px;
        background-color: #004d40; /* Dark cyan background */
        color: #ffffff; /* White text */
        border-radius: 4px;
        font-weight: bold;
        transition: 0.3s ease;
    }
    
    .nav-links a:hover {
        background-color: #00796b; /* Slightly lighter cyan on hover */
        transform: scale(1.05);
    }

    /* Animation for table display */
    table {
        opacity: 0;
        animation: fadeIn 1.5s forwards;
    }
    
    @keyframes fadeIn {
        from { opacity: 0; }
        to { opacity: 1; }
    }
</style>
</head>
<body>

<h1>User Account Details</h1>

<%
    NewAcBean ub = (NewAcBean) request.getAttribute("ubean");
    String uname = ub.getUname();
    String pword = ub.getPword();
    double amt = ub.getAmount();
    String address = ub.getAddress();
    int acno = ub.getAcno();
    out.print("<h3>Welcome "+ub.getUname()+"</h3>");
%>

<table>
    <tr>
        <td><strong>Account Number:</strong></td>
        <td><%= acno %></td>
    </tr>
    <tr>
        <td><strong>User Name:</strong></td>
        <td><%= uname %></td>
    </tr>
    <tr>
        <td><strong>Password:</strong></td>
        <td><%= pword %></td>
    </tr>
    <tr>
        <td><strong>Amount:</strong></td>
        <td><%= amt %></td>
    </tr>
    <tr>
        <td><strong>Address:</strong></td>
        <td><%= address %></td>
    </tr>
</table>

<div class="nav-links">
    <a href="Balance.html">Check Balance</a>
    <a href="Deposit.html">Deposit</a>
    <a href="Withdraw.html">Withdraw</a>
    <a href="Transfer.html">Transfer</a>
    <a href="Close.html">Close Account</a>
    <a href="About.html">About Us</a>
</div>

</body>
</html>
