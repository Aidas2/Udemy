<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List organizations using a Service</title>
</head>
<body>
	<h1>Listing organizations using a Service</h1>
	<c:forEach var="row" items="${orgList}">
		Name: ${row.companyName} <br/>
		Year: ${row.yearOfIncorporation} <br/>
		Zip: ${row.postalCode} <br/>
		Emp Count: ${row.employeeCount} <br/>
		Slogan: ${row.slogan} <br/><br/>
	</c:forEach>
</body>
</html>