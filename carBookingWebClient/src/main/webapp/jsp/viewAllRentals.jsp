<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/css/style.css" rel="stylesheet"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin - View All Bookings</title>
</head>
<body>
<h1>Admin - View All Rentals</h1>
<table>
  <tr>
   <th>Acc No</th>
   <th>First Name</th>
   <th>Surname</th>
   <th>DOB</th>
   <th>Address</th>
   <th>Car Make</th>
   <th>Car Model</th>
   <th>Rental Date</th>
   <th>Return Date</th>
  </tr>
  <tr>
    <c:forEach items="${rentals}" var="rentals">
      <tr> 
        <td >${rentals.accounts.accNo}</td>
		<td >${rentals.accounts.fname}</td>
		<td >${rentals.accounts.surname}</td>
		<td >${rentals.accounts.dob}</td>
		<td >${rentals.accounts.address}</td>
		<td >${rentals.cars[0].carMake}</td>
		<td >${rentals.cars[0].carModel}</td>
		<td >${rentals.rentalDate}</td>
		<td >${rentals.returnDate}</td>
	</c:forEach>
  </tr>
</table>
 <a href="/">Home</a>
</body>
</html>