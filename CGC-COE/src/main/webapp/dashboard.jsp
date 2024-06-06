<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.net.URL"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="org.json.simple.parser.JSONParser"%>
<%@ page import="org.json.simple.JSONArray"%>
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

<link rel="stylesheet" href="sts/detail.css">

<!-- Boxicons CSS -->
<link href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css"
	rel="stylesheet" />
</head>

<body>
	<%
	// API Key
	String apiKey = "f17c40099573b9eb4b288c10a8cef367";
	// Get the city from the form input
	String city = "Chandigarh";

	// Create the URL for the OpenWeatherMap API request
	String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

	// Initialize variables to store weather information
	int temperature = 0;
	String weatherDescription = "";
	String date = "";
	String email = null, Remail = null;
	if (request.getSession().getAttribute("email") != null) {
		email = request.getSession().getAttribute("email").toString();
		Remail = email.substring(0, Math.min(email.length(), 7));
	}

	try {
		// Create URL object
		URL url = new URL(apiUrl);

		// Create HttpURLConnection
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Set request method
		connection.setRequestMethod("GET");

		// Read response
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder jsonResponse = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			jsonResponse.append(line);
		}
		reader.close();

		// Parse JSON response
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse.toString());

		// Extract temperature from JSON
		JSONObject main = (JSONObject) jsonObject.get("main");
		temperature = (int) ((double) main.get("temp") - 273.15); // Convert temperature from Kelvin to Celsius and cast to int

		// Extract weather description from JSON
		JSONArray weatherArray = (JSONArray) jsonObject.get("weather");
		if (weatherArray != null && weatherArray.size() > 0) {
			JSONObject weather = (JSONObject) weatherArray.get(0);
			weatherDescription = (String) weather.get("description");
		}

		// Extract date from JSON
		long timestamp = (long) jsonObject.get("dt");
		date = new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date(timestamp * 1000));

	} catch (Exception e) {
		e.printStackTrace();
	}
	%>

	<jsp:include page="navBar.jsp" />


	<div class="overlay">

		<div style="display: flex;">

			<div style="width: 32%" >
				<div class="weatherCast">
					<h4>Chandigarh University Wheather</h4>
					<p>
						Temperature:
						<%=temperature%>°C
					</p>
					<p>
						Description:
						<%=weatherDescription%>
						<i class='bx bx-cloud'></i>
					</p>
					<p>
						Date:
						<%=date%></p>
				</div>
				<div class="email">
					<h3>My College email</h3>
					<p>
						<%=email%>
					</p>
				</div>
				<img alt="user-photo"
					src="<%=request.getContextPath()%>/fetch?column=student_id_card_photo&rollno=<%=Remail%>"
					style="width: 79%;"><br>
					<strong style="margin-left: 19%">Student Id Card</strong>
			</div>

			<div style="width: 29%; padding: 20px 0px 0px 50px;">
				<a href="<%=request.getContextPath()%>/eventMst?action=/dashlist"
					class="btn btn-success" >Event Table</a><br>
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
			</div>

			<div style="width: 32%; padding: 20px 0px 0px 50px;">
				<a href="<%=request.getContextPath()%>/eventMst?action=/dashlistMST"
					class="btn btn-success">Exam Table</a>
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
			</div>

		</div>

	</div>

</body>
</html>
