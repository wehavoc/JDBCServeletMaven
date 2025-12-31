<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="com.hcl_jdbc_and_servlet_crud_project.dto.Product"%>
<%@page import="com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Product</title>
<style>
body {
	margin: 0;
	min-height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	font-family: Arial, Helvetica, sans-serif;
	background: linear-gradient(135deg, #667eea, #764ba2);
}

.glass-form {
	width: 350px;
	padding: 30px;
	border-radius: 15px;
	background: rgba(255, 255, 255, 0.2);
	backdrop-filter: blur(12px);
	-webkit-backdrop-filter: blur(12px);
	box-shadow: 0 8px 32px rgba(0, 0, 0, 0.25);
	border: 1px solid rgba(255, 255, 255, 0.3);
	color: #fff;
}

.glass-form h1 {
	text-align: center;
	margin-bottom: 20px;
}

label {
	font-size: 14px;
	margin-top: 10px;
	display: block;
}

input {
	width: 100%;
	padding: 8px 10px;
	margin-top: 5px;
	border-radius: 6px;
	border: none;
	outline: none;
	font-size: 14px;
}

input[type="text"], input[type="date"] {
	background: rgba(255, 255, 255, 0.8);
}

input[type="submit"] {
	margin-top: 20px;
	background-color: #4CAF50;
	color: #fff;
	font-weight: bold;
	cursor: pointer;
	transition: background-color 0.3s ease, opacity 0.3s ease;
}

input[type="submit"]:disabled {
	background-color: #9e9e9e;
	cursor: not-allowed;
	opacity: 0.6;
}

/* Toast styles */
#toast {
	position: fixed;
	top: 20px;
	right: 20px;
	background-color: #333;
	color: white;
	padding: 15px 25px;
	border-radius: 5px;
	opacity: 0.9;
	z-index: 9999;
	font-weight: bold;
}

#toast.success {
	background-color: #4CAF50;
}

#toast.error {
	background-color: #f44336;
}
</style>
</head>
<body>

	<%
		HttpSession httpsession = request.getSession();
		String userEmail = (String) httpsession.getAttribute("loggedInUser");
		if (userEmail != null) {

	
		// Get product by id passed in query string
		int productId = Integer.parseInt(request.getParameter("id"));
		Product product = new ProductDao().DisplayProductByIdDao(productId);
	%>

	<div class="glass-form">
		<h1>Update Product Form</h1>

		<form action="update-product" method="post" id="updateProductForm">
			<label>Product Id</label> <input type="text" name="id"
				value="<%=product.getId()%>" readonly> <label>Product
				Name</label> <input type="text" name="name" value="<%=product.getName()%>"
				required> <label>Product Color</label> <input type="text"
				name="color" value="<%=product.getColor()%>" required> <label>Product
				Price</label> <input type="text" name="price"
				value="<%=product.getPrice()%>" required> <label>Product
				MFD</label> <input type="date" name="mfd" value="<%=product.getMfd()%>"
				required> <label>Product EXPD</label> <input type="date"
				name="expd" value="<%=product.getExpd()%>" required> <input
				type="submit" id="updateBtn" value="Update" disabled>
		</form>
	</div>
	
	<%
	} else {
	%>

	<%
	response.sendRedirect("loginUser.jsp");
	%>

	<%
	}
	%>

	<script>
document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("updateProductForm");
    const submitBtn = document.getElementById("updateBtn");
    const inputs = form.querySelectorAll("input[type='text'], input[type='date']");

    function checkInputs() {
        let allFilled = true;
        inputs.forEach(input => { if (!input.value) allFilled = false; });
        submitBtn.disabled = !allFilled;
    }

    inputs.forEach(input => {
        input.addEventListener("input", checkInputs);
        input.addEventListener("change", checkInputs);
    });

    checkInputs(); // initial check
});
</script>

</body>
</html>
