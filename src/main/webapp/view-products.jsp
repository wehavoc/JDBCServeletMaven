<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.hcl_jdbc_and_servlet_crud_project.dto.Product"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Products</title>
</head>
<body>

	<h1>All Products are here</h1>

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Color</th>
			<th>Price</th>
			<th>MFD</th>
			<th>EXPD</th>
		</tr>

		<%
		List<Product> products = (List<Product>) request.getAttribute("products");

		if (products != null) {
			System.out.println("Number of products: " + products.size());
			for (Product p : products) {
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getName()%></td>
			<td><%=p.getColor()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getMfd()%></td>
			<td><%=p.getExpd()%></td>
		</tr>
		<%
		}
		}
		%>

	</table>

</body>
</html>
