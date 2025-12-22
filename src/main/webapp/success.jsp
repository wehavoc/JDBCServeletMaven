<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>

    <h2>Product Registered Successfully ✅</h2>

    <%
        com.hcl_jdbc_and_servlet_crud_project.dto.Product product =
                (com.hcl_jdbc_and_servlet_crud_project.dto.Product) request.getAttribute("product");
    %>

    <c:if test="${product != null}">
        <p><b>Product ID:</b> <%= product.getId() %></p>
        <p><b>Name:</b> <%= product.getName() %></p>
        <p><b>Color:</b> <%= product.getColor() %></p>
        <p><b>Price:</b> <%= product.getPrice() %></p>
        <p><b>MFD:</b> <%= product.getMfd() %></p>
        <p><b>EXPD:</b> <%= product.getExpd() %></p>
    </c:if>

    <br>
    <a href="product-register.jsp">Register Another Product</a>
    <a href="view-products.jsp">See All Product</a>

</body>
</html>
