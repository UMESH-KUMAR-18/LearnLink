<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Document Upload</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	font-family: "Poppins", sans-serif;
}

form{
padding: 3px 0px 7px 0px;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<%
	String email = null;
	int rollno=0;
	if (request.getSession().getAttribute("email") != null) {
		email = request.getSession().getAttribute("email").toString();
		// Trim the email to first 6 characters
		email = email.substring(0, Math.min(email.length(), 7));
	}
	%>
	<jsp:include page="navBar.jsp" />
	<div class="container mt-5" style="max-width: 90%;">
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" style="margin-top: 6%;">
			<li class="nav-item"><a class="nav-link active"
				data-toggle="tab" href="#upload">Upload Documents</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#display">Display Documents</a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<!-- Tab 1: Upload Documents -->
			<div id="upload" class="container tab-pane active">

				<div style="display: flex;">

					<div style="padding: 0% 6% 0% 6%;">
						<!---->
						<strong>Student Photo</strong>
						<form action="<%=request.getContextPath()%>/upload?action=student_photo&rollno=<%=email%>&type=image" method="post"
							enctype="multipart/form-data">
							<input type="file" name="student_photo"> <input
								type="submit" value="Upload Doc.">
						</form>

						<!---->
						<strong>10 Certificate</strong>
						<form action="<%=request.getContextPath()%>/upload?action=certificate_10_pdf&rollno=<%=email%>&type=image" method="post"
							enctype="multipart/form-data">
							<input type="file" name="certificate_10_pdf"> <input
								type="submit" value="Upload Doc.">
						</form>
						
						<!---->
						<strong>PAN Card</strong>
						<form action="<%=request.getContextPath()%>/upload?action=pan_card_pdf&rollno=<%=email%>&type=pdf" method="post"
							enctype="multipart/form-data">
							<input type="file" name="pan_card_pdf"> <input
								type="submit" value="Upload Doc.">
						</form>
						
						<!---->
						<strong>Certificate 1</strong>
						<form action="<%=request.getContextPath()%>/upload?action=certificate_1_pdf&rollno=<%=email%>&type=pdf" method="post"
							enctype="multipart/form-data">
							<input type="file" name="certificate_1_pdf"> <input
								type="submit" value="Upload Doc.">
						</form>
						
						<!---->
						<strong>Certificate 3</strong>
						<form action="<%=request.getContextPath()%>/upload?action=certificate_3_pdf&rollno=<%=email%>&type=pdf" method="post"
							enctype="multipart/form-data">
							<input type="file" name="certificate_3_pdf"> <input
								type="submit" value="Upload Doc.">
						</form>
						
						<!---->
						<strong>Certificate 5</strong>
						<form action="<%=request.getContextPath()%>/upload?action=certificate_5_pdf&rollno=<%=email%>&type=pdf" method="post"
							enctype="multipart/form-data">
							<input type="file" name="certificate_5_pdf"> <input
								type="submit" value="Upload Doc.">
						</form>


					</div>

					<div>
						<!---->
						<strong>Student ID</strong>
						<form action="<%=request.getContextPath()%>/upload?action=student_id_card_photo&rollno=<%=email%>&type=image" method="post"
							enctype="multipart/form-data">
							<input type="file" name="student_photo"> <input
								type="submit" value="Upload Doc.">
						</form>

						<!---->
						<strong>12 Certificate</strong>
						<form action="<%=request.getContextPath()%>/upload?action=certificate_12_pdf&rollno=<%=email%>&type=pdf" method="post"
							enctype="multipart/form-data">
							<input type="file" name="certificate_12_pdf"> <input
								type="submit" value="Upload Doc.">
						</form>
						
						<!---->
						<strong>Addhar Card</strong>
						<form action="<%=request.getContextPath()%>/upload?action=adhaar_card_pdf&rollno=<%=email%>&type=pdf" method="post"
							enctype="multipart/form-data">
							<input type="file" name="adhaar_card_pdf"> <input
								type="submit" value="Upload Doc.">
						</form>
						
						<!---->
						<strong>Certificate 2</strong>
						<form action="<%=request.getContextPath()%>/upload?action=certificate_2_pdf&rollno=<%=email%>&type=pdf" method="post"
							enctype="multipart/form-data">
							<input type="file" name="certificate_2_pdf"> <input
								type="submit" value="Upload Doc.">
						</form>
						
						<!---->
						<strong>Certificate 4</strong>
						<form action="<%=request.getContextPath()%>/upload?action=certificate_4_pdf&rollno=<%=email%>&type=pdf" method="post"
							enctype="multipart/form-data">
							<input type="file" name="certificate_4_pdf"> <input
								type="submit" value="Upload Doc.">
						</form>
						
						<!---->
						<strong>Certificate 6</strong>
						<form action="<%=request.getContextPath()%>/upload?action=certificate_6_pdf&rollno=<%=email%>&type=pdf" method="post"
							enctype="multipart/form-data">
							<input type="file" name="certificate_6_pdf"> <input
								type="submit" value="Upload Doc.">
						</form>
						
						

					</div>
				</div>


			</div>

			<!-- Tab 2: Display Documents -->
			<div id="display" class="container tab-pane fade">


				<hr>

				<div style="display: flex;margin-bottom: 1%;">

					<a href="<%=request.getContextPath()%>/eventMst?action=/list"
						class="btn btn-success" style="margin-right: 4%">Display
						Document</a> <strong style="align-content: center;">Student
						Roll No. - <%=email%></strong>

				</div>
				

				<table>
					<tr style="background: aliceblue;">
						<th>Document Name</th>
						<th>View Document</th>
					</tr>
					
					<!--  -->
					<tr>
						<td>Aadhar card</td>
						<td><a href="<%=request.getContextPath()%>/upload?action=adhaar_card_pdf&rollno=<%=email%>&type=pdf">show the pdf</a></td>
					</tr>
					
					<!--  -->
					<tr>
						<td>Pan Card</td>
						<td><a href="<%=request.getContextPath()%>/upload?action=pan_card_pdf&rollno=<%=email%>&type=pdf">show the pdf</a></td>
					</tr>
					
					<!--  -->
					<tr>
						<td>10th certificate</td>
						<td><a href="<%=request.getContextPath()%>/upload?action=certificate_10_pdf&rollno=<%=email%>&type=pdf">show the pdf</a></td>
					</tr>
					
					<!--  -->
					<tr>
						<td>12th certificate</td>
						<td><a href="<%=request.getContextPath()%>/upload?action=certificate_12_pdf&rollno=<%=email%>&type=pdf">show the pdf</a></td>
					</tr>
					
					<!--  -->
					<tr>
						<td>Additional certificate 1</td>
						<td><a href="<%=request.getContextPath()%>/upload?action=certificate_1_pdf&rollno=<%=email%>&type=pdf">show the pdf</a></td>
					</tr>
					
					<!--  -->
					<tr>
						<td>Additional certificate 2</td>
						<td><a href="<%=request.getContextPath()%>/upload?action=certificate_2_pdf&rollno=<%=email%>&type=pdf">show the pdf</a></td>
					</tr>
					
					<!--  -->
					<tr>
						<td>Additional certificate 3</td>
						<td><a href="<%=request.getContextPath()%>/upload?action=certificate_3_pdf&rollno=<%=email%>&type=pdf">show the pdf</a></td>
					</tr>
					
					<!--  -->
					<tr>
						<td>Additional certificate 4</td>
						<td><a href="<%=request.getContextPath()%>/upload?action=certificate_4_pdf&rollno=<%=email%>&type=pdf">show the pdf</a></td>
					</tr>
					
					<!--  -->
					<tr>
						<td>Additional certificate 5</td>
						<td><a href="<%=request.getContextPath()%>/upload?action=certificate_5_pdf&rollno=<%=email%>&type=pdf">show the pdf</a></td>
					</tr>
					
					<!--  -->
					<tr>
						<td>Additional certificate 6</td>
						<td><a href="<%=request.getContextPath()%>/upload?action=certificate_6_pdf&rollno=<%=email%>&type=pdf">show the pdf</a></td>
					</tr>
					
					
				</table>


			</div>
		</div>
	</div>

	<!-- Include Bootstrap JS for tab functionality -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
