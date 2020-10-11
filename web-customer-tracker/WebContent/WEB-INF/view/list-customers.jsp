<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customers</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css "> 
</head>
<body>

	<div id="wrappe">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<button type="button" onclick="window.location.href='showFormForAdd'; return false;" class="add-button">Add Customer</button>
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="customer" items="${customers}">
					<tr>
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${customer.id }"/>
						</c:url>
						
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${customer.id }" />
						</c:url>
					
						<td>${customer.firstName }</td>
						<td>${customer.lastName }</td>
						<td>${customer.email }</td>
						<td><a href="${updateLink }">Update</a> | <a href="${deleteLink }" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		
		</div>
	</div>

</body>
</html>