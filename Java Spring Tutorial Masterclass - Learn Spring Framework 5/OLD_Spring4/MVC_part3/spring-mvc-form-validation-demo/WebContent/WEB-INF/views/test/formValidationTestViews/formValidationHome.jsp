<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<spring:url value="/resources/test-main.css" var="testMainCSS" />
	<link href="${testMainCSS}" rel="stylesheet" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Test bed</title>
</head>
<body>
	<div align="center">
		<h1 class="ch1">Welcome to the Form Validation Test Bed</h1>
		<hr/>
		<h3>Please register yourself as your Organizations Respresentative.</h3>
		<form:form action="registerOrgRep" modelAttribute="orgrep">
			<table>
				<tr>
					<td><form:label path="firstName" cssClass="clabel">First Name</form:label></td>
					<td><form:input path="firstName" placeholder="Enter First Name" cssClass="cinput"/></td>
					<td><form:errors path="firstName" cssClass="cb"/></td>
				</tr>
			
				<tr>
					<td><form:label path="lastName" cssClass="clabel">Last Name</form:label></td>
					<td><form:input path="lastName" placeholder="Enter Surname" cssClass="cinput"/></td>
					<td><form:errors path="lastName" cssClass="cb"/></td>
				</tr>
				
				<tr>
					<td><form:label path="age" cssClass="clabel">Age</form:label></td>
					<td><form:input path="age" placeholder="Enter Age" cssClass="cinput"/></td>
					<td><form:errors path="age" cssClass="cb"/></td>
				</tr>
				
				<tr>
					<td><form:label path="zipCode" cssClass="clabel">Zip Code</form:label></td>
					<td><form:input path="zipCode" placeholder="Enter Zip Code" cssClass="cinput"/></td>
					<td><form:errors path="zipCode" cssClass="cb"/></td>
				</tr>
				
				<tr>
					<td><form:label path="email" cssClass="clabel">Email</form:label></td>
					<td><form:input path="email" placeholder="Enter Email Address" cssClass="cinput"/></td>
					<td class="cb"><form:errors path="email"/>
					
						<spring:hasBindErrors name="orgrep">
							<c:forEach items="${errors.globalErrors}" var="globalError">
								<c:if test="${fn:contains(globalError, 'Email')}">
									<c:out value="${globalError.defaultMessage}"/>
								</c:if>
							</c:forEach>
						</spring:hasBindErrors>
					</td>
				</tr>
				
				<tr>
					<td><form:label path="verifyEmail" cssClass="clabel">Verify Email</form:label></td>
					<td><form:input path="verifyEmail" placeholder="Confirm Email Address" cssClass="cinput"/></td>
					<td><form:errors path="verifyEmail" cssClass="cb"/></td>
				</tr>
				
				<tr>
					<td><form:label path="password" cssClass="clabel">Password</form:label></td>
					<td><form:password path="password" placeholder="Enter Password" cssClass="cinput"/></td>
					<td class="cb"><form:errors path="password"/>
					
						<spring:hasBindErrors name="orgrep">
							<c:forEach items="${errors.globalErrors}" var="globalError">
								<c:if test="${fn:contains(globalError, 'Password')}">
									<c:out value="${globalError.defaultMessage}"/>
								</c:if>
							</c:forEach>
						</spring:hasBindErrors>
					</td>
				</tr>
				
				<tr>
					<td><form:label path="verifyPassword" cssClass="clabel">Verify Password</form:label></td>
					<td><form:password path="verifyPassword" placeholder="Confirm Password" cssClass="cinput"/></td>
					<td><form:errors path="verifyPassword" cssClass="cb"/></td>
				</tr>
	
				<tr>
					<td/>
					<td align="center"><input type="submit" value="Submit" class="csubmit"/></td>
				</tr>
			</table>
			<hr/>
			<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
			<c:if test="${formerrors ne null}">
				<a href="${contextPath}/formValidationDemo/home" style="font-size: 17px">Click here to start a fresh form!</a>
			</c:if>
		</form:form>
	</div>
</body>
</html>