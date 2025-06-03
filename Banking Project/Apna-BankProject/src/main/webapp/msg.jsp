<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Test.DepositeServlet"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Bank Services</title>
<style>
  /* Reset */
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  /* Body Styling */
  body {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg, #8ec5fc, #e0c3fc);
    color: #333;
  }

  /* Message Box */
  .message-box {
    font-size: 1.2rem;
    font-weight: bold;
    color: #333;
    background: #e0f7fa;
    padding: 1rem;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    animation: fadeIn 1.5s ease;
    margin-bottom: 2rem;
    text-align: center;
    width: 90%;
    max-width: 400px;
  }

  /* Navigation Links */
  .nav-links {
    display: flex;
    flex-wrap: wrap;
    gap: 1rem;
    justify-content: center;
    width: 100%;
    max-width: 600px;
  }

  .nav-links a {
    display: inline-block;
    padding: 0.8rem 1.2rem;
    color: #fff;
    background-color: #6200ea;
    text-decoration: none;
    border-radius: 5px;
    font-weight: bold;
    transition: background-color 0.3s ease, transform 0.3s ease;
  }

  /* Hover and Focus Effects */
  .nav-links a:hover {
    background-color: #3700b3;
    transform: scale(1.05);
  }

  .nav-links a:active {
    transform: scale(1);
  }

  /* Fade-in Animation */
  @keyframes fadeIn {
    from {
      opacity: 0;
      transform: translateY(-20px);
    }
    to {
      opacity: 1;
      transform: translateY(0);
    }
  }
</style>
</head>
<body>

<% 
String msg = (String) request.getAttribute("msg");
%>

<div class="message-box">
  <%= msg %>
</div>

<div class="nav-links">
  <a href="WelcomePage.html">HomePage</a>
  <a href="Account.html">Create Account</a>
  <a href="Balance.html">Check Balance</a>
  <a href="Deposit.html">Deposit</a>
  <a href="Withdraw.html">Withdraw</a>
  <a href="Transfer.html">Transfer</a>
  <a href="Close.html">Close Account</a>
  <a href="About.html">About Us</a>
</div>

</body>
</html>
