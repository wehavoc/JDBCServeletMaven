<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Registration</title>
</head>
<body>
	<h1>Product Registration</h1>
	<form action="product-register" method="post">
		<label>Product Id</label>
		<input type="text" placeholder="enter Product id" name="id" required><br>
		<label>Product name</label>
		<input type="text" placeholder="enter Product name" name="name" required><br>
		<label>Product Color</label>
		<input type="text" placeholder="enter Product color" name="color" required><br>
		<label>Product Price</label>
		<input type="text" placeholder="enter Product price" name="price" required><br>
		<label>Product MFD</label>
		<input type="date" name="mfd" required><br>
		<label>Product EXPD</label>
		<input type="date" name="expd" required><br>
		<input type="submit" value="register">
	</form>
	
</body>
</html>