

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String JDBC_URL = "jdbc:mysql://localhost:3306/studentquery";
	        String JDBC_USERNAME = "root";
	        String JDBC_PASSWORD = "Unknown@420";

	        // Retrieve username and password from login.jsp form
	        String currentPassword = request.getParameter("currentPassword");
	        String newPassword = request.getParameter("newPassword");
	        String rePassword = request.getParameter("confirmPassword");
	        String formType = request.getParameter("formType");
	        String username = request.getSession().getAttribute("username").toString();
	        
	        
	        // Database connection and update
            Connection connection = null;
            

            // Database connection and insertion
            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish connection to the database
                connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
                
                if(formType.equals("userPassword") && newPassword.equals(rePassword)) {
                	String sql ="UPDATE login SET Passowrd = ? WHERE username = ? AND Passowrd = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, rePassword);
                    preparedStatement.setString(2, username);
                    preparedStatement.setString(3, currentPassword);
                    int rowsAffected = preparedStatement.executeUpdate();
                    
                    preparedStatement.close();
                    connection.close();
                    

                    response.setContentType("text/html;charset=UTF-8");
                    response.getWriter().println("<script type=\"text/javascript\">");
                    response.getWriter().println("alert('profile password has been changes successfully');");
                    response.getWriter().println("window.history.back();"); // Go back to the previous page (signup.jsp)
                    response.getWriter().println("</script>");
                   return;

                    // Redirect to a success page or provide a success message
                    //response.sendRedirect("setting.jsp");
                
                    
    	        }else if(formType.equals("libraryPassword")&& newPassword.equals(rePassword) ) {
    	        	String sql ="UPDATE library SET Password = ? WHERE username = ? AND Password = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, rePassword);
                    preparedStatement.setString(2, username);
                    preparedStatement.setString(3, currentPassword);
                    int rowsAffected = preparedStatement.executeUpdate();
                    
                    preparedStatement.close();
                    connection.close();
                    
                    // Invalid user, display an alert message and go back to the previous page
                    response.setContentType("text/html;charset=UTF-8");
                    response.getWriter().println("<script type=\"text/javascript\">");
                    response.getWriter().println("alert('library password has been changes succesfully');");
                    response.getWriter().println("window.history.back();"); // Go back to the previous page (signup.jsp)
                    response.getWriter().println("</script>");
                    return;
                    // Redirect to a success page or provide a success message
                   // response.sendRedirect("setting.jsp");
                   

                    
    	        }else {
    	        	 // Invalid user, display an alert message and go back to the previous page
                    response.setContentType("text/html;charset=UTF-8");
                    response.getWriter().println("<script type=\"text/javascript\">");
                    response.getWriter().println("alert('something went wrong please try again');");
                    response.getWriter().println("window.history.back();"); // Go back to the previous page (signup.jsp)
                    response.getWriter().println("</script>");
                   
                    return; // Exit the script
    	        }

              
            } catch (Exception e) {
                e.printStackTrace();
                // Redirect to an error page or display an error message
                
            } finally {
                // Close connection
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
	         
	        
	}
}
