<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href="/css/style.css" rel="stylesheet"></link>
<meta charset="ISO-8859-1">
<title>Create Account</title>
</head>
<body>
	<h1>Car Hire - Create Account</h1>
	<form:form modelAttribute="rentals">
 		<table>
			<tr>
				<td>Account No:</td>
				<td><form:input  path="accounts.accNo"></form:input></td>
			</tr>
  			<tr>
				<td>First Name:</td>
				<td><form:input path="accounts.fname"></form:input></td>
			</tr>
			<tr>
				<td>Surname:</td>
				<td><form:input path="accounts.surname"></form:input></td>
			</tr>
			<tr>
				<td>Date of Birth (YYYY/mm/dd):</td>
				<td><form:input path="accounts.dob"></form:input></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="accounts.address"></form:input></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Add Account"/>
				</td>
			</tr>
		</table> 
	</form:form>
</body>
</html>