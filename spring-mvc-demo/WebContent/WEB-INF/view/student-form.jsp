<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName" />
		<br><br>
		Last name: <form:input path="lastName" />
		<br><br>
		
		Country:
		<form:select path="country">
			<form:options items="${student.countryOptions }" />
		</form:select>
		
		<br><br>
		
		Programming Language:
		<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguages }" />
		
		<br><br>
		
		<form:checkboxes path="operatingSystem" items="${student.operatingSystems }" />
		
		<br><br>
		
		<button type="submit">Submit</button>
	</form:form>
	
</body>
</html>