<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>

<style>
body {
    margin: 0;
    min-height: 100vh;
    font-family: Arial, Helvetica, sans-serif;
    background: linear-gradient(135deg, #667eea, #764ba2);
    display: flex;
    justify-content: center;
    align-items: center;
}

.glass-container {
    width: 400px;
    padding: 40px;
    border-radius: 15px;
    background: rgba(255, 255, 255, 0.2);
    backdrop-filter: blur(12px);
    -webkit-backdrop-filter: blur(12px);
    box-shadow: 0 8px 32px rgba(0, 0, 0, 0.25);
    border: 1px solid rgba(255, 255, 255, 0.3);
    color: #fff;
    text-align: center;
}

.glass-container h2 {
    margin-bottom: 25px;
}

.input-field {
    width: 100%;
    padding: 12px;
    margin: 10px 0;
    border-radius: 8px;
    border: none;
    outline: none;
    font-size: 15px;
}

.register-btn {
    width: 100%;
    padding: 12px;
    margin-top: 20px;
    font-size: 16px;
    border-radius: 8px;
    border: none;
    cursor: pointer;
    font-weight: bold;
    color: white;
    background-color: #667eea;
    transition: 0.3s ease;
}

.register-btn:hover {
    opacity: 0.85;
}

.login-link {
    margin-top: 20px;
    display: block;
    color: #fff;
    text-decoration: none;
    font-size: 14px;
}

.login-link:hover {
    text-decoration: underline;
}

/* Toast Styles */
.toast {
    position: fixed;
    top: 20px;
    right: 20px;
    padding: 15px 25px;
    border-radius: 8px;
    font-weight: bold;
    color: white;
    z-index: 1000;
    animation: slideIn 0.5s ease;
}

.toast.success {
    background-color: #4CAF50;
}

.toast.error {
    background-color: #E74C3C;
}

@keyframes slideIn {
    from {
        transform: translateX(100%);
        opacity: 0;
    }
    to {
        transform: translateX(0);
        opacity: 1;
    }
}
</style>
</head>

<body>

<div class="glass-container">
    <h2>User Sign Up</h2>

    <form action="register" method="post">
        <input type="number" name="id" class="input-field"
               placeholder="Enter User ID" required>

        <input type="text" name="name" class="input-field"
               placeholder="Enter Name" required>

        <input type="email" name="email" class="input-field"
               placeholder="Enter Email" required>

        <input type="password" name="password" class="input-field"
               placeholder="Enter Password" required>

        <button type="submit" class="register-btn">Sign Up</button>
    </form>

    <a href="loginUser.jsp" class="login-link">
        Already have an account? Login
    </a>
</div>

<%
    String status = request.getParameter("status");
%>

<% if ("success".equals(status)) { %>
    <div class="toast success">
        Registration successful!
    </div>
    <script>
        setTimeout(() => {
            window.location.href = "loginUser.jsp";
        }, 2000);
    </script>
<% } %>

<% if ("error".equals(status)) { %>
    <div class="toast error">
        Registration failed! Please try again.
    </div>
    <script>
        setTimeout(() => {
            document.querySelector('.toast').style.display = 'none';
        }, 3000);
    </script>
<% } %>

<% if ("emailExists".equals(status)) { %>
    <div class="toast error">
        Email already exists!
    </div>
    <script>
        setTimeout(() => {
            document.querySelector('.toast').style.display = 'none';
        }, 3000);
    </script>
<% } %>

</body>
</html>
