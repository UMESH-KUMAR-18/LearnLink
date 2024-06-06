<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="sts/detail.css">
</head>

<style>
a {
	color: #007bff;
	text-decoration: none;
	background-color: transparent;
}

.container {
	display: flex;
	justify-content: space-evenly;
	margin: 20px;
	margin-top: 6%;
}

.half {
	width: 70%; /* Adjust width as needed */
	border: 1px solid #ccc;
	padding: 10px;
	margin-bottom: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

table {
	border-collapse: collapse;
	width: 100%;
}

input {
	height: 1%;
	border-radius: 7px;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}
</style>

<body>

	<jsp:include page="adminBar.jsp" />

	<div class="container">
		<div class="half">
			<h3 style="text-align: center;">Notification Management</h3>
			<hr>
			<!-- User Form -->
			<form
				action="<%=request.getContextPath()%>/notiServlet?action=/insert"
				method="post">
				<div
					style="display: flex; justify-content: space-evenly; padding: 12px 0px 12px 0px;">

					<label for="date">Date:</label> <input type="date" id="date"
						name="date"> <label for="eventName">Event Name:</label>
					<textarea id="eventName" name="eventName" rows="4" cols="40"></textarea>

					<label for="id">link:</label> <input type="text" id="id" name="id"
						style="height: 1%; width: 19%;">

				</div>
				<hr>
				<!-- Add more fields as needed -->
				<!-- Submit button -->
				<div style="text-align: center; padding: 8px 0px 0px 0px;">
					<input type="submit" value="Add Notice"
						style="color: #fff; background-color: #28a745; border-color: #28a745;">
				</div>
			</form>
			<!-- User Table -->
			<a href="<%=request.getContextPath()%>/notiServlet?action=/list"
				class="btn btn-success">Notification Table</a>

			<table>
				<tr>
					<th>Date</th>
					<th>Notification</th>
					<th>Link</th>
					<!-- Add more table headers as needed -->
				</tr>
				<!-- Iterate over user data and display in rows -->
				<c:forEach var="user" items="${notifications}">
					<tr>
						<td>${user.date}</td>
						<td>${user.eventName}</td>
						<td><c:choose>
								<c:when test="${user.link eq 'n/a'}">
									<strong>n/a</strong>
								</c:when>
								<c:otherwise>
									<a href="${user.link}">Link</a>
								</c:otherwise>
							</c:choose></td>
						<!-- Add more table data fields as needed -->
					</tr>
				</c:forEach>
			</table>
			<a href="<%=request.getContextPath()%>/notiServlet?action=notification">DROP</a>

		</div>
</body>
</html>