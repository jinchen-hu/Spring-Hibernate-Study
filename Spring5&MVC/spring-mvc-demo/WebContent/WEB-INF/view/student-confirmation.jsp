<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student confirmation</title>
</head>
<body>
	
	The student is confirmed : ${student.firstName } ${student.lastName }
	<br><br>
	Country: ${student.country }
	<br><br>
	Language: ${student.favoriteLanguage }
	
	<br><br>
	OS: ${student.operatingSystem }
	<ul>
		<c:forEach var="temp" items="${student.operatingSystem }" >
		<li> ${temp } </li>
		</c:forEach>
	</ul>
</body>
</html>