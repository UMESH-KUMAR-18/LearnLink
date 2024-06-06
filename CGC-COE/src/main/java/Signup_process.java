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

@WebServlet("/Signup_process")
public class Signup_process extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String JDBC_URL = "jdbc:mysql://localhost:3306/studentquery";
            String JDBC_USERNAME = "root";
            String JDBC_PASSWORD = "Unknown@420";

            // Retrieve username and password from signup.jsp form
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String cPassword = request.getParameter("cPassword");
            
            // Database connection and update
            Connection connection = null;
            

            // Database connection and insertion
            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish connection to the database
                connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
                
                //retriving the email status
                String checkEmailQuery = "SELECT COUNT(*) FROM signup WHERE username=?";
                PreparedStatement preparedStatement3 = connection.prepareStatement(checkEmailQuery);
                preparedStatement3.setString(1, username);
                ResultSet resultSet = preparedStatement3.executeQuery();
                
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    if (count > 0) {
                        // Email already exists in the database, handle accordingly (e.g., display error message)
                        // For example, you can redirect back to signup.jsp with an error message
                        /* response.sendRedirect("NewFile.html");
                        return; // Exit the script */
                        // Invalid user, display an alert message and go back to the previous page
                        response.setContentType("text/html;charset=UTF-8");
                        response.getWriter().println("<script type=\"text/javascript\">");
                        response.getWriter().println("alert('username already existed');");
                        response.getWriter().println("window.history.back();"); // Go back to the previous page (signup.jsp)
                        response.getWriter().println("</script>");
                       
                        return; // Exit the script
                    }
                }
                
                // Prepare SQL statement for insertion
              
                String sql = "INSERT INTO signup (username,email,Passowrd) VALUES (?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, cPassword);
                int rowsAffected = preparedStatement.executeUpdate();
                
                //ading the user int the login table
                String sql1 = "INSERT INTO login (username,Passowrd) VALUES (?,?)";
                PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
                preparedStatement1.setString(1, username);
                preparedStatement1.setString(2, password);
                int rowsAffected1 = preparedStatement1.executeUpdate();
                
              //ading the user int the library table
                String sql2 = "INSERT INTO login (username,Passowrd) VALUES (?,?)";
                PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
                preparedStatement2.setString(1, username);
                preparedStatement2.setString(2, password);
                
                int rollno = 0;
                rollno = Integer.parseInt(email.substring(0, Math.min(email.length(), 7)));

                // Execute the SQL statement
                int rowsAffected2 = preparedStatement2.executeUpdate();

                // Close resources
                preparedStatement.close();
                connection.close();

                // Redirect to a success page or provide a success message
                response.sendRedirect("index.jsp");
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
