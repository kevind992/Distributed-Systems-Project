<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/style.css" rel="stylesheet"></link>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Manage Booking</h1>
	<h4>Please Enter your Account Number</h4>
	<form:form modelAttribute="rentals">
		<table>
			<tr>
				<td>Account No:</td>
				<td><form:input path="accounts.accNo"></form:input></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Search Account"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>