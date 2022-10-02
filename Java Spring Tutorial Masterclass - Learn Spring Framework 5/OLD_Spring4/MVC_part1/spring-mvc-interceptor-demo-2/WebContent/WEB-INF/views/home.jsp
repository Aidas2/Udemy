<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Organization home page</title>
</head>
<body>

	<h2 align="center" style="color:#DF0101">Welcome! <c:out value="${greeting}"></c:out></h2>
	<hr/>
	<h1 align="center">Organization Details</h1>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<div style="text-align:center">
		<a href="${contextPath}/location" style="font-size: 30px">Click here to get organization details for your location.</a>
	</div>

</body>
</html>