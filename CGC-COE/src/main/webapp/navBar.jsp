<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sidebar Menu | Side Navigation Bar dashboard</title>
 <link
      href="sts/dashboard.css"
      rel="stylesheet"
    />


    <!-- Boxicons CSS -->
    <link
      href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css"
      rel="stylesheet"
    />
  </head>
  <body>
  <%
    String username = null;
    String email = null;
    if (request.getSession().getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
    } else {
        username = request.getSession().getAttribute("username").toString();
        if (request.getSession().getAttribute("email") != null) {
            email = request.getSession().getAttribute("email").toString();
            // Trim the email to first 6 characters
            email = email.substring(0, Math.min(email.length(), 7));
        }
    }
%>
<nav>
    <div class="logo">
        <i class="bx bx-menu menu-icon"></i>
        <a href="dashboard.jsp" style="color: #333;" >
        <span class="logo-name" >CGC-Landran</span></a>
    </div>

    <div class="user" style="display: contents; margin-right: 24px;">
        <div class="user-detail" style="display: grid; width: 130px;  color: #fff">
            <span><%= username %></span>
            <% if (email != null) { %>
                <span><%= email %></span>
            <% } %>
        </div>
        
        <div class="user-image" >
        <img alt="user-photo" src="<%=request.getContextPath()%>/fetch?column=student_photo&rollno=<%=email %>" style="width: 48px; border-radius: 51%; text-align: end;">
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
              <a href="<%=request.getContextPath()%>/StudentServlet?action=stuDetail&id=<%=email %>" class="nav-link">
                <i class="bx bx-home-alt icon"></i>
                <span class="link">Dashboard</span>
              </a>
            </li>
            <li class="list">
              <a href="dl.jsp" class="nav-link">
                <i class="bx bx-bar-chart-alt-2 icon"></i>
                <span class="link">Duty-Leave</span>
              </a>
            </li>
            <li class="list">
              <a href="notification.jsp" class="nav-link">
                <i class="bx bx-bell icon"></i>
                <span class="link">Notifications</span>
              </a>
            </li>
            
            <li class="list">
              <a href="studyMaterial.jsp" class="nav-link">
                <i class="bx bx-pie-chart-alt-2 icon"></i>
                <span class="link">E-Library</span>
              </a>
            </li>
            <li class="list">
              <a href="helpDesk.jsp" class="nav-link">
                <i class="bx bx-heart icon"></i>
                <span class="link">Student Query</span>
              </a>
            </li>
            <li class="list">
              <a href="file.jsp" class="nav-link">
                <i class="bx bx-folder-open icon"></i>
                <span class="link">Files</span>
              </a>
            </li>
          </ul>

          <div class="bottom-cotent">
            <li class="list">
              <a href="setting.jsp" class="nav-link">
                <i class="bx bx-cog icon"></i>
                <span class="link">Settings</span>
              </a>
            </li>
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

