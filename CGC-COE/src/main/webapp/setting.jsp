<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f0f0f0;
        }

        .box {
            width: 400px;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
        }

        .button-container {
            display: flex;
            justify-content: flex-start;
            margin-bottom: 20px;
        }

        .button-container button {
            margin-left: 8px;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            width: 47%;
        }

        .button-container button:hover {
            background-color: #0056b3;
        }

        .content {
            display: none;
        }

        .content.active {
            display: block;
            margin-top: 20px;
        }
    </style>
</head>
<body>


	<jsp:include page="navBar.jsp" />
	    <div class="box" style="font-family: "Poppins", sans-serif;">
        <div class="button-container">
            <button onclick="showPasswordForm('changePassword')">Change Password</button>
            <button onclick="showPasswordForm('changeLibraryPassword')">Change Library Password</button>
        </div>
        <div id="changePassword" class="content">
            <!-- Content for changing password -->
            <h4 style="color: crimson;">Change Profile Password</h4><br>

    <form action=<%= request.getContextPath()%>/update method="post" >
        <div>
            <label for="currentPassword" style=" margin-left: 13px;">Current Password:</label>
            <input type="password" id="currentPassword" name="currentPassword" required>
        </div>
        <div>
            <label for="newPassword" style=" margin-left: 37px;">New Password:</label>
            <input type="password" id="newPassword" name="newPassword" required>
        </div>
        <div>
            <label for="confirmPassword">Re-enter Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
        </div>
        <div>
        <br>
        <input type="hidden" name="formType" value="userPassword">
            <button type="submit" style=" width: 70px;">Submit</button>
        </div>
    </form>
        </div>
        <div id="changeLibraryPassword" class="content">
            <!-- Content for changing library password -->
            <h4 style="color: crimson;">Change Library Password</h4><br>
            <form action=<%= request.getContextPath()%>/update method="post" >
        <div>
            <label for="currentPassword" style=" margin-left: 13px;">Current Password:</label>
            <input type="password" id="currentPassword" name="currentPassword" required>
        </div>
        <div>
            <label for="newPassword" style=" margin-left: 37px;">New Password:</label>
            <input type="password" id="newPassword" name="newPassword" required>
        </div>
        <div>
            <label for="confirmPassword">Re-enter Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
        </div>
        <div>
        <br>
        <input type="hidden" name="formType" value="libraryPassword">
            <button type="submit" style=" width: 70px;">Submit</button>
        </div>
    </form>
        </div>
    </div>

    <script>
        function showPasswordForm(id) {
            // Hide all content elements
            var contents = document.querySelectorAll('.content');
            contents.forEach(function(content) {
                content.classList.remove('active');
            });

            // Show the selected content
            var selectedContent = document.getElementById(id);
            selectedContent.classList.add('active');
        }
    </script>
	
</body>
</html>