<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hcl_jdbc_and_servlet_crud_project.dto.Product"%>
<%@ page import="com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Products</title>

<style>
body {
	margin: 0;
	min-height: 100vh;
	font-family: Arial, Helvetica, sans-serif;
	background: linear-gradient(135deg, #667eea, #764ba2);
	display: flex;
	justify-content: center;
	align-items: flex-start;
	padding-top: 40px;
}

.glass-container {
	width: 90%;
	max-width: 1000px;
	padding: 15px 25px 25px 25px;
	border-radius: 15px;
	background: rgba(255, 255, 255, 0.2);
	backdrop-filter: blur(12px);
	-webkit-backdrop-filter: blur(12px);
	box-shadow: 0 8px 32px rgba(0, 0, 0, 0.25);
	border: 1px solid rgba(255, 255, 255, 0.3);
	color: #fff;
}

h1 {
	text-align: center;
	margin-bottom: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
	background: rgba(255, 255, 255, 0.85);
	color: #333;
	border-radius: 10px;
	overflow: hidden;
}

thead {
	background: #4b6cb7;
	color: #fff;
}

th, td {
	padding: 10px 12px;
	text-align: left;
}

tr:nth-child(even) {
	background-color: #f2f6ff;
}

tr:hover {
	background-color: #e3e9ff;
}

th {
	font-weight: bold;
}

a {
	text-decoration: none;
	padding: 5px 10px;
	border-radius: 5px;
	font-size: 14px;
}

.edit-btn {
	background-color: #2196F3;
	color: white;
}

.delete-btn {
	background-color: #f44336;
	color: white;
}

.edit-btn:hover {
	background-color: #1976D2;
}

.delete-btn:hover {
	background-color: #d32f2f;
}

/* Toast styles */
#toast {
	visibility: hidden;
	min-width: 250px;
	margin-left: -125px;
	background-color: #333;
	color: #fff;
	text-align: center;
	border-radius: 4px;
	padding: 16px;
	position: fixed;
	z-index: 1000;
	left: 50%;
	top: 20px;
	font-size: 16px;
}

#toast.show {
	visibility: visible;
	animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

@keyframes fadein {
	from {top: 0; opacity: 0;}
	to {top: 20px; opacity: 1;}
}

@keyframes fadeout {
	from {top: 20px; opacity: 1;}
	to {top: 0; opacity: 0;}
}
</style>
</head>

<body>

<%
	// Get toast message from session if present
	String msg = (String) session.getAttribute("msg");
	String msgType = (String) session.getAttribute("msgType"); // "success" or "error"
	if (msg != null) {
		session.removeAttribute("msg");
		session.removeAttribute("msgType");
%>
	<div id="toast" style="background-color: <%= "success".equals(msgType) ? "#4CAF50" : "#f44336" %>;">
		<%= msg %>
	</div>
<%
	}
%>

<div class="glass-container">
	<h1>All Products</h1>

	<%
		List<Product> products = new ProductDao().getAllProductDetailsDao();
	%>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Color</th>
				<th>Price</th>
				<th>MFD</th>
				<th>EXPD</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>

		<tbody>
			<%
			for (Product product : products) {
			%>
			<tr>
				<td><%=product.getId()%></td>
				<td><%=product.getName()%></td>
				<td><%=product.getColor()%></td>
				<td><%=product.getPrice()%></td>
				<td><%=product.getMfd()%></td>
				<td><%=product.getExpd()%></td>
				<td><a class="edit-btn"
					href="update-product.jsp?id=<%=product.getId()%>">
						Edit </a></td>
				<td><a class="delete-btn"
					href="delete?id=<%=product.getId()%>">
						Delete </a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</div>

<script>
	window.onload = function() {
		var toast = document.getElementById("toast");
		if (toast) {
			toast.className = "show";
			setTimeout(function(){ toast.className = toast.className.replace("show", ""); }, 3000);
		}
	};
</script>

</body>
</html>
