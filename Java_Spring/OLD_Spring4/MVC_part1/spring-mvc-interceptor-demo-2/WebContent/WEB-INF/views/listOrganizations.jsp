 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List organizations</title>
<style>
	table {
		border-collapse: collapse;
	}
	
	table, th, td {
		padding: 5px;
		margin: 10px;
		font-size: 20px;
		border: 1px solid black
	}
</style>
</head>
<body>
	<h2 align="center" style="color: #DF0101">
		<c:out value="${greeting}"></c:out>
	</h2>
	<hr/>
	<div align="center">
		<table>
			<caption style="font-size: 40px; margin-bottom: 10px">
				<c:out value="${locationName}"/> Organization Directory
			</caption>
			<tr>
				<th>Name</th>
				<th>Year</th>
				<th>Zip</th>
				<th>Emp Count</th>
				<th>Slogan</th>
			</tr>
			<c:forEach var="row" items="${orgList}">
				<tr>
					<td><c:out value="${row.companyName}"/></td>
					<td><c:out value="${row.yearOfIncorporation}"/></td>
					<td><c:out value="${row.postalCode}"/></td>
					<td><c:out value="${row.employeeCount}"/></td>
					<td><c:out value="${row.slogan}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>










