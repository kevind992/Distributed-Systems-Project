<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/css/style.css" rel="stylesheet"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Return Date</title>
</head>
<body>
	<form:form modelAttribute="rentals" varStatus="vs">
		<table>
			<tr>
				<td>Enter Updated Return Date:</td>
			</tr>
			<tr>
				<td>Format YYYY/mm/DD</td>
				<td><form:input path="returnDate"></form:input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update Return Date" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>