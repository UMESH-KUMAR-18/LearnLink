<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here signup</title>
 <link href="sts/signup1.css" rel="stylesheet"/>

</head>
<body class="campus"
    style="background: url(images/campus.png) center center/cover no-repeat fixed; padding: 0px">

    <!-- Header Section with Login and Signup buttons -->
    <div style="position: absolute; top: 4%; left: 74%;">
        <button class="button-51" onclick="return false;">Sign Up</button>
        <button class="button-51" onclick="window.location.href='index.jsp';">Login</button>
    </div>

    <!-- white card -->

    <div class="container">
        <div class="card">
            <div class="half image-half" style="font-family: cursive;">
                <p>Sign up to access your Student Services and Account.</p>
                <hr>
                <p>The LEARN LINK will keep a record of your progress and keep
                    you apprised of the latest updates.</p>
                <hr>
                <h3 style="padding-left: 23%;">GCG-COE</h3>
            </div>
            <div class="divider"></div>
            <div class="half login-half">
                <form class="login-form" action=<%= request.getContextPath() %>/Signup_process method="post">
                    <span class="with-line">SIGN UP TO PORTAL</span> <label
                        for="username">Username:</label> <input type="text" id="username"
                        name="username" required placeholder="Enter Username"><br>
                        
                    <label for="email">Email:</label> 
                    <input type="text" id="email" name="email" required placeholder="Enter Email"><br>
                        
                    <label for="password">Password:</label>

                        <input type="password" id="password" name="password" required
                            class="password-input" placeholder="Enter Password"><br>
                    
                    
                    <label for="comfirm password">Confirm Password:</label> 
                    <input type="password" id="cPassword" name="cPassword" required placeholder="Re-Enter Password"><br>
                    
                    <div style="padding: 0px 0px 0px 80px;">
                        <button type="submit">SignUP</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>