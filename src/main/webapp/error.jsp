<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>

    <h2 style="color:red;">Something went wrong ❌</h2>

    <%
        String errorMsg = (String) request.getAttribute("error");
        if (errorMsg == null) {
            errorMsg = "Unexpected error occurred. Please try again.";
        }
    %>

    <p><%= errorMsg %></p>

    <br>
    <a href="product-register.jsp">Go Back</a>

</body>
</html>
