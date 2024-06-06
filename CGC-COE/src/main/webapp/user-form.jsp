<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

<jsp:include page="adminBar.jsp" />
	
	<div class="container col-md-5" style="
    margin-top: 10%;">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="<%=request.getContextPath()%>/UserServlet?action=/update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="<%=request.getContextPath()%>/UserServlet?action=/insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label> User Name</label> <input type="text"
						value="<c:out value='${user.username}' />" class="form-control"
						name="username" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>User Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Password</label> <input type="text"
						value="<c:out value='${user.passowrd}' />" class="form-control"
						name="Passowrd">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				<a href="<%=request.getContextPath()%>/UserServlet?action=/list"
					class="btn btn-success">Users</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>


