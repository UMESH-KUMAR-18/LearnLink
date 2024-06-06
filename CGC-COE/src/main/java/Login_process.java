import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login_process")
public class Login_process extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Login_process() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Database connection details
        String JDBC_URL = "jdbc:mysql://localhost:3306/studentquery";
        String JDBC_USERNAME = "root";
        String JDBC_PASSWORD = "Unknown@420";

        // Retrieve username and password from login.jsp form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //admin credentails
        String adminId="UmeshKumar_18";
        String adminPass = "geekCoder@18";
        
        
        
        // Database connection and query
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet = null;
        

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);

            // Prepare SQL statement for query
            String sql = "SELECT * FROM login WHERE BINARY username=? AND BINARY Passowrd=?";
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Execute the SQL query
            resultSet = preparedStatement.executeQuery();
            
            if(username.equals(adminId) && password.equals(adminPass)) {
            	response.sendRedirect("adminDash.jsp");
            	return;
            }

            // Check if a matching user is found
            if (resultSet.next()) {
                // Valid user, redirect to a welcome page or do something else
            	String sql1 = "SELECT email FROM signup WHERE username=?";
            	String email=null;
            	preparedStatement1 = connection.prepareStatement(sql1);
                preparedStatement1.setString(1, username);
                try (ResultSet resultSet1 = preparedStatement1.executeQuery()) {
                    // Check if the result set contains a row
                    if (resultSet1.next()) {
                        // Retrieve the email from the result set
                        email = resultSet1.getString("email");
                    }
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            	

                HttpSession newSession = request.getSession();
               
              //  newSession.setMaxInactiveInterval(500);
                newSession.setAttribute("username", username);
                newSession.setAttribute("email", email);
                response.sendRedirect("dashboard.jsp");
                
            } else {
                // Invalid user, display an alert message and go back to the previous page
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().println("<script type=\"text/javascript\">");
                response.getWriter().println("alert('Invalid username and password');");
                response.getWriter().println("window.history.back();"); // Go back to the previous page (signup.jsp)
                response.getWriter().println("</script>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle database errors or other exceptions
   
        } finally {
            // Close resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}