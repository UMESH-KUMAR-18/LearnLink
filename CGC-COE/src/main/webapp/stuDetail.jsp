<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Sidebar Menu | Side Navigation Bar</title>

<link rel="stylesheet" href="sts/stuForm.css">
<!-- Boxicons CSS -->
<link href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css"
	rel="stylesheet" />
	<style>
	<style>

body{
max-width: 60%;
margin: 6% 20% 0% 20%;
}
.table table-bordered{

}

table {
	border-collapse: collapse;
	box-shadow: 0 0 12px rgba(0,0,0,0.15);
	width: 70%;
}

th, td {
	padding: 8px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}

</style>
	</style>
</head>

<body>
	<%
	String email = null, Remail = null;
	if (request.getSession().getAttribute("email") != null) {
		email = request.getSession().getAttribute("email").toString();
		Remail = email.substring(0, Math.min(email.length(), 7));
	}
	%>

	<jsp:include page="navBar.jsp" />


	<div class="home-container" style="margin-top: 6%">
		<h1>Student Details</h1>

		<div style="display: flex; width: 81%; margin-left: 18%;">

			<div class="home-form">

				<div class="home-container1">
					<strong>Name</strong> <span>${user.name}</span> <strong>D.O.B</strong>
					<span>${user.dob}</span>
				</div>

				<div class="home-container2">
					<strong>Father Name</strong> <span>${user.fatherName}</span> <strong>Mother
						Name</strong> <span>${user.motherName}</span>
				</div>

				<div class="home-container3">
					<strong>Contact Number</strong> <span>${user.contactNumber}</span>

					<strong>College Name</strong> <span>${user.collegeName}</span>

				</div>

				<div class="home-container4">
					<strong>Address</strong> <span>${user.address}</span>


				</div>

				<div class="home-container5">
					<strong>Course</strong> <span>${user.course}</span> <strong>Branch</strong>
					<span>${user.branch}</span>
				</div>
			</div>

			<div class="user-image" style="align-self: center; width: 14%;">
				<img alt="user-photo"
					src="<%=request.getContextPath()%>/fetch?column=student_photo&rollno=<%=Remail%>"
					style="width: 95%;">
			</div>

		</div>

		<h1>Schooling Details</h1>
		
		<table>
				<tr>
					<th>Class</th>
					<th>School Name</th>
					<th>Percentage Scored</th>
					<th>Passing Year</th>
					<!-- Add more table headers as needed -->
				</tr>
				<!-- Iterate over user data and display in rows -->
				<c:forEach var="user" items="${school}">
					<tr>
						<td>${user.semester}</td>
						<td>${user.percentageScoredAcademic}</td>
						<td>${user.month}</td>
						<td>${user.numOfSubjects}</td>
						
					</tr>
				</c:forEach>
			</table>
		
		

		<h1>Academic Details</h1>
		
				<table>
				<tr>
					<th>Semester</th>
					<th> Percentage Scored</th>
					<th>Month</th>
					<th>No of Subject</th>
					<!-- Add more table headers as needed -->
				</tr>
				<!-- Iterate over user data and display in rows -->
				<c:forEach var="user" items="${academic}">
					<tr>
						<td>${user.semester}</td>
						<td>${user.percentageScoredAcademic}</td>
						<td>${user.month}</td>
						<td>${user.numOfSubjects}</td>
						
					</tr>
				</c:forEach>
			</table>
		
	</div>


</body>
</html>
