<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	width: 100%;
}

th, td {
	padding: 8px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}

</style>
</head>
<body>
<jsp:include page="navBar.jsp" />
<a href="<%=request.getContextPath()%>/notiServlet?action=/list1"
				class="btn btn-success" style="margin-top: 6%; margin-left:35%; text-decoration: auto; color: fuchsia;">IMPORTANT NOTIFICATION</a>
<hr>
<br>

<table class="table table-bordered">
				<thead>
					<tr>
						<th>Date</th>
						<th>Announcement</th>
						<th>Link</th>
						
					</tr>
				</thead>
				<tbody>

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

				</tbody>

			</table>
		
</body>
</html>