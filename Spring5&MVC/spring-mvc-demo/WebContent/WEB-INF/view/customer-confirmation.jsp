<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Confirmation</title>
</head>
<body>
	Customer name : ${customer.firstName } ${customer.lastName } 
	<br><br>
	Free passes: ${customer.freePasses }
	<br><br>
	Postal code: ${customer.postalCode }
	<br><br>
	Course code: ${customer.courseCode }
	<br><br>
</body>
</html>