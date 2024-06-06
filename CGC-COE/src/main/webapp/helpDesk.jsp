<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style data-tag="default-style-sheet">
html {
	font-family: Inter;
	font-size: 16px;
}

body {
	font-weight: 400;
	font-style: normal;
	text-decoration: none;
	text-transform: none;
	letter-spacing: normal;
	line-height: 1.15;
	color: var(--dl-color-gray-black);
	background-color: var(--dl-color-gray-white);
}
</style>
<link rel="stylesheet" href="sts/helpdesk.css">
<link rel="stylesheet"
	href="https://unpkg.com/animate.css@4.1.1/animate.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Inter:wght@100;200;300;400;500;600;700;800;900&amp;display=swap"
	data-tag="font" />
<link rel="stylesheet"
	href="https://unpkg.com/@teleporthq/teleport-custom-scripts/dist/style.css" />

</head>
<body>
	<jsp:include page="navBar.jsp" />

	<link rel="stylesheet" href="./style.css" />
	<div>
		<link href="./index.css" rel="stylesheet" />
		<div class="home-container">
			<h3 class="home-text">Query Generator&nbsp;</h3>
			<form class="home-form">
				<div class="home-container01">
					<div class="home-container02">
						<label>Query Type -</label><select>
							<option value="Result">Result</option>
							<option value="Date Sheet">Date Sheet</option>
							<option value="DMC">DMC</option>
							<option value="Degree">Degree</option>
							<option value="Final/MST Exam">Final/MST Exam</option>
							<option value="Other">Other</option>

						</select>
					</div>
					<div class="home-container03">
						<label>Sub-Type -&nbsp;</label><input type="text"
							placeholder="placeholder" class="home-textinput input" />
					</div>
					<div class="home-container04">
						<label>Semester -</label><select>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
						</select>
					</div>
				</div>
				<div class="home-container05">
					<div class="home-container06">
						<label>Remark -&nbsp;</label>
					</div>
					<textarea placeholder="placeholder" class="home-textarea textarea"></textarea>
				</div>
				<div class="home-container07">
					<div class="home-container08">
						<label>G-Drive Link -&nbsp;</label><input type="text"
							placeholder="placeholder" class="home-textinput1 input" />
					</div>
					<button type="button" class="home-button button">Submit</button>
				</div>
			</form>
			<h3 class="home-text6">Query Status&nbsp;</h3>
			<form class="home-form1">
				<div class="home-container09">
					<div class="home-container10">
						<label>Query No -&nbsp;</label><input type="text"
							placeholder="placeholder" class="home-textinput2 input" />
					</div>
					<button type="button" class="home-button1 button">Button</button>
				</div>
			</form>
			
			<table class="table table-bordered">

				<c:if test="${query != null}">

					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Password</th>
							<th>Actions</th>
						</tr>
					</thead>

				</c:if>


				<tbody>

					<c:forEach var="user" items="${query}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.passowrd}" /></td>
							<td><a
								href="<%=request.getContextPath()%>/UserServlet?action=/edit&id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="<%=request.getContextPath()%>/UserServlet?action=/delete&id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
			
			<h3 class="home-text8">Query History&nbsp;</h3>
			<table class="table table-bordered">

				<c:if test="${listUser != null}">

					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Password</th>
							<th>Actions</th>
						</tr>
					</thead>

				</c:if>


				<tbody>

					<c:forEach var="user" items="${history}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.passowrd}" /></td>
							<td><a
								href="<%=request.getContextPath()%>/UserServlet?action=/edit&id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="<%=request.getContextPath()%>/UserServlet?action=/delete&id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>

</body>
</html>