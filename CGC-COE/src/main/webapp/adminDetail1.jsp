<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here admin</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="sts/admin1.css">

</head>
<body>

<jsp:include page="adminBar.jsp" />

	<br>

	<div class="row" style="margin-top: 6%;">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/StudentServlet?action=/list"
					class="btn btn-success">List of Users</a>

			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Roll No.</th>
						<th>Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.rollno}" /></td>
							<td><c:out value="${user.name}" /></td>
							<td><a href="<%=request.getContextPath()%>/StudentServlet?action=/edit&id=<c:out value='${user.rollno}' />">Edit</a>
							</td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>

</body>
</html>
