<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here index</title>
<link rel="stylesheet" href="sts/index.css">

</head>
<body class="campus"
    style="background: url(images/campus.png) center center/cover no-repeat fixed; padding: 0px;">

    <!-- Header Section with Login and Signup buttons -->
    <div style="position: absolute; top: 4%; left: 74%;">
        <button class="button-51" onclick="return false;">Login</button>
        <button class="button-51" onclick="window.location.href='signup.jsp';">Sign
            Up</button>
    </div>

    <!-- white card -->

    <div class="container">
        <div class="card">
            <div class="half image-half"></div>
            <div class="divider"></div>
            <div class="half login-half">
                <form class="login-form" action=<%= request.getContextPath()%>/Login_process method="post" style="font-family: cursive;">
                    <span class="with-line" >STUDENT'S LOGIN</span> <label
                        for="username" >Username:</label> <input type="text" id="username"
                        name="username" required placeholder="Enter Username" style="font-family: cursive;"><br> <label for="password" >Password:</label>
                    <div class="password-container">
                        <input type="password" id="password" name="password" required class="password-input" placeholder="Enter Password" style="font-family: cursive;"> <i class="toggle-password"
                            onclick="togglePasswordVisibility()">&#128065;</i>
                    </div>
                    <br>
                    <div style="padding: 0px 0px 0px 80px;">
                        <button type="submit" style="font-family: cursive;">Login</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script>
        function togglePasswordVisibility() {
            var passwordInput = document.getElementById("password");
            var icon = document.querySelector(".toggle-password");

            if (passwordInput.type === "password") {
                passwordInput.type = "text";
                icon.innerHTML = "&#128064;"; // Change eye icon to crossed eye
            } else {
                passwordInput.type = "password";
                icon.innerHTML = "&#128065;"; // Change crossed eye icon back to eye
            }
        }
    </script>


</body>
</html>
