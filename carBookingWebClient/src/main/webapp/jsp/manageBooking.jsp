<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/style.css" rel="stylesheet"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Booking</title>
</head>
<body>
	<table>
		<tr>
			<th>Account Number: </th>
			<th>${rental.accounts.accNo}</th>	
		</tr>
		<tr>
			<th>Name: </th>
			<th>${rental.accounts.fname} ${rental.accounts.surname}</th>
		</tr>
		<tr>
			<th>Car: </th>
			<th>${rental.cars[0].carMake} ${rental.cars[0].carModel}</th>
			<th><a href="updateCar">Update</a></th>
		</tr>
		<tr>
			<th>Rental Date: </th>
			<th>${rental.rentalDate}</th>
			<th><a href="updateRentalDate">Update</a></th>
		</tr>
		<tr>
			<th>Return Date: </th>
			<th>${rental.returnDate}</th>
			<th><a href="updateReturnDate">Update</a></th>
		</tr>
		<tr>
			<th><a href="rentalDeleted">Delete Rental</a></th>		
		</tr>
		<tr>
			<th><a href="/">Home</a></th>		
		</tr>
	</table>
</body>
</html>