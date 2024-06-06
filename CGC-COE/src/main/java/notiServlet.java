import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.noti;

@WebServlet("/notiServlet")
public class notiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Database connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/studentquery";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "Unknown@420";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("/insert")) {
            insertNotification(request, response);
        }
    }

    private void insertNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	String date = request.getParameter("date");
        String eventName = request.getParameter("eventName");
        String link = request.getParameter("id");

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // Establish database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            
            // Prepare SQL statement
            String sql = "INSERT INTO notification (date, event_name, link) VALUES (?, ?, ?)";
           
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, date);
            pstmt.setString(2, eventName);
            pstmt.setString(3, link);
            System.out.println(sql);
            // Execute SQL statement
            pstmt.executeUpdate();
            
            // Redirect to notification table
            response.sendRedirect(request.getContextPath() + "/notiServlet?action=/list");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle any errors - display error message or redirect to an error page
        } finally {
            // Close database resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("/list")) {
            listNotifications(request, response, action);
        }else if(action.equals("notification")) {
        	try {
				truncate(request,response,action);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else if(action.equals("/list1")) {
            listNotifications(request, response,action);
        }
    }
    
    private void truncate(HttpServletRequest request, HttpServletResponse response, String action) throws SQLException, IOException {
    	 Connection conn = null;
         PreparedStatement pstmt = null;

    	try {
    		 // Establish database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            // Prepare SQL statement
            String sql = "TRUNCATE TABLE "+action+";";
            pstmt = conn.prepareStatement(sql);
            System.out.println(sql);
            // Execute SQL statement
            pstmt.executeUpdate();
            
            // Redirect to notification table
            response.sendRedirect(request.getContextPath() + "/notiServlet?action=/list");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle any errors - display error message or redirect to an error page
        } finally {
            // Close database resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
	}

    private void listNotifications(HttpServletRequest request, HttpServletResponse response, String action) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<noti> notifications = new ArrayList<>();
        try {
            // Establish database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            
            // Prepare SQL statement
            String sql = "SELECT * FROM notification";
            pstmt = conn.prepareStatement(sql);
            System.out.println(sql);
            // Execute SQL query
            rs = pstmt.executeQuery();
            
            // Process result set
            while (rs.next()) {
                String date = rs.getString("date");
                String eventName = rs.getString("event_name");
                String link = rs.getString("link");
                notifications.add(new noti(date, eventName, link));
            }
            
            // Set notifications attribute and forward to JSP
            if(action.equals("/list1")) {
            	request.setAttribute("notifications", notifications);
                request.getRequestDispatcher("/notification.jsp").forward(request, response);
                return;
            }
            request.setAttribute("notifications", notifications);
            request.getRequestDispatcher("notiAdmin.jsp").forward(request, response);
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle any errors - display error message or redirect to an error page
        } finally {
            // Close database resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
