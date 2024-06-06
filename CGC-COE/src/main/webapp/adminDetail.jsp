<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="sts/stuForm.css">
</head>
<body>
	<jsp:include page="adminBar.jsp" />

	<div class="row" style="margin-top: 6%;">

		<div class="container">

			<div>
				<div class="home-container">
					<h1>Student Details</h1>
					<form class="home-form" action="<%=request.getContextPath()%>/StudentServlet?action=/update" method="post">
						
						<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.rollno}' />" />
				</c:if>
						
						<div class="home-container1">
						
							<label class="home-text01">Name</label>
							<input type="text" class="home-textinput input" name="name" value="<c:out value='${user.name}' />" />
							
							<label class="home-text02">D.O.B</label>
							<input type="date"  class="input" name="dob" value="<c:out value='${user.dob}' />" />
							
						</div>
						
						
						<div class="home-container2">
							<label class="home-text03">Father Name</label>
							<input type="text" class="home-textinput02 input" name="fatherName" value="<c:out value='${user.fatherName}' />" />
							
							<label class="home-text04">MotherName</label>
							<input type="text" class="home-textinput03 input" name="motherName" value="<c:out value='${user.motherName}' />" />
						</div>
						
						
						<div class="home-container3">
							<label class="home-text05">Contact Number </label>
							<input type="text" class="home-textinput04 input" name="contactNumber" value="<c:out value='${user.contactNumber}' />" />
							
							<label class="home-text06">Address</label>
							<input type="text" class="home-textinput05 input" name="address" value="<c:out value='${user.address}' />" />
							
						</div>
						
						
						<div class="home-container4">
						
							<label class="home-text07">Colledge Name&nbsp; </label>
							<input type="text" class="home-textinput06 input" name="collegeName" value="<c:out value='${user.collegeName}' />" />
							
						</div>
						
						
						<div class="home-container5">
							<label class="home-text08">Course&nbsp;</label>
							<input type="text" class="home-textinput07 input" name="course" value="<c:out value='${user.course}' />"  />
							
							<label class="home-text09">Branch&nbsp;</label>
							<input type="text" class="home-textinput08 input" name="branch" value="<c:out value='${user.branch}' />"  />
						</div>
						
						
						<button type="submit" class="home-button button">submit</button>
					</form>
					
					<h1>Schooling Details</h1>
					<form class="home-form1" action="<%=request.getContextPath()%>/StudentServlet?action=SchoolingDetails" method="post">
						
						<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.rollno}' />" />
				</c:if>
						
						<div class="home-container6">
							<label class="home-text11">Class</label>
							
							<select name="schoolingClass" style="align-self: center;">
							<option value="class 10">class 10</option>
							<option value="class 12">class 12</option></select>
							
							<label class="home-text12">School Name</label>
							<input type="text" name="schoolName" class="home-textinput09 input" />
							
							<label class="home-text13">% Scored</label>
							<input type="text" name="percentageScored" class="home-textinput10 input" />
							
							<label class="home-text14">Passing Year </label>
							<input type="text" name="passingYear" class="home-textinput11 input" />
						</div>
						<button type="submit" class="home-button1 button">Submit</button>
					</form>
					
					<h1>Academic Details</h1>
					<form class="home-form2" action="<%=request.getContextPath()%>/StudentServlet?action=AcademicDetails" method="post">
						
						<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.rollno}' />" />
				</c:if>
				
						<div class="home-container7">
							<label class="home-text16">Sem</label>
							
							<select name="Sem" style="align-self: center;">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								</select><label
								class="home-text17">Percentage Scored</label>
								<input type="text" class="home-textinput12 input" name="PercentageScored" />
								
								<label class="home-text18">Month&nbsp;</label>
								<input type="text" class="home-textinput13 input" name="Month" />
								
								<label class="home-text19">No of subject </label>
								<input type="text" class="home-textinput14 input" name="NoOfSubjects" />
						</div>
						<button type="submit" class="home-button2 button">Submit</button>
					</form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>