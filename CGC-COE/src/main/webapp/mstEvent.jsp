<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <style>
    a{
    color: #007bff;
    text-decoration: none;
    background-color: transparent;
    }
    
.container {
	display: flex;
	justify-content: space-evenly;
	margin: 20px;
	margin-top: 9%;
	
}

.half {
	width: 48%; /* Adjust width as needed */
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

input{
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
            <h3 style="text-align: center;">Event Management</h3>
            <hr>
            <!-- User Form -->
            <form
				action="<%=request.getContextPath()%>/eventMst?action=/insert" 
				method="post">
				<div style=" display: flex; justify-content: space-evenly; padding: 12px 0px 12px 0px;">
				<label for="id">ID:</label>
                <input type="text" id="id" name="id" style="
    height: 1%; width: 19%; ">
                
                <label for="eventName">Event Name:</label>
                <input type="text" id="eventName" name="eventName">
               
                
                <label for="date">Date:</label>
                <input type="date" id="date" name="date">
                 </div>
                 <hr>
                <!-- Add more fields as needed -->
                <!-- Submit button -->
               <div style="text-align: center;padding: 8px 0px 0px 0px;">
               <input type="submit" value="Add Event" style="color: #fff;background-color: #28a745;border-color: #28a745;
"></div> 
            </form>
            <!-- User Table -->
<a href="<%=request.getContextPath()%>/eventMst?action=/list" class="btn btn-success">Event Table</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Event Name</th>
                    <th>Date</th>
                    <!-- Add more table headers as needed -->
                </tr>
                <!-- Iterate over user data and display in rows -->
                <c:forEach var="user" items="${listUser}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.date}</td>
                        <!-- Add more table data fields as needed -->
                    </tr>
                </c:forEach>
            </table>
 <a href="<%=request.getContextPath()%>/eventMst?action=event">DROP</a>
            
        </div>
        <div class="half">
            <h3 style="text-align: center;">Datesheet Management</h3><hr>
            <!-- Event Form -->
            <form
				action="<%=request.getContextPath()%>/eventMst?action=/insertMST"
				method="post">
				
				<div style="display: flex;  margin-top: 1%;">
				<label for="id" style="margin-right: 10%;">ID:</label>
                <input type="text" id="id" name="id"style="margin-right: 15%;"><br>
                
                <label for="subject">Subject:</label>
                <input type="text" id="subject" name="subject"><br>
                </div>
                
                <div style="display: flex; margin-top: 1%;">
           
                <label for="subCode">Sub Code:</label>
                <input type="text" id="subCode" name="subCode" style=" margin-right: 19%;"><br>
                
                <label for="date">Date:</label>
                <input type="date" id="date" name="date" style="margin-bottom: 1%"><br>
                </div>
                
                <!-- Submit button -->
                <hr>
                <div style="text-align: center;padding: 8px 0px 0px 0px;">
                
                <input type="submit" value=" Add " style="color: #fff;background-color: #28a745;border-color: #28a745;">
            	</div>
            </form>
            <!-- Event Table -->
<a href="<%=request.getContextPath()%>/eventMst?action=/listMST" class="btn btn-success">Exam Table</a>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Subject</th>
                    <th>Sub Code</th>
                    <th>Date</th>
                    <!-- Add more table headers as needed -->
                </tr>
                <!-- Iterate over event data and display in rows -->
                <c:forEach var="event" items="${eventList}">
                    <tr>
                        <td>${event.id}</td>
                        <td>${event.subject}</td>
                        <td>${event.code}</td>
                        <td>${event.date}</td>
                        <!-- Add more table data fields as needed -->
                    </tr>
                </c:forEach>
            </table>
           <a href="<%=request.getContextPath()%>/eventMst?action=mst">DROP</a>
        </div>
    </div>
</body>
</html>


</body>
</html>