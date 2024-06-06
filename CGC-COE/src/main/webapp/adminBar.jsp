<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS dashboard -->
<link rel="stylesheet" href="sts/dashboard.css">

<!-- Boxicons CSS -->
    <link
      href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css"
      rel="stylesheet"/>
    
</head>
<body>

<nav>
    <div class="logo">
        <i class="bx bx-menu menu-icon"></i>
        <a href="adminDash.jsp" style="color: #333;" >
        <span class="logo-name" >CGC-Landran</span></a>
    </div>

    <div class="user" style="display: contents; margin-right: 24px;">
        <div class="user-detail" style="display: grid; width: 130px;  color: #fff">
            <span>ADMIN PANNEL</span>
                <span>CGC-COE</span>
        </div>
        
        </div>

      <div class="sidebar">
        <div class="logo">
          <i class="bx bx-menu menu-icon"></i>
          
          <span class="logo-name">CGC</span>
        </div>
        
        

        <div class="sidebar-content">
          <ul class="lists">
            <li class="list">
              <a href="mstEvent.jsp" class="nav-link">
                <i class="bx bx-home-alt icon"></i>
                <span class="link">MST & Event</span>
              </a>
            </li>
            <li class="list">
              <a href="dl2.jsp" class="nav-link">
                <i class="bx bx-bar-chart-alt-2 icon"></i>
                <span class="link">Duty-Leave</span>
              </a>
            </li>
            <li class="list">
              <a href="notiAdmin.jsp" class="nav-link">
                <i class="bx bx-bell icon"></i>
                <span class="link">Notifications</span>
              </a>
            </li>
           
            <li class="list">
              <a href="adminstumaterial.jsp" class="nav-link">
                <i class="bx bx-pie-chart-alt-2 icon"></i>
                <span class="link">E-Library</span>
              </a>
            </li>
            <li class="list">
              <a href="#" class="nav-link">
                <i class="bx bx-heart icon"></i>
                <span class="link">Student Query</span>
              </a>
            </li>
            
            <li class="list">
              <a href="adminDetail1.jsp" class="nav-link">
                <i class="bx bx-bar-chart-alt-2 icon"></i>
                <span class="link">Dashboard</span>
              </a>
            </li>
            
          </ul>

          <div class="bottom-cotent">
            <li class="list">
            <form action=<%= request.getContextPath()%>/Logout method="get">
              <a href="#" class="nav-link">
                <i class="bx bx-log-out icon"></i>
                <input type="hidden", name="action" value="destroy">
                <input class="link" type="submit" value="Logout" style="background: #333; border: none;	" >
              </a>
              </form>
            </li>
          </div>
        </div>
      </div>
    </nav>

	
    <script>
      const navBar = document.querySelector("nav"),
        menuBtns = document.querySelectorAll(".menu-icon"),
        overlay = document.querySelector(".overlay");

      menuBtns.forEach((menuBtn) => {
        menuBtn.addEventListener("click", () => {
          navBar.classList.toggle("open");
        });
      });

      overlay.addEventListener("click", () => {
        navBar.classList.remove("open");
      });
    </script>

</body>
</html>
