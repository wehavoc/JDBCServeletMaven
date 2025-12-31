<%@page import="com.hcl_jdbc_and_servlet_crud_project.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Registration</title>
<style>
body {
	margin: 0;
	min-height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	font-family: Arial;
	background: linear-gradient(135deg, #667eea, #764ba2);
}

.glass-form {
	width: 350px;
	padding: 30px;
	border-radius: 15px;
	background: rgba(255, 255, 255, 0.2);
	backdrop-filter: blur(12px);
	box-shadow: 0 8px 32px rgba(0, 0, 0, 0.25);
	color: #fff;
}

.glass-form h1 {
	text-align: center;
	margin-bottom: 20px;
}

label {
	display: block;
	margin-top: 10px;
}

input {
	width: 100%;
	padding: 8px;
	margin-top: 5px;
	border-radius: 6px;
	border: none;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	font-weight: bold;
	cursor: pointer;
	transition: background-color 0.3s ease, opacity 0.3s ease;
	margin-top: 20px;
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
		
		    ProductDao dao = new ProductDao();
		    int nextId = dao.getMaxProductId() + 1; // get next ID
	%>

	<div class="glass-form">
		<h1>Product Registration</h1>

		<form action="product-register" method="post" id="productForm">

			<label>Product Id</label> <input type="text" name="id"
				value="<%= nextId %>" readonly> <label>Product Name</label>
			<input type="text" name="name" required> <label>Product
				Color</label> <input type="text" name="color" required> <label>Product
				Price</label> <input type="text" name="price" required> <label>Product
				MFD</label> <input type="date" name="mfd" required> <label>Product
				EXPD</label> <input type="date" name="expd" required> <input
				type="submit" id="submitBtn" value="Register" disabled>
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
    const form = document.getElementById("productForm");
    const submitBtn = document.getElementById("submitBtn");
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
