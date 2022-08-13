<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bike Rental</title>

<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

	<form method="post"
		action="${pageContext.request.contextPath}/searchvogo.htm">
		From:<input type="text" name="formDate" /> To :<input type="text"
			name="toDate" /> <input type="submit" value="submit">
	</form>
	<br>
	<c:if test="${bikeRental ne null }">

		<table>
			<tr>
				<td>Rented Date</td>
				<td>Customer Name</td>
				<td>Bike Model Name</td>
				<td>Rta Registation No</td>
				<td>Duration</td>
				<td>Rented Amount</td>
			</tr>
			<tr>
				<td colspan="6">Export as <a
					href="${pageContext.request.contextPath}/searchvogo.htm?formDate=<fmt:formatDate value='${fromDateValue}' pattern='dd/MM/yyyy'/>&toDate=<fmt:formatDate value='${toDateValue}' pattern='dd/MM/yyyy'/>&view=xls">Xls</a>
					
					(or) <a href="${pageContext.request.contextPath}/searchvogo.htm?formDate=<fmt:formatDate value='${fromDateValue}' pattern='dd/MM/yyyy'/>&toDate=<fmt:formatDate value='${toDateValue}' pattern='dd/MM/yyyy'/>&view=pdf">Pdf</a></td>
			</tr>
			<c:forEach items="${bikeRental}" var="bikeRentals">
				<tr>
					<td><fmt:formatDate value="${bikeRentals.rentedDate}"
							pattern="dd/MM/yyyy" /></td>
					<td>${bikeRentals.customerName}</td>
					<td>${bikeRentals.bikeModelName}</td>
					<td>${bikeRentals.rtaRegistationNo}</td>
					<td>${bikeRentals.duration}</td>
					<td>${bikeRentals.amountPaid}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>