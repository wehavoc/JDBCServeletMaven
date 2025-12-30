<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Management</title>

<style>
body {
    margin: 0;
    font-family: Arial, Helvetica, sans-serif;
    background: linear-gradient(135deg, #667eea, #764ba2);
    min-height: 100vh;
}

/* Navbar */
.navbar {
    display: flex;
    justify-content: flex-end;
    background-color: rgba(255, 255, 255, 0.1);
    backdrop-filter: blur(12px);
    padding: 15px 30px;
    border-bottom: 1px solid rgba(255, 255, 255, 0.3);
}

.navbar a {
    color: #fff;
    text-decoration: none;
    margin-left: 20px;
    font-weight: bold;
    transition: 0.3s;
}

.navbar a:hover {
    opacity: 0.8;
}

/* Main content */
.glass-container {
    width: 400px;
    padding: 40px;
    margin: 100px auto 0;
    border-radius: 15px;
    background: rgba(255, 255, 255, 0.2);
    backdrop-filter: blur(12px);
    -webkit-backdrop-filter: blur(12px);
    box-shadow: 0 8px 32px rgba(0, 0, 0, 0.25);
    border: 1px solid rgba(255, 255, 255, 0.3);
    color: #fff;
    text-align: center;
}

.glass-container h1 {
    margin-bottom: 30px;
}

.button {
    display: block;
    width: 80%;
    margin: 15px auto;
    padding: 12px;
    font-size: 16px;
    border-radius: 8px;
    text-decoration: none;
    color: white;
    font-weight: bold;
    transition: 0.3s ease;
}

.view-btn {
    background-color: #4b6cb7;
}

.register-btn {
    background-color: #667eea;
}

.update-btn {
    background-color: #764ba2;
}

.button:hover {
    opacity: 0.85;
}
</style>
</head>
<body>

<!-- Navbar -->
<div class="navbar">
    <a href="product-management.jsp">Home</a>
    <a href="logout">Logout</a>
</div>

<div class="glass-container">
    <h1>Product Management</h1>
    <a href="view-products.jsp" class="button view-btn">View Products</a>
    <a href="product-register.jsp" class="button register-btn">Register Product</a>
    <a href="view-products.jsp" class="button update-btn">Update Product</a>
</div>

</body>
</html>
